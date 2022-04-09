package com.tea.lesson03.controller;

import com.alibaba.fastjson.JSONArray;
import com.tea.lesson03.pojo.Line;
import com.tea.lesson03.pojo.Station;
import com.tea.lesson03.service.CityServiceImpl;
import com.tea.lesson03.service.LineServiceImpl;
import com.tea.lesson03.service.StationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/4/1 9:29
 */
@Controller
public class AddController {
    private final String pathPre = "C:\\CS\\Java\\IdeaProjects\\Lesson03\\src\\main\\java\\com\\tea\\lesson03\\function\\";
    private final LineServiceImpl lineService;
    private final StationServiceImpl stationService;
    private final CityServiceImpl cityService;

    public AddController(LineServiceImpl lineService, StationServiceImpl stationService, CityServiceImpl cityService) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.cityService = cityService;
    }

    //跳转到建表页面
    @RequestMapping("/toInputTable")
    public String toInputTable() {
        return "/inputTable";
    }

    //创建线路表
    @RequestMapping("/insertTable")
    public String insertTable(HttpServletRequest request,
                              HttpSession httpSession,
                              HttpServletResponse response) {
        String cityNameEn = request.getParameter("cityName").substring(0, request.getParameter("cityName").indexOf(','));
        String cityNameZh = request.getParameter("cityName").substring(request.getParameter("cityName").indexOf(',') + 1);

        String path = pathPre + cityNameEn + "station.txt";
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tableName", cityNameEn + "line");
        if (lineService.isTableExist(hashMap) == 0) {       //表不存在
            if (lineService.insertTable(hashMap) != 0) {        //建表失败
                return cityNameZh + "市线路表创建失败";
            }
        } else {
            return cityNameZh + "市线路表已经存在";
        }

        if (httpSession.getAttribute("cityNameEn") != null) {
            httpSession.removeAttribute("cityNameEn");
        } else if (httpSession.getAttribute("cityNameZh") != null) {
            httpSession.removeAttribute("cityNameZh");
        }

        httpSession.setAttribute("cityNameEn", cityNameEn);
        httpSession.setAttribute("cityNameZh", cityNameZh);

        response.setContentType("text/html; charset=UTF-8");
        try {
            response.getWriter().print("<html><body><script type='text/javascript'>alert('" + cityNameZh + "市线路表创建成功');</script></body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        cityService.insert(cityNameEn + "," + cityNameZh);

        return "/inputTable";        //跳转到添加数据页面
    }

    //跳转到插入数据页面
    @RequestMapping("/toInputData")
    public String toInputData() {
        return "/inputData";
    }

    //新建线路站点
    @RequestMapping("/insertLine")
    @ResponseBody
    public String insertData(@RequestBody String str,
                             HttpSession httpSession) {
        System.out.println(str);

        //解析字符串
        String tempStationStr = str.substring(str.indexOf('[') + 1, str.indexOf(']'));
        str = str.substring(str.indexOf(']') + 2);

//        System.out.println("station解析完 =》 " + tempStationStr);
//        System.out.println("解析完station后的str =》" + str);

        String tempLineId = str.substring(str.indexOf(':') + 2, str.indexOf(',') - 1);
        str = str.substring(str.indexOf(',') + 1);

//        System.out.println("lineId解析完 =》 " + tempLineId);
//        System.out.println("解析完lineId后的str =》" + str);

        int tempIsRing = Integer.parseInt(str.substring(str.indexOf(':') + 2, str.indexOf(',') - 1));
        str = str.substring(str.indexOf(',') + 1);

//        System.out.println("isRing解析完 =》 " + tempIsRing);
//        System.out.println("解析完isRing后的str =》" + str);

        String tempLineName = str.substring(str.indexOf(':') + 2, str.indexOf('}') - 1);

//        System.out.println("lineName解析完 =》 " + tempLineName);

        String tempStationId = "";
        String tempStation[] = tempStationStr.split(",");
        List<Station> stationList = new ArrayList<>();

        for (int i = 0, index = 0; i < tempStation.length - 1; i += 2, index++) {
            Station station = new Station();
            station.setStationId(tempStation[i + 1].substring(1, tempStation[i + 1].length() - 1));     //设置站点信息
            tempStationId += tempStation[i + 1].substring(1, tempStation[i + 1].length() - 1);

            if (tempIsRing == 1 && index == 0) {        //是否是环线
                station.setRingFlag(tempLineId);
            } else {
                station.setRingFlag("0");
            }

            station.setStationName(tempStation[i].substring(1, tempStation[i].length() - 1));
            stationList.add(index, station);
        }

        System.out.println("stationList => " + stationList);

        tempStationId = "";
        for (Station station : stationList) {
            tempStationId += station.getStationId() + ",";
        }
        tempStationId = tempStationId.substring(0, tempStationId.length() - 1);     //去除最后一个逗号

        Line line = new Line();
        line.setLineId(tempLineId);
        line.setIsRing(tempIsRing);
        line.setLineName(tempLineName);
        line.setStations(stationList);
        line.setStationId(tempStationId);
        line.setStationNum(line.getStationId());
        line.setStationIds(line.getStationId());

        System.out.println(line);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("tableName", httpSession.getAttribute("cityNameEn") + "line");
        if (lineService.isTableExist(hashMap) == 0) {       //线路表不存在
            if (lineService.insertTable(hashMap) == 0) {     //线路表新建失败
                return "error";
            }
        }

        hashMap.put("lineId", tempLineId);
        hashMap.put("stationId", tempStationId);
        hashMap.put("lineName", tempLineName);

        if (lineService.insertData(hashMap) == 0) {     //数据插入失败
            return "error";
        }

        hashMap.clear();
        hashMap.put("tableName", httpSession.getAttribute("cityNameEn") + "station");
        if (stationService.isTableExist(hashMap) == 0) {        //站点表存在
            if (stationService.insertTable(hashMap) == 0) {     //站点表创建失败
                return "error";
            }
        }

        hashMap.put("stationList", stationList);
        if (stationService.insertData(hashMap) == 0) {
            return "error";
        }

        String path = pathPre + httpSession.getAttribute("cityNameEn") + "station.txt";
        String path2 = pathPre + httpSession.getAttribute("cityNameEn") + "station2.txt";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "GBK"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path2), "GBK"));
            byte[] bytes = new byte[1024];

            //判断是否是第一次写入，第一次就初始化，否则就把地铁线路数加一写入新文件
            String lineNum = in.readLine();
            if (lineNum == null || lineNum.equals("")) {
                out.write("1" + "\n");
                out.write(tempLineId + " ");

                int tempSize = stationList.size();
                if (tempIsRing == 0) {      //说明当前线路是环线
                    tempSize++;     //环线需要写入的站数加一

                    out.write(tempSize + "\n");
                    for (int i = 0; i < tempSize - 1; i++) {
                        out.write(stationList.get(i).getStationName() + " " + "0" + "\n");
                    }
                    out.write(stationList.get(0).getStationName() + " " + "0");
                } else {
                    out.write(tempSize + "\n");
                    for (int i = 0; i < tempSize - 1; i++) {
                        out.write(stationList.get(i).getStationName() + " " + "0" + "\n");
                    }
                    out.write(stationList.get(tempSize - 1).getStationName() + " " + "0");
                }
            } else {
                out.write(Integer.parseInt(lineNum) + 1);

                String tempStr = "";
                int tempFlag = 0;
                while (tempFlag <= 1) {
                    tempStr = in.readLine();

                    if (tempStr == null || tempStr.equals("")) {
                        tempFlag++;
                    } else {
                        tempFlag = 0;
                        int tempFileIndex = Integer.parseInt(tempStr.substring(tempStr.indexOf(" ") + 1));

                        out.write("\n");
                        if (tempFileIndex == 0) {       //说明当前站此前只录入过一次
                            String tempFileName = tempStr.substring(0, tempStr.indexOf(" "));

                            int tempIndex = 0;      //标志位
                            for (int i = 0; i < stationList.size() || tempIndex != 0; i++) {
                                if (stationList.get(i).getStationName().equals(tempFileName)) {
                                    out.write(tempFileName + " " + "1");
                                    tempIndex++;
                                }
                            }

                            if (tempIndex == 0) {
                                out.write(tempStr);
                            }
                        } else {
                            out.write(tempStr);      //原封输出
                        }
                    }
                }
            }

            out.flush();
            in.close();
            out.close();

            in = new BufferedReader(new InputStreamReader(new FileInputStream(path2), "GBK"));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "GBK"));

            String tempStr = "";
            Boolean bTempFlag = false;
            int tempFlag = 0;
            while (tempFlag <= 1) {     //把新文件覆盖原文件
                tempStr = in.readLine();

                if (tempStr == null) {
                    tempFlag++;
                } else {
                    if (bTempFlag) {
                        out.write("\n");
                    }

                    out.write(tempStr);
                    bTempFlag = true;
                }
            }

            File file = new File(path2);
            file.delete();

            out.flush();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }


}

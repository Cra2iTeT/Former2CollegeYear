package com.tea.lesson03.controller;

import com.tea.lesson03.pojo.City;
import com.tea.lesson03.pojo.Line;
import com.tea.lesson03.pojo.Station;
import com.tea.lesson03.service.CityServiceImpl;
import com.tea.lesson03.service.LineServiceImpl;
import com.tea.lesson03.service.StationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/25 15:02
 */
@Controller
//@RestController
public class MainController {
    private final String pathPre = "C:\\CS\\Java\\IdeaProjects\\Lesson03\\src\\main\\java\\com\\tea\\lesson03\\function\\";
    private final LineServiceImpl lineService;
    private final StationServiceImpl stationService;
    private final CityServiceImpl cityService;

    public MainController(LineServiceImpl lineService, StationServiceImpl stationService, CityServiceImpl cityService) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.cityService = cityService;
    }

    //查找当前有的城市，返回结果
    @RequestMapping("/peekCity")
    @ResponseBody
    public String peekCity() {
        String str = "";
        List<City> cityList = cityService.select();

        for (int i = 0; i < (cityList.size() - 1); i++) {
            str += cityList.get(i).getName() + ";";
        }

        str += cityList.get(cityList.size() - 1).getName();

        return str;
    }

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "/index";
    }

    //首次加载主页面
    @RequestMapping("/oneLoad")
    @ResponseBody
    public String oneLoad(HttpSession httpSession) {
        if (httpSession.getAttribute("cityNameEn") == null) {
            return "null";
        } else {
            System.out.println(httpSession.getAttribute("cityNameEn") + "," + httpSession.getAttribute("cityNameZh"));
            return httpSession.getAttribute("cityNameEn") + "," + httpSession.getAttribute("cityNameZh");
        }
    }

    @RequestMapping("/commonsToIndex")
    public String commonsToIndex(HttpServletRequest request,
                                 HttpSession httpSession) {
        String cityNameEn = request.getParameter("cityName").substring(0, request.getParameter("cityName").indexOf(','));
        String cityNameZh = request.getParameter("cityName").substring(request.getParameter("cityName").indexOf(',') + 1);

        httpSession.setAttribute("cityNameEn", cityNameEn);
        httpSession.setAttribute("cityNameZh", cityNameZh);
        return "/index";
    }

    @RequestMapping("/selectCity")
    @ResponseBody
    public String selectCity(HttpServletRequest request,
                             HttpSession httpSession) {
        String cityNameEn = request.getParameter("cityName").substring(0, request.getParameter("cityName").indexOf(','));
        String cityNameZh = request.getParameter("cityName").substring(request.getParameter("cityName").indexOf(',') + 1);

        httpSession.setAttribute("cityNameEn", cityNameEn);
        httpSession.setAttribute("cityNameZh", cityNameZh);

        return cityNameZh + "地铁欢迎您;" + cityNameEn;
    }

    //得到所有的地铁线路
    @RequestMapping("/getAllLines")
    @ResponseBody
    public String getAllLines(HttpSession httpSession) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tableName", httpSession.getAttribute("cityNameEn") + "line");
        List<Line> lines = lineService.selectAllLines(hashMap);
        hashMap.replace("tableName", httpSession.getAttribute("cityNameEn") + "station");

        for (Line line : lines) {
            List<Station> stations = new ArrayList<>();
            for (int i = 0; i < line.getStationNum(); i++) {
                hashMap.put("stationId", line.getStationIds()[i]);
                Station station = stationService.selectStationByStationId(hashMap);
                stations.add(i, station);        //把车站加入到线路对象中
            }
            line.setStations(stations);
        }

        if (httpSession.getAttribute("allLines") != null) {     //清空原有数据
            httpSession.removeAttribute("allLines");
        }
        httpSession.setAttribute("allLines", lines);

//        return String.valueOf(lines);
        return "success";
    }

    @RequestMapping("/showAllLines")
    public String showAllLines(HttpSession httpSession,
                               Model model) {
        model.addAttribute("allLines", httpSession.getAttribute("allLines"));
        return "/showLines";
    }

    //跳转到输入lineId页面
    @RequestMapping("/toInputLineId")
    public String toInputLineId() {
        return "/inputLineId";
    }

    //根据具体地铁线号展示地铁线路
    @RequestMapping("/getLineByLineId")
    public String getLineByLineId(HttpServletRequest request,
                                  Model model,
                                  HttpSession httpSession) {
        List<Line> lines = (List<Line>) httpSession.getAttribute("allLines");

        model.addAttribute("line", lines.get(Integer.parseInt(request.getParameter("lineId")) - 1));

//        return String.valueOf(lines.get(Integer.parseInt(request.getParameter("lineId")) - 1));
        return "/getLineByLineId";
    }

    //跳转到输入站名页面
    @RequestMapping("/toInputStationName")
    public String toInputStationName() {
        return "/inputStationName";
    }

    //根据站点名字展示经过的地铁线路
    @RequestMapping("/getLinesByStationName")
    public String getLinesByStationId(HttpServletRequest request,
                                      HttpSession httpSession,
                                      Model model) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("stationName", request.getParameter("stationName") + "站");
        System.out.println(request.getParameter("stationName") + "站");
        System.out.println(httpSession.getAttribute("cityNameEn") + "station");
        hashMap.put("tableName", httpSession.getAttribute("cityNameEn") + "station");     //获取城市
        List<Station> stationList = stationService.selectStationByStationName(hashMap);       //首先根据地铁站名查出地铁站信息

        List<Line> lines = new ArrayList<>();
        List<Line> allLines = (List<Line>) httpSession.getAttribute("allLines");

        for (int i = 0; i < stationList.size(); i++) {
            Station station = stationList.get(i);
            System.out.println(station.getStationId());
            int index = Integer.parseInt(station.getStationId().substring(0, station.getStationId().length() - 2));
            System.out.println(index);
            lines.add(i, allLines.get(index - 1));
        }

        model.addAttribute("lines", lines);

//        return String.valueOf(lines);
        return "/getLinesByStationName";
    }

    //跳转到输入始终站页面
    @RequestMapping("/toInputShortestWay")
    public String toInputShortestWay() {
        return "/inputShortestWay";
    }

    //显示最短地铁线路
    @RequestMapping("/getShortestWay")
    public String getShortestWay(HttpServletRequest request,
                                 HttpSession httpSession,
                                 Model model) {
        String startStationName = request.getParameter("startStationName");
        String endStationName = request.getParameter("endStationName");

        String path = pathPre + "test.txt";
        System.out.println(httpSession.getAttribute("cityNameEn") + "station.txt" + "\n" + startStationName + '\n' + endStationName);
        try {
            Files.writeString(Paths.get(path), httpSession.getAttribute("cityNameEn") + "station.txt" + "\n" + startStationName + '\n' + endStationName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String tempStr = "";
        try {
            String[] str = new String[]{"python",
                    "C:\\CS\\Java\\IdeaProjects\\Lesson03\\src\\main\\java\\com\\tea\\lesson03\\function\\count.py"};
            Process proc = Runtime.getRuntime().exec(str);      // 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            tempStr = in.readLine();
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(tempStr);

        String[] str = tempStr.split("-");      //用于存放站名和其线的id及途径几站
        List<Station> stationList = new ArrayList<>();      //记录经过的站
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tableName", httpSession.getAttribute("cityNameEn") + "station");

        for (int i = 0; i < str.length - 1; i += 2) {
            String lineId = str[i + 1].substring(0, str[i + 1].indexOf('('));       //获得当前站的线号
            int tempNum = Integer.parseInt(str[i + 1].substring(str[i + 1].indexOf('(') + 1, str[i + 1].indexOf(')')));        //读取间隔站数

            if (hashMap.get("stationName") != null) {
                hashMap.replace("stationName", str[i] + "站");
            } else {
                hashMap.put("stationName", str[i] + "站");
            }

            Station stationNow = new Station();
            List<Station> stations = stationService.selectStationByStationName(hashMap);            //起点站/中转站
            for (Station tempStation : stations) {
                if (tempStation.getStationId().substring(0, tempStation.getStationId().length() - 2).equals(lineId)) {
                    stationNow = tempStation;
                    break;
                }
            }

            hashMap.replace("stationName", str[i + 2] + "站");        //获取终点站/下一个中转站
            stations.clear();       //清空上一次获取的数据
            Station stationNext = new Station();
            stations = stationService.selectStationByStationName(hashMap);
            for (Station tempStation : stations) {
                if (tempStation.getStationId().substring(0, tempStation.getStationId().length() - 2).equals(lineId)) {
                    stationNext = tempStation;
                    break;
                }
            }

            //得到整条线路
            Line line = ((List<Line>) httpSession.getAttribute("allLines"))
                    .get(Integer.parseInt(lineId) - 1);

            //获取起始/中转站在此线路上的id号
            //获取最后两位尾号即可
            int nowStationId = Integer.parseInt(stationNow.getStationId().substring(stationNow.getStationId().length() - 2));
            int nextStationId = Integer.parseInt(stationNext.getStationId().substring(stationNext.getStationId().length() - 2));


            if (nowStationId <= nextStationId) {
                for (int j = nowStationId; j < nowStationId + tempNum; j++) {
                    stationList.add(line.getStations().get(j - 1));
                }
            } else {
                for (int j = nowStationId; j > nextStationId; j--) {
                    stationList.add(line.getStations().get(j - 1));
                }
            }
        }

        String lineId = str[str.length - 2].substring(0, str[str.length - 2].indexOf('('));
        hashMap.replace("stationName", str[str.length - 1] + "站");
        hashMap.put("lineId", lineId);

        for (Station station : stationService.selectStationByStationName(hashMap)) {           //查询出最后一站然后添加进这个List
            if (station.getStationId().substring(0, station.getStationId().length() - 2).equals(lineId)) {
                stationList.add(station);
                break;
            }
        }

        try {
            FileWriter fileOut = new FileWriter("C:\\CS\\Java\\IdeaProjects\\Lesson03\\src\\main\\java\\com\\tea\\lesson03\\function\\test.txt");

            fileOut.write("");

            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("stationList", stationList);
        return "/getShortestWay";
    }
}
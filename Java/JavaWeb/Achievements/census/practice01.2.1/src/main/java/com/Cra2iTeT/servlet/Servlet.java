package com.Cra2iTeT.servlet;

import com.Cra2iTeT.bean.Person;
import com.Cra2iTeT.mapper.Mapper;
import org.apache.ibatis.session.SqlSession;
import com.Cra2iTeT.utils.MybatisUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        String method = req.getParameter("method");

        if (method.equals("add")) {
            HashMap<String, String> hashMap = new HashMap();

            Person person = new Person();
            person.setName(req.getParameter("name"));
            person.setHouseType(req.getParameter("houseType"));
            person.setHomeType(req.getParameter("homeType"));
            person.setArea(req.getParameter("area"));
            person.setRoomNum(req.getParameter("roomNum"));
            person.setId(req.getParameter("id"));
            person.setGender(req.getParameter("gender"));
            person.setNation(req.getParameter("nation"));
            person.setEdu(req.getParameter("edu"));

            hashMap.put("name", person.getName());
            hashMap.put("housetype", person.getHouseType());
            hashMap.put("hometype", person.getHomeType());
            hashMap.put("area", person.getArea());
            hashMap.put("roomnum", person.getRoomNum());
            hashMap.put("id", person.getId());
            hashMap.put("gender", person.getGender());
            hashMap.put("nation", person.getNation());
            hashMap.put("edu", person.getEdu());

            if (mapper.add(hashMap) > 0) {
                resp.getWriter().print("<script> alert(\"添加成功\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"添加失败\"); window.location='Welcome.jsp'</script>");
            }
        } else if (method.equals("delete")) {
            String name = req.getParameter("name");
            if (mapper.deleteByName(name) > 0) {
                resp.getWriter().print("<script> alert(\"删除成功\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"删除失败\"); window.location='Welcome.jsp'</script>");
            }
        } else if (method.equals("execute")) {
            req.setAttribute("name", req.getParameter("name"));
            req.getRequestDispatcher("Update.jsp").forward(req, resp);
        } else if (method.equals("update")) {
            Person person = new Person();
            person.setName(req.getParameter("name"));
            person.setId(req.getParameter("id"));
            person.setGender(req.getParameter("gender"));
            person.setNation(req.getParameter("nation"));
            person.setEdu(req.getParameter("edu"));

            HashMap<String, String> hashMap = new HashMap();

            hashMap.put("name", person.getName());
            hashMap.put("id", person.getId());
            hashMap.put("gender", person.getGender());
            hashMap.put("nation", person.getNation());
            hashMap.put("edu", person.getEdu());

            if (mapper.update(hashMap) > 0) {
                resp.getWriter().print("<script> alert(\"修改成功\"); window.location='Welcome.jsp'</script>");
            } else {
                resp.getWriter().print("<script> alert(\"修改失败\"); window.location='Welcome.jsp'</script>");
            }
        } else if (method.equals("query")) {
            Person person = new Person();
            person.setName(req.getParameter("name"));
            person.setId(req.getParameter("id"));
            person.setGender(req.getParameter("gender"));
            person.setNation(req.getParameter("nation"));
            person.setEdu(req.getParameter("edu"));

            HashMap<String, String> hashMap = new HashMap();

            hashMap.put("name", person.getName());
            hashMap.put("id", person.getId());
            hashMap.put("gender", person.getGender());
            hashMap.put("nation", person.getNation());
            hashMap.put("edu", person.getEdu());

            removeNullValue(hashMap);

            List<Person> list = mapper.query(hashMap);
            if (list.size() == 0) {
                resp.getWriter().print("<script> alert(\"查询结果为空\"); window.location='Welcome.jsp'</script>");
            } else {
                req.setAttribute("personList", list);
                req.getRequestDispatcher("Scan.jsp").forward(req, resp);
            }
        } else if (method.equals("show")) {
            String name = req.getParameter("name");
            Person person = mapper.show(name);
            req.setAttribute("person", person);
            req.getRequestDispatcher("Show.jsp").forward(req, resp);
        }

        sqlSession.close();
    }

    public static void removeNullValue(Map map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object obj = (Object) iterator.next();
            Object value = (Object) map.get(obj);
            remove(value, iterator);
        }
    }

    private static void remove(Object obj, Iterator iterator) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (str == null || str.trim().isEmpty()) {
                iterator.remove();
            }
        } else if (obj instanceof Collection) {
            Collection col = (Collection) obj;
            if (col == null || col.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Map) {
            Map temp = (Map) obj;
            if (temp == null || temp.isEmpty()) {
                iterator.remove();
            }

        } else if (obj instanceof Object[]) {
            Object[] array = (Object[]) obj;
            if (array == null || array.length <= 0) {
                iterator.remove();
            }
        } else {
            if (obj == null) {
                iterator.remove();
            }
        }
    }
}

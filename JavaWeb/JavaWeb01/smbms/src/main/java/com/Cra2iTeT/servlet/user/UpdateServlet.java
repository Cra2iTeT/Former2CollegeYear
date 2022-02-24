package com.Cra2iTeT.servlet.user;

import com.Cra2iTeT.pojo.Role;
import com.Cra2iTeT.pojo.User;
import com.Cra2iTeT.service.role.RoleService;
import com.Cra2iTeT.service.role.RoleServiceImpl;
import com.Cra2iTeT.service.user.UserService;
import com.Cra2iTeT.service.user.UserServiceImpl;
import com.Cra2iTeT.util.Constants;
import com.Cra2iTeT.util.PageSupport;
import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.print("method:" + method);
        System.out.println();

        if (method != null && method.equals("savepwd")) {//修改密码
            this.updatePassword(req, resp);
        } else if (method != null && method.equals("pwdmodify")) {//验证旧密码
            this.passwordModify(req, resp);
        } else if (method != null && method.equals("query")) {
            this.query(req, resp);
        } else if (method != null && method.equals("getrolelist")) {
            this.getRoleList(req, resp);
        } else if (method != null && method.equals("ucexist")) {
            System.out.println("ServletIn");
            this.add(req, resp);
        }
    }

    //修改密码
    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) {
        //从Session中获取用户id
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);

        //获取新密码
        String newpassword = req.getParameter("newpassword");
        Boolean flag = false;

        if (attribute != null && newpassword != null) {
            UserService userService = new UserServiceImpl();
            flag = userService.updatePassword(((User) attribute).getId(), newpassword);

            if (flag) {
                req.setAttribute("message", "修改密码成功，请退出，使用新密码登录");
                //修改成功，移除Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            } else {
                req.setAttribute("message", "密码修改失败");
            }
        } else {
            req.setAttribute("message", "新密码存在问题");
        }

        try {
            req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //验证旧密码（和Session的密码对比，高效）
    public void passwordModify(HttpServletRequest req, HttpServletResponse resp) {
        //获取Session
        Object attribute = req.getSession().getAttribute(Constants.USER_SESSION);

        //获取旧密码
        String oldPassword = req.getParameter("oldpassword");

        //万能的Map
        //结果集
        HashMap<String, String> resultMap = new HashMap<>();

        //Session失效
        if (attribute == null) {
            resultMap.put("result", "sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldPassword)) {//输入空密码
            resultMap.put("result", "error");
        } else {
            String userPassword = ((User) attribute).getUserPassword();
            if (oldPassword.equals(userPassword)) {
                resultMap.put("result", "true");
            } else {
                resultMap.put("result", "false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //JSONArray 阿里巴巴的JSON工具类，用来转换格式
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询用户角色
    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从前端获取数据
        String queryName = req.getParameter("queryname");
        String tempQueryUserRole = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");

        //默认为零，保证不为空，当前端有所选择时在赋值成真实值
        int queryUserRole = 0;

        //获取用户列表
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = null;

        //第一次走请求一定是第一页，且页面大小固定
        int currentPageNo = 1;

        if (queryName == null) {
            queryName = "";
        }
        if (tempQueryUserRole != null && !tempQueryUserRole.equals("")) {
            //给临时变量赋值
            queryUserRole = Integer.parseInt(tempQueryUserRole);
        }
        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }

        //获取用户总数
        int totalCount = userService.getUserCount(queryName, queryUserRole);
        //System.out.println("totalCount:" + totalCount);

        //页面支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(Constants.PAGESIZE);
        pageSupport.setTotalCount(totalCount);

        //控制首页和尾页，首页不能上一页，尾页不能下一页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > pageSupport.getTotalPageCount()) {
            currentPageNo = pageSupport.getTotalPageCount();
        }

        userList = userService.getUserList(queryName, queryUserRole, currentPageNo, pageSupport.getPageSize());
        //System.out.println("userList.size():" + userList.size());
        req.setAttribute("userList", userList);

        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList", roleList);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalPageCount", pageSupport.getTotalPageCount());
        req.setAttribute("queryUserName", queryName);
        req.setAttribute("queryUserRole", queryUserRole);

        //返回前端
        req.getRequestDispatcher("userlist.jsp").forward(req, resp);
    }

    //添加用户
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        int gender = Integer.parseInt(req.getParameter("gender"));
        String birth = req.getParameter("birthday");
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        int userRole = Integer.parseInt(req.getParameter("userRole"));
        System.out.println(userRole);

        List<Object> list = new ArrayList<Object>();
        list.add(userCode);
        list.add(userName);
        list.add(userPassword);
        list.add(userRole);
        list.add(gender);
        list.add(birthday);
        list.add(phone);
        list.add(address);

        UserService userService = new UserServiceImpl();
        int i = userService.add(list);
        if (i > 0) {
            resp.sendRedirect("/jsp/user.do?method=query");
        } else {
            req.getRequestDispatcher("useradd.jsp").forward(req, resp);
        }
    }

    //添加用户的下拉框
    public void getRoleList(HttpServletRequest req, HttpServletResponse resp) {
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        try {
            resp.setContentType("application/josn");
            PrintWriter writer = null;
            writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(roleList));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

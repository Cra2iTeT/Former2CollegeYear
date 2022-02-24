package com.Cra2iTeT.controller;

import com.Cra2iTeT.bean.Employee;
import com.Cra2iTeT.service.impl.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/root")
public class RootController {
    @Autowired
    private RootServiceImpl rootService;

    //跳转到用户管理页面
    @RequestMapping("/toUserManagePage")
    public String toUserManagePage() {
        return "./root/userManage/userManagePage";
    }

    //跳转到查询用户页面
    @RequestMapping("/userManage/toQueryEmployeeByIdPage")
    public String toQueryEmployeeByIdPage() {
        return "./root/userManage/queryEmployeeByIdPage";
    }

    //根据id查询用户
    @RequestMapping("/userManage/queryEmployeeById")
    public String queryEmployeeById(@RequestParam("id") int id,
                                    Model model) {
        Employee employee = rootService.queryEmployeeById(id);

        System.out.println("查询到的结果=>" + employee);

        if (employee != null) {
            model.addAttribute("user", employee);
            return "./root/userManage/queryEmployeeByIdResult";
        }
        model.addAttribute("msg", "用户不存在");
        return "./root/userManage/queryEmployeeByIdPage";
    }

    //根据id暂停用户
    @RequestMapping("/userManage/pauseEmployeeById")
    public String pauseEmployeeById(@RequestParam("id") int id,
                                    Model model) {
        System.out.println();
        System.out.println("=========================");
        System.out.println("rootController暂停用户函数");

        System.out.println("得到的id=>" + id);

        if (rootService.pauseEmployeeById(id) > 0) {
            model.addAttribute("msg", "停职成功");
        } else {
            model.addAttribute("msg", "停职失败");
        }

        System.out.println("=========================");
        System.out.println();

        model.addAttribute("user", rootService.queryEmployeeById(id));
        return "./root/userManage/queryEmployeeByIdResult";
    }

    //跳转到编辑用户信息页面
    @RequestMapping("/userManage/toUpdateEmployeeByIdPage")
    public String toUpdateEmployeeByIdPage(@RequestParam("id") int id,
                                           Model model) {
        model.addAttribute("user", rootService.queryEmployeeById(id));
        return "./root/userManage/updateEmployeeByIdPage";
    }

    //编辑职员信息
    @RequestMapping("/userManage/updateEmployeeByIdPage")
    public String updateEmployeeByIdPage(HttpServletRequest request,
                                         Model model) {
        System.out.println();
        System.out.println("=========================");
        System.out.println("rootController编辑职员信息函数");

        HashMap<String, Object> map = new HashMap<>();

        System.out.println("得到的id=>" + request.getParameter("id"));
        map.put("id", request.getParameter("id"));

        System.out.println("得到的name=>" + request.getParameter("name"));
        map.put("name", request.getParameter("name"));

        System.out.println("得到的password=>" + request.getParameter("password"));
        map.put("password", request.getParameter("password"));

        System.out.println("得到的departId=>" + request.getParameter("departId"));
        map.put("departId", request.getParameter("departId"));

        System.out.println("得到的jurisdiction=>" + request.getParameter("jurisdiction"));
        map.put("jurisdiction", request.getParameter("jurisdiction"));

        System.out.println("得到的position=>" + request.getParameter("position"));
        map.put("position", request.getParameter("position"));

        System.out.println("得到的state=>" + request.getParameter("state"));
        map.put("state", request.getParameter("state"));

        System.out.println("=========================");
        System.out.println();

        if (rootService.updateEmployeeById(map) > 0) {
            model.addAttribute("msg", "修改成功");
        } else {
            model.addAttribute("msg", "修改失败");
        }

        model.addAttribute("user", rootService.queryEmployeeById(Integer.parseInt(request.getParameter("id"))));
        return "./root/userManage/queryEmployeeByIdResult";
    }

    //根据id删除职员
    @RequestMapping("/userManage/deleteEmployeeById")
    public String deleteEmployeeById(@RequestParam("id") int id,
                                     Model model) {
        if (rootService.deleteEmployeeById(id) > 0) {
            model.addAttribute("msg", "删除成功");
        } else {
            model.addAttribute("msg", "删除失败");
        }

        return "./root/userManage/queryEmployeeByIdPage";
    }

    //查询所有用户
    @RequestMapping("/userManage/queryAllEmployee")
    public String queryAllEmployee(Model model) {
        List<Employee> employeeList = rootService.queryAllEmployee();

        if (employeeList.size() > 0) {
            model.addAttribute("employeeList", employeeList);
            return "./root/userManage/queryAllEmployeeResult";
        } else {
            model.addAttribute("msg", "用户列表为空");
            return "./root/userManage/userManagePage";
        }
    }

    //跳转到新增用户页面
    @RequestMapping("/userManage/toAddEmployeePage")
    public String toAddEmployeePage() {
        return "./root/userManage/addEmployeePage";
    }

    //添加新用户
    @RequestMapping("/userManage/addEmployee")
    public String addEmployee(HttpServletRequest request,
                              Model model) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("id", request.getParameter("id"));
        map.put("name", request.getParameter("name"));
        map.put("password", request.getParameter("password"));
        map.put("departid", request.getParameter("departId"));
        map.put("jurisdiction", request.getParameter("jurisdiction"));
        map.put("position", request.getParameter("position"));
        map.put("state", request.getParameter("state"));

        if (rootService.addEmployee(map) > 0) {
            model.addAttribute("msg", "添加成功");
        } else {
            model.addAttribute("msg", "添加失败");
        }

        return "./root/userManage/userManagePage";
    }

}

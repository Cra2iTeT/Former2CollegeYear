package com.Cra2iTeT.controller;

import com.Cra2iTeT.bean.Employee;
import com.Cra2iTeT.service.impl.RootServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    //查看职员
    public List<Employee> queryEmployee(HashMap<String, Object> map) {
        List<Employee> employeeList = rootService.queryEmployee(map);

        for (int i = 0; i < employeeList.size(); i++) {
            employeeList.get(i).setState(employeeList.get(i).getStateNum());
            employeeList.get(i).setJurisdiction(employeeList.get(i).getJurisdictionNum());
            //去除掉不让访问的数据
            if (employeeList.get(i).getId() == 8) {
                employeeList.remove(i);
            }
        }

        return employeeList;
    }

    //超链接查看职员信息
    @GetMapping("queryEmployee")
    public String queryEmployee(HttpServletRequest request,
                                Model model) {
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("id", request.getParameter("id"));

        model.addAttribute("employee", queryEmployee(hashMap).get(0));
        return "./root/employeeManage/queryEmployeeDetailedResult";
    }

    //跳转到用户管理页面
    @PostMapping("/toEmployeeManagePage")
    public String toUserManagePage() {
        return "./root/employeeManage/employeeManagePage";
    }

    //跳转到查询用户页面
    @PostMapping("/employeeManage/toQueryEmployeePage")
    public String toQueryEmployeeByIdPage() {
        return "./root/employeeManage/queryEmployeePage";
    }

    //根据条件查询用户
    @PostMapping("/employeeManage/queryEmployee")
    public String queryEmployeeById(HttpServletRequest request,
                                    Model model) {
        System.out.println();
        System.out.println("================");
        System.out.println("rootController根据条件查询职员函数中");

        HashMap<String, Object> map = new HashMap<>();

        if (!request.getParameter("id").equals("")) {
            System.out.println("id=>" + request.getParameter("id"));
            map.put("id", request.getParameter("id"));
        }
        if (!request.getParameter("departId").equals("0")) {
            System.out.println("departId=>" + request.getParameter("departId"));
            map.put("departid", request.getParameter("departId"));
        }
        if (!request.getParameter("name").equals("")) {
            System.out.println("name=>" + request.getParameter("name"));
            map.put("name", request.getParameter("name"));
        }
        if (!request.getParameter("stateNum").equals("3")) {
            System.out.println("stateNum=>" + request.getParameter("stateNum"));
            map.put("statenum", request.getParameter("stateNum"));
        }


        List<Employee> employeeList = queryEmployee(map);
        System.out.println("查询到的结果=>" + employeeList);

        System.out.println("================");
        System.out.println();

        if (employeeList.size() > 0) {
            model.addAttribute("employeeList", employeeList);
            return "./root/employeeManage/queryAllEmployeeResult";
        }
        model.addAttribute("msg", "用户不存在");
        return "./root/employeeManage/queryEmployeePage";
    }

    //根据id暂停用户
    @PostMapping("/employeeManage/pauseEmployeeById")
    public String pauseEmployeeById(@RequestParam("id") int id,
                                    Model model) {
        System.out.println();
        System.out.println("=========================");
        System.out.println("rootController暂停用户函数");

        if (id == 1 || id == 8) {
            model.addAttribute("msg", "抱歉,没有权限进行此项操作");
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", id);
            map.put("statenum", 0);
            System.out.println("得到的id=>" + id);

            if (rootService.updateEmployeeById(map) > 0) {
                model.addAttribute("msg", "停职成功");
            } else {
                model.addAttribute("msg", "停职失败");
            }

            map.clear();

            model.addAttribute("employeeList", queryEmployee(map));
        }

        System.out.println("=========================");
        System.out.println();

        return "./root/employeeManage/queryAllEmployeeResult";
    }

    //跳转到编辑用户信息页面
    @PostMapping("/employeeManage/toUpdateEmployeeByIdPage")
    public String toUpdateEmployeeByIdPage(HttpServletRequest request,
                                           Model model) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", request.getParameter("id"));

        model.addAttribute("employee", queryEmployee(map).get(0));

        return "./root/employeeManage/updateEmployeeByIdPage";
    }

    //编辑职员信息
    @PostMapping("/employeeManage/updateEmployeeByIdPage")
    public String updateEmployeeByIdPage(HttpServletRequest request,
                                         Model model) {
        System.out.println();
        System.out.println("=========================");
        System.out.println("rootController编辑职员信息函数");

        HashMap<String, Object> map = new HashMap<>();

        System.out.println("id=>" + request.getParameter("id"));
        map.put("id", request.getParameter("id"));

        if (!request.getParameter("name").equals("")) {
            System.out.println("name=>" + request.getParameter("name"));
            map.put("name", request.getParameter("name"));
        }
        if (!request.getParameter("password").equals("")) {
            System.out.println("password=>" + request.getParameter("password"));
            map.put("password", request.getParameter("password"));
        }
        //0代表原数据，不修改
        if (!request.getParameter("departId").equals("") && !request.getParameter("departId").equals("0")) {
            System.out.println("departId=>" + request.getParameter("departId"));
            map.put("departid", request.getParameter("departId"));
        }
        if (!request.getParameter("jurisdictionNum").equals("") || !request.getParameter("jurisdictionNum").equals("0")) {
            System.out.println("jurisdictionNum=>" + request.getParameter("jurisdictionNum"));
            map.put("jurisdictionnum", request.getParameter("jurisdictionNum"));
        }
        if (!request.getParameter("position").equals("")) {
            System.out.println("position=>" + request.getParameter("position"));
            map.put("position", request.getParameter("position"));
        }
        if (!request.getParameter("stateNum").equals("2")) {
            if (request.getParameter("id").equals("1") || request.getParameter("id").equals("1")) {
                System.out.println("无权操作");

                model.addAttribute("msg", "抱歉,没有权限进行此项操作");

                System.out.println("=========================");
                System.out.println();

                return "./root/employeeManage/queryAllEmployeeResult";
            } else {
                System.out.println("stateNum=>" + request.getParameter("stateNum"));
                map.put("statenum", request.getParameter("stateNum"));
            }
        }

        if (rootService.updateEmployeeById(map) > 0) {
            model.addAttribute("msg", "修改成功");
        } else {
            model.addAttribute("msg", "修改失败");
        }

        map.clear();

        model.addAttribute("employeeList", queryEmployee(map));

        System.out.println("=========================");
        System.out.println();

        return "./root/employeeManage/queryAllEmployeeResult";
    }

    //根据id删除职员
    @PostMapping("/employeeManage/deleteEmployeeById")
    public String deleteEmployeeById(@RequestParam("id") int id,
                                     Model model) {
        if (rootService.deleteEmployeeById(id) > 0) {
            model.addAttribute("msg", "删除成功");
        } else {
            model.addAttribute("msg", "删除失败");
        }

        return "./root/employeeManage/queryAllEmployeeResult";
    }

    //查询所有用户
    @PostMapping("/employeeManage/queryAllEmployee")
    public String queryAllEmployee(Model model) {
        List<Employee> employeeList = queryEmployee(new HashMap<String, Object>());

        if (employeeList.size() > 0) {
            model.addAttribute("employeeList", employeeList);
            return "./root/employeeManage/queryAllEmployeeResult";
        } else {
            model.addAttribute("msg", "用户列表为空");
            return "./root/employeeManage/employeeManagePage";
        }
    }

    //跳转到新增用户页面
    @PostMapping("/employeeManage/toAddEmployeePage")
    public String toAddEmployeePage() {
        return "./root/employeeManage/addEmployeePage";
    }

    //添加新用户
    @PostMapping("/employeeManage/addEmployee")
    public String addEmployee(HttpServletRequest request,
                              Model model) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("id", request.getParameter("id"));
        map.put("name", request.getParameter("name"));
        map.put("password", request.getParameter("password"));
        map.put("departid", request.getParameter("departId"));
        map.put("jurisdictionnum", request.getParameter("jurisdictionNum"));
        map.put("position", request.getParameter("position"));
        map.put("statenum", request.getParameter("stateNum"));

        if (rootService.addEmployee(map) > 0) {
            model.addAttribute("msg", "添加成功");
        } else {
            model.addAttribute("msg", "添加失败");
        }

        List<Employee> employeeList = queryEmployee(new HashMap<String, Object>());

        model.addAttribute("employeeList", employeeList);

        return "./root/employeeManage/queryAllEmployeeResult";
    }

}

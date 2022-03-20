package com.Cra2iTeT.controller;

import com.Cra2iTeT.pojo.Worker;
import com.Cra2iTeT.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class Admin {

    @Autowired
    private AdminServiceImpl adminService;

    //用户管理
    @PostMapping("/toUserManage")
    public String toUserManage() {
        return "./0/0/userManage";
    }

    //查看所有用户
    @PostMapping("/userManage/userList")
    public String userList(Model model) {
        model.addAttribute("list", adminService.workerList());
        return "./0/0/userList";
    }

    //添加用户
    @PostMapping("/userManage/toAddUser")
    public String toAddUser() {
        return "./0/0/addUser";
    }

    @PostMapping("/userManage/addUser")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          @RequestParam("did") int did,
                          Model model) {

        Worker worker = new Worker();

        worker.setName(name);
        worker.setPassword(password);
        worker.setDid(did);
        worker.setSid(1);
        worker.setState(1);

        if (adminService.addWorker(worker) > 0) {
            model.addAttribute("msg", "添加成功");
        } else {
            model.addAttribute("msg", "添加失败");
        }
        return "./0/0/userManage";

    }

    //暂停职员
    @PostMapping("/userManage/toPauseUser")
    public String toPauseUser() {
        return "./0/0/pauseUser";
    }

    @PostMapping("/userManage/pauseUser")
    public String pauseUser(@RequestParam("id") int id,
                            Model model) {

        if (adminService.pauseWorkerById(id) > 0) {
            model.addAttribute("msg", "暂停成功");
        } else {
            model.addAttribute("msg", "暂停失败");
        }
        return "./0/0/userManage";
    }

    //修改用户信息
    @PostMapping("/userManage/toUpdateUser")
    public String toUpdateUser() {
        return "./0/0/updateUser";
    }

    @PostMapping("/userManage/updateUser")
    public String updateUser(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("password") String password,
                             @RequestParam("did") int did,
                             @RequestParam("state") int state,
                             Model model) {    //这是为了测试是否可以输入全部数据，正常操作应该修改成传入HttpServletRequest获取数据

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("id", id);
        hashMap.put("name", name);
        hashMap.put("password", password);
        hashMap.put("did", did);
        hashMap.put("state", state);

        if (adminService.updateWorker(hashMap) > 0) {
            model.addAttribute("msg", "修改成功");
        } else {
            model.addAttribute("msg", "修改失败");
        }
        return "./0/0/userManage";
    }

    //删除职员
    @PostMapping("/userManage/toDelUser")
    public String toDelUser() {
        return "./0/0/delUser";
    }

    @PostMapping("/userManage/delUser")
    public String delUser(@RequestParam("id") int id,
                          Model model) {
        if (adminService.delWorkerById(id) > 0) {
            model.addAttribute("msg", "删除成功");
        } else {
            model.addAttribute("msg", "删除失败");
        }
        return "./0/0/userManage";
    }

    //用户管理
    @PostMapping("/toRoleManagePage")
    public String toRoleManagePage() {
        return "./0/0/roleManagePage";
    }

    //修改职工信息

    @PostMapping("/roleManage/toRoleManage")
    public String toRoleManage(@RequestParam("id") int id, Model model) {
        model.addAttribute("id", id);
        return "./0/0/roleManage";
    }

    @PostMapping("/roleManage/roleManage")
    public String roleManage(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("oldPassword") String oldPassword,
                             @RequestParam("newPassword1") String newPassword1,
                             @RequestParam("newPassword2") String newPassword2,
                             @RequestParam("did") int did,
                             Model model) {

        if (!newPassword1.equals(newPassword2)) {
            model.addAttribute("msg", "两次密码不一致请重新输入");    //这里应该是前端来给验证，我写在这方便
            return "./0/0/roleManage";
        } else {
            Worker worker = adminService.selectWorkerById(id);

            if (!worker.getPassword().equals(oldPassword)) {
                model.addAttribute("msg", "旧密码有误，请检查后重新输入");
                return "./0/0/roleManage";
            }

            HashMap<String, Object> hashMap = new HashMap<>();

            hashMap.put("id", id);
            hashMap.put("name", name);
            hashMap.put("password", newPassword1);
            hashMap.put("did", did);

            if (adminService.updateWorker(hashMap) > 0) {
                model.addAttribute("msg", "修改成功");
            } else {
                model.addAttribute("msg", "修改失败");
            }
            return "./0/0/roleManage";
        }

    }
}

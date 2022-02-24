package com.Cra2iTeT.controller;

import com.Cra2iTeT.dao.EmployeeDao;
import com.Cra2iTeT.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String getAll(Model model) {
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }
}

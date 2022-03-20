package com.Cra2iTeT.service;

import com.Cra2iTeT.bean.Employee;

import java.util.List;
import java.util.Map;

public interface RootService {
    //通过id查询用户
    public Employee queryEmployeeById(int id);

    //查看所有用户
    public List<Employee> queryAllEmployee();

    //新增用户
    public int addEmployee(Map map);

    //根据id暂停用户
    public int pauseEmployeeById(int id);

    //修改用户信息
    public int updateEmployeeById(Map map);

    //根据id删除用户
    public int deleteEmployeeById(int id);
}

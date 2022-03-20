package com.Cra2iTeT.service;

import com.Cra2iTeT.bean.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RootService {
    //查询用户
    public List<Employee>  queryEmployee(HashMap<String, Object> hashMap);

    //新增用户
    public int addEmployee(Map map);

    //修改用户信息
    public int updateEmployeeById(Map map);

    //根据id删除用户
    public int deleteEmployeeById(int id);
}

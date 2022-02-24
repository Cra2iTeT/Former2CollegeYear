package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.bean.Employee;
import com.Cra2iTeT.dao.RootDao;
import com.Cra2iTeT.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("RootService")
public class RootServiceImpl implements RootService {
    @Autowired
    private RootDao rootDao;

    @Override
    public List<Employee>  queryEmployee(HashMap<String, Object> hashMap) {
        return rootDao.queryEmployee(hashMap);
    }

    @Override
    public int addEmployee(Map map) {
        return rootDao.addEmployee(map);
    }

    @Override
    public int updateEmployeeById(Map map) {
        return rootDao.updateEmployeeById(map);
    }

    @Override
    public int deleteEmployeeById(int id) {
        return rootDao.deleteEmployeeById(id);
    }
}

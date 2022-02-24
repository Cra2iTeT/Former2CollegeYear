package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.bean.Employee;
import com.Cra2iTeT.dao.LoginDao;
import com.Cra2iTeT.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Employee queryEmployeeById(int id) {
        return loginDao.queryEmployeeById(id);
    }
}

package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.dao.LoginDao;
import com.Cra2iTeT.pojo.Worker;
import com.Cra2iTeT.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public Worker login(int id) {
        return loginDao.login(id);
    }
}

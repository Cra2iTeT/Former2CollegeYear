package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.dao.LoginDao;
import com.Cra2iTeT.pojo.User;
import com.Cra2iTeT.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao dao;

    @Override
    public User login(int id) {
        return dao.login(id);
    }
}

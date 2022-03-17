package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.dao.UserDao;
import com.Cra2iTeT.pojo.User;
import com.Cra2iTeT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public User showInfoById(int id) {
        return dao.showInfoById(id);
    }
}

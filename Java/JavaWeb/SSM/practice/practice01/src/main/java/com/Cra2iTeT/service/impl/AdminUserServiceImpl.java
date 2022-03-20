package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.dao.AdminUserDao;
import com.Cra2iTeT.pojo.AdminUser;
import com.Cra2iTeT.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;


    @Override
    public AdminUser getAdminUserById(Long id) {
        return adminUserDao.getAdminUserById(id);
    }

    @Override
    public AdminUser login(String username) {
        return adminUserDao.login(username);
    }

    @Override
    public int addUser(AdminUser adminUser) {
        return adminUserDao.addUser(adminUser);
    }

    @Override
    public int updateUser(Map map) {
        return adminUserDao.updateUser(map);
    }
}

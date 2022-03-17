package com.Cra2iTeT.service;

import com.Cra2iTeT.pojo.AdminUser;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

public interface AdminUserService {
    //根据id查询
    public AdminUser getAdminUserById(Long id);

    //登录
    public AdminUser login(String username);

    //添加用户
    public int addUser(AdminUser adminUser);

    //修改用户数据除id外
    public int updateUser(Map map);
}

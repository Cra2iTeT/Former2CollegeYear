package com.Cra2iTeT.service.user;

import com.Cra2iTeT.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserService {

    //用户登录
    public User login(String userCode, String password);

    //根据用户id修改密码
    public Boolean updatePassword(int id, String userPassword);

    //查询记录数量
    public int getUserCount(String username, int userRole);

    //根据条件查询用户列表
    public List<User> getUserList(String queryUsername, int queryUserRole, int currentPageNo, int pageSize);

    //添加用户
    public int add(List<Object> list);


}

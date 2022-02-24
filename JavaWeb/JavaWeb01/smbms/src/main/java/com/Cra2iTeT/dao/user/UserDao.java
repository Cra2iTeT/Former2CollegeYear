package com.Cra2iTeT.dao.user;

import com.Cra2iTeT.pojo.Role;
import com.Cra2iTeT.pojo.User;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode, String password) throws SQLException;

    //修改当前用户密码
    public int updatePassword(Connection connection, int id, String userPassword) throws SQLException;

    //获得当前用户数量
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException;

    //根据条件查询获取用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException;

    //添加用户
    public int add(Connection connection,List<Object> list) throws SQLException;


}

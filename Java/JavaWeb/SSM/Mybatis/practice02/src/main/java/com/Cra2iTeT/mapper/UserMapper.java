package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();
    //根据id查询用户
    User getUserById(int id);
    //增加用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);
    //选择全部用户实现分页
    List<User> selectUser(Map<String,Integer> map);
    //选择全部用户RowBounds实现分页
    List<User> getUserByRowBounds();

}

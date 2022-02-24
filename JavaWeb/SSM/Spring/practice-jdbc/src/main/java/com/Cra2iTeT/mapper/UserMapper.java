package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectUser();

    public int addUser(User user);

    public int deleteUser(int id);
}

package com.Cra2iTeT.dao;

import com.Cra2iTeT.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    //登录
    User login(int id);
}

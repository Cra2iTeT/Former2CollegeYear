package com.Cra2iTeT.dao;

import com.Cra2iTeT.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    //根据id返回信息
    public User showInfoById(int id);
}

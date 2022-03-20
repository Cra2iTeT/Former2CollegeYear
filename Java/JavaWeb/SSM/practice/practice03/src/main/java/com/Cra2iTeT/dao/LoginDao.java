package com.Cra2iTeT.dao;

import com.Cra2iTeT.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {
    //登录，根据id查询再匹配密码
    public Worker login(int id);
}

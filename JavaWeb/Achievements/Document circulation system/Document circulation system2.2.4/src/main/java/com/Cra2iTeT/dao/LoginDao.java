package com.Cra2iTeT.dao;

import com.Cra2iTeT.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {
    //登录
    public Employee queryEmployeeById(int id);
}

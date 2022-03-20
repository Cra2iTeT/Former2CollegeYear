package com.Cra2iTeT.dao;

import com.Cra2iTeT.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/9 22:51
 */
@Mapper
@Repository
public interface DeptDao {
    public int add(Dept dept);
    public Dept query(Long id);
    public List<Dept> queryAll();
}

package com.Cra2iTeT.service;

import com.Cra2iTeT.pojo.Dept;

import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/9 22:56
 */
public interface DeptService {
    public int add(Dept dept);
    public Dept query(Long id);
    public List<Dept> queryAll();
}

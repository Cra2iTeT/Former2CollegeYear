package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.dao.DeptDao;
import com.Cra2iTeT.pojo.Dept;
import com.Cra2iTeT.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/9 22:57
 */
@Service
public class DeptServiceImpl implements DeptService {
    private final DeptDao deptDao;

    public DeptServiceImpl(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    @Override
    public int add(Dept dept) {
        return deptDao.add(dept);
    }

    @Override
    public Dept query(Long id) {
        return deptDao.query(id);
    }

    @Override
    public List<Dept> queryAll(){
        return deptDao.queryAll();
    }
}

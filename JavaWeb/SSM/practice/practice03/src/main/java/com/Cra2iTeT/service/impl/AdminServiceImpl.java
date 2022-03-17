package com.Cra2iTeT.service.impl;

import com.Cra2iTeT.dao.AdminDao;
import com.Cra2iTeT.pojo.Worker;
import com.Cra2iTeT.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Worker> workerList() {
        return adminDao.workerList();
    }

    @Override
    public int addWorker(Worker worker) {
        return adminDao.addWorker(worker);
    }

    @Override
    public int pauseWorkerById(int id) {
        return adminDao.pauseWorkerById(id);
    }

    @Override
    public int updateWorker(Map map) {
        return adminDao.updateWorker(map);
    }

    @Override
    public int delWorkerById(int id) {
        return adminDao.delWorkerById(id);
    }

    @Override
    public Worker selectWorkerById(int id) {
        return adminDao.selectWorkerById(id);
    }
}

package com.Cra2iTeT.dao;

import com.Cra2iTeT.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdminDao {

    //查看所有用户
    public List<Worker> workerList();

    //增加用户
    public int addWorker(Worker worker);

    //暂停用户
    public int pauseWorkerById(int id);

    //修改用户
    public int updateWorker(Map map);

    //删除用户
    public int delWorkerById(int id);

    //查询单个用户
    public Worker selectWorkerById(int id);
}

package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.T;

import java.util.Map;

public interface TMapper {
    int updateT(Map map);//修改个人数据

    T queryT(String tid);//查看个人信息
}

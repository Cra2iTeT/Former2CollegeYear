package com.tea.lesson03.service;

import com.tea.lesson03.pojo.Line;
import com.tea.lesson03.pojo.Station;

import java.util.List;
import java.util.Map;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/25 11:02
 */
public interface StationService {
    public Station selectStationByStationId(Map map);     //根据id查询站点

    public List<Station> selectStationByStationName(Map map);     //根据名字查询站点

    public List<Station> selectAllStation(Map map);

    public int insertTable(Map map);        //建表

    public int isTableExist(Map map);       //检查表是否存在

    public int insertData(Map map);     //插入数据
}

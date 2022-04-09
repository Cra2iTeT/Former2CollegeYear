package com.tea.lesson03.service;

import com.tea.lesson03.pojo.Line;
import com.tea.lesson03.pojo.Station;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/25 10:39
 */
public interface LineService {
    public List<Line> selectLineIdByStationId(Map map);

    public Line selectLineByLineId(Map map);

    public List<Line> selectAllLines(Map map);

    public int isTableExist(Map map);       //判断表是否已经存在

    public int insertTable(Map map);        //建表

    public int insertData(Map map);     //插入数据
}

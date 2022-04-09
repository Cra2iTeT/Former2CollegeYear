package com.tea.lesson03.mapper;

import com.tea.lesson03.pojo.Station;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/25 10:37
 */
@Mapper
@Repository
public interface StationMapper {
    public List<Station> select(Map map);

    public int insertTable(Map map);        //建表

    public int isTableExist(Map map);       //检查表是否存在

    public int insertData(Map map);     //插入数据
}

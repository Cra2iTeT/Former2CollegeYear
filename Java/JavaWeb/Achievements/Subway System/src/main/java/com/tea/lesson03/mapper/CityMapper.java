package com.tea.lesson03.mapper;

import com.tea.lesson03.pojo.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/4/5 13:32
 */
@Mapper
@Repository
public interface CityMapper {
    //返回所有城市结果
    public List<City> select();

    //插入新城市
    public int insert(String name);
}


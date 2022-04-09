package com.tea.lesson03.service;

import com.tea.lesson03.pojo.City;

import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/4/5 13:33
 */
public interface CityService {
    //返回所有城市结果
    public List<City> select();

    //插入新城市
    public int insert(String name);
}

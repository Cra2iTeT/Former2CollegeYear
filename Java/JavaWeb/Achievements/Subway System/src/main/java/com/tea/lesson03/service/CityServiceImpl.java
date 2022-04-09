package com.tea.lesson03.service;

import com.tea.lesson03.mapper.CityMapper;
import com.tea.lesson03.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/4/5 13:33
 */
@Service
public class CityServiceImpl implements CityService{
    private final CityMapper cityMapper;

    public CityServiceImpl(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public List<City> select() {
        return cityMapper.select();
    }

    @Override
    public int insert(String name) {
        return cityMapper.insert(name);
    }
}

package com.tea.lesson03.service;

import com.tea.lesson03.mapper.StationMapper;
import com.tea.lesson03.pojo.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/25 11:05
 */
@Service
public class StationServiceImpl implements StationService{
    private final StationMapper stationMapper;

    public StationServiceImpl(StationMapper stationMapper) {
        this.stationMapper = stationMapper;
    }

    @Override
    public Station selectStationByStationId(Map map) {
        Station station = this.stationMapper.select(map).get(0);
        return station;
    }

    @Override
    public List<Station> selectStationByStationName(Map map) {
        return this.stationMapper.select(map);
    }

    @Override
    public List<Station> selectAllStation(Map map) {
        List<Station> stations = stationMapper.select(map);
        return stations;
    }

    @Override
    public int insertTable(Map map) {
        return stationMapper.insertTable(map);
    }

    @Override
    public int isTableExist(Map map) {
        return stationMapper.isTableExist(map);
    }

    @Override
    public int insertData(Map map) {
        return stationMapper.insertData(map);
    }
}

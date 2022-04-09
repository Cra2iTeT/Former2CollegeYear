package com.tea.lesson03.service;

import com.tea.lesson03.mapper.LineMapper;
import com.tea.lesson03.pojo.Line;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cra2iTeT
 * @version 1.0
 * @date 2022/3/25 10:39
 */
@Service
public class LineServiceImpl implements LineService {
    private final LineMapper lineMapper;

    public LineServiceImpl(LineMapper lineMapper) {
        this.lineMapper = lineMapper;
    }

    @Override
    public List<Line> selectLineIdByStationId(Map map) {
        List<Line> lines = this.lineMapper.select(map);

        for (Line line : lines) {
            line.setStationIds(line.getStationId());
        }

        return lines;
    }

    @Override
    public Line selectLineByLineId(Map map) {
        Line line = this.lineMapper.select(map).get(0);
        if (line != null) {
            line.setStationIds(line.getStationId());
        }

        return line;
    }

    @Override
    public List<Line> selectAllLines(Map map) {
        List<Line> lines = lineMapper.select(map);

        for (Line line : lines) {
            line.setStationNum(line.getStationId());
            line.setStationIds(line.getStationId());
        }
        return lines;
    }

    @Override
    public int isTableExist(Map map) {
        return lineMapper.isTableExist(map);
    }

    @Override
    public int insertTable(Map map) {
        return lineMapper.insertTable(map);
    }

    @Override
    public int insertData(Map map) {
        return lineMapper.insertData(map);
    }
}

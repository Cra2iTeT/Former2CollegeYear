package com.alice.service;
import com.alice.pojo.BPIS;
import java.util.List;
public interface BpisService {
    List<BPIS> getAllBPIS();
    BPIS selectBpisById(String HouseID);
    List<BPIS> selectByType(String Type,String select);
    int insertBPI(BPIS bpis);
    int deleteByID(String HouseID);
    int updataDPI(BPIS bpis);
}
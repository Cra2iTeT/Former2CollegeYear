package com.alice.service;
import com.alice.mapper.BpisMapper;
import com.alice.pojo.BPIS;
import java.util.List;
import static javafx.scene.input.KeyCode.H;
public class BpisServiceImpl implements BpisService{
    private BpisMapper bpisMapper;
    public void setBpisMapper(BpisMapper bpisMapper){
        this.bpisMapper=bpisMapper;
    }
    @Override
    public List<BPIS> getAllBPIS() {
        return bpisMapper.getAllBPIS();
    }
    @Override
    public BPIS selectBpisById(String HouseID) {
        return bpisMapper.selectBpisById(HouseID);
    }
    @Override
    public List<BPIS> selectByType(String Type, String select) {
        if (Type.equals("RoomType")) {
            return bpisMapper.selectBpisByRoomType(select);
        } else if (Type.equals("Year")) {
            return bpisMapper.selectBpisByYear(select);
        } else if (Type.equals("Sales")) {
            return bpisMapper.selectBpisBySales(select);
        } else if (Type.equals("Status")) {
            return bpisMapper.selectBpisByStatus(select);
        } else if (Type.equals("AgentID")) {
            return bpisMapper.selectBpisByAgentID(select);
        } else if (Type.equals("UserID")) {
            return bpisMapper.selectBpisByUserID(select);
        } else if (Type.equals("Address")) {
            return bpisMapper.getBpisByLike(select);
        } else {
            return null;
        }
    }
    @Override
    public int insertBPI(BPIS bpis) {
        return bpisMapper.insertBPI(bpis);
    }
    @Override
    public int deleteByID(String HouseID) {
        return bpisMapper.deleteByID(HouseID);
    }
    @Override
    public int updataDPI(BPIS bpis) {
        return bpisMapper.updataDPI(bpis);
    }
}


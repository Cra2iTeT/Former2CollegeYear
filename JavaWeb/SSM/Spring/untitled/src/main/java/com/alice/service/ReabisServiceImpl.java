package com.alice.service;
import com.alice.mapper.ReabisMapper;
import com.alice.pojo.REABIS;
import java.util.List;
public class ReabisServiceImpl implements ReabisService {
    private ReabisMapper reabisMapper;
    public void setReabisMapper(ReabisMapper reabisMapper){this.reabisMapper=reabisMapper;}
    @Override
    public List<REABIS> getAllReabis() {
        return reabisMapper.getAllReabis();
    }
    @Override
    public List<REABIS> selectReabByNameLike(String AgentName) {
        return reabisMapper.selectReabByNameLike(AgentName);
    }
    @Override
    public List<REABIS> selectReabByAddressLike(String AgentAddress) {
        return reabisMapper.selectReabByAddressLike(AgentAddress);
    }
    @Override
    public REABIS selectReabByPhone(String Phone) {
        return reabisMapper.selectReabByPhone(Phone);
    }
    @Override
    public REABIS selectReabByAgentID(String AgentID) {
        return reabisMapper.selectReabByAgentID(AgentID);
    }
    @Override
    public int deleteReab(String AgentID) {
        return reabisMapper.deleteReab(AgentID);
    }
    @Override
    public int addReab(REABIS reabis) {
        return reabisMapper.addReab(reabis);
    }
    @Override
    public int updataReab(REABIS reabis) {
        return reabisMapper.updataReab(reabis);
    }
}
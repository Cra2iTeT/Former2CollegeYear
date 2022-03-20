package com.alice.service;
import com.alice.pojo.REABIS;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
public interface ReabisService {
    List<REABIS> getAllReabis();
    List<REABIS> selectReabByNameLike(String AgentName);
    List<REABIS> selectReabByAddressLike(String AgentAddress);
    REABIS selectReabByPhone(String Phone);
    REABIS selectReabByAgentID(String AgentID);
    int deleteReab(String AgentID);
    int addReab(REABIS reabis);
    int updataReab(REABIS reabis);
}

package com.alice.mapper;
import com.alice.pojo.REABIS;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
public interface ReabisMapper {
    @Select("select * from reabis")
    List<REABIS> getAllReabis();
    @Select("select * from reabis where AgentName like concat('%',#{AgentName},'%')")
    List<REABIS> selectReabByNameLike(String AgentName);
    @Select("select * from reabis where AgentAddress like concat('%',#{AgentAddress},'%')")
    List<REABIS> selectReabByAddressLike(String AgentAddress);
    @Select("select * from reabis where Phone=#{Phone}")
    REABIS selectReabByPhone(String Phone);
    @Select("select * from reabis where AgentID=#{AgentID}")
    REABIS selectReabByAgentID(String AgentID);
    @Delete("delete from reabis where AgentID = #{AgentID}")
    int deleteReab(String AgentID);
    @Update("update reabis set AgentName = #{AgentName},AgentAddress = #{AgentAddress},Phone = #{Phone},AgentPWD = #{AgentPWD} where AgentID = #{AgentID}")
    int addReab(REABIS reabis);
    @Insert("insert into reabis(AgentID,AgentName,AgentAddress,Phone,AgentPWD) values(#{AgentID},#{AgentName},#{AgentAddress},#{Phone},#{UserAddress},#{AgentPWD})")
    int updataReab(REABIS reabis);
}

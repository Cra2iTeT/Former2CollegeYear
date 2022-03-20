package com.alice.mapper;
import com.alice.pojo.BPIS;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
public interface BpisMapper {
    @Select("select * from bpis")
    List<BPIS> getAllBPIS();
    @Select("select * from bpis where HouseID=#{HouseID}")
    BPIS selectBpisById(String HouseID);
    @Select("select * from bpis where RoomType=#{RoomType}")
    List<BPIS> selectBpisByRoomType(String RoomType);
    @Select("select * from bpis where Year=#{Year}")
    List<BPIS> selectBpisByYear(String Year);
    @Select("select * from bpis where Sales=#{Sales}")
    List<BPIS> selectBpisBySales(String Sales);
    @Select("select * from bpis where Status=#{Status}")
    List<BPIS> selectBpisByStatus(String Status);
    @Select("select * from bpis where AgentID=#{AgentID}")
    List<BPIS> selectBpisByAgentID(String AgentID);
    @Select("select * from bpis where UserID=#{UserID}")
    List<BPIS> selectBpisByUserID(String UserID);
    @Select("select * from bpis where Address like concat('%',#{Address},'%')")
    List<BPIS> getBpisByLike(String Address);
    @Insert("insert into bpis(HouseID,RoomType,Address,Year,Status,AgentID,UserID) values(#{HouseID},#{RoomType},#{Address},#{Year},#{Status},#{AgentID},#{UserID})")
    int insertBPI(BPIS bpis);
    @Delete("delete from bpis where HouseID = #{HouseID}")
    int deleteByID(String HouseID);
    @Update("update bpis set RoomType = #{RoomType},Address = #{Address},Year = #{Year},Status = #{Status},AgentID = #{AgentID},UserID = #{UserID} where HouseID = #{HouseID}")
    int updataDPI(BPIS bpis);
}

package com.alice.mapper;
import com.alice.pojo.CBIS;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
public interface CbisMapper {
    @Select("select * from cbis")
    List<CBIS> getAllCBIS();
    @Select("select * from cbis where UserName like concat('%',#{UserName},'%')")
    List<CBIS> selectCbisByNameLike(String UserName);
    @Select("select * from cbis where IdNumber = #{IdNumber}")
    CBIS selectCbisByIdNumber(String IdNumber);
    @Select("select * from cbis where Phone = #{Phone}")
    CBIS selectCbisByPhone(String Phone);
    @Select("select * from cbis where UserID = #{UserID}")
    CBIS selectCbisByUserID(String UserID);
    @Select("select * from cbis where UserName like concat('%',#{UserAddress},'%')")
    List<CBIS> selectCbisUserAddressLike(String UserAddress);
    @Insert("insert into cbis(UserID,UserName,sex,IdNumber,Phone,UserAddress,UserPWD) values(#{UserID},#{UserName},#{sex},#{IdNumber},#{Phone},#{UserAddress},#{UserPWD})")
    int addUser(CBIS cbis);
    @Update("update cbis set UserName = #{UserName},sex = #{sex},IdNumber = #{IdNumber},Phone = #{Phone},UserAddress = #{UserAddress},UserPWD = #{UserPWD} where UserID = #{UserID}")
    int updataUser(CBIS cbis);
    @Delete("delete from cbis where UserID = #{UserID}")
    int deleteUser(String UserID);
}


package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();

    //方法存在多个参数时，各个参数前必须加@Param
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into `user` (id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    @Update("update `user` set name = #{name},pwd = #{pwd} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from `user` where id = #{id}")
    int deleteUser(@Param("id") int id);
}

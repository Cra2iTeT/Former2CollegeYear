package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from `teacher` where id = #{tId}")
    Teacher getTeacher(@Param("tId") int id);
}

package com.Cra2iTeT.mapper;

import com.Cra2iTeT.bean.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有的学生信息，以及对应的老师信息
    public List<Student> getStuList();
    public List<Student> getStuList2();
}

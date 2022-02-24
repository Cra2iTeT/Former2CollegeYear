package com.Cra2iTeT.bean;

import lombok.Data;

@Data
public class Student {
    private String name;
    private int id;

    //学生需要关联一个老师
    private Teacher teacher;
}

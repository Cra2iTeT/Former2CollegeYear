package com.Cra2iTeT.pojo;

import lombok.*;

@Data//代表getter,setter
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
@ToString//tosstring的注解
public class Stu {
    private int sid;
    private String sname;
    private String sgender;
    private String sclass;
    private String smajor;
}

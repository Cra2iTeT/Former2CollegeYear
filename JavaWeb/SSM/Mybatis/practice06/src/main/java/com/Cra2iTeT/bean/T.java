package com.Cra2iTeT.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data//代表getter,setter
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
@ToString//tosstring的注解
public class T {
    private String tid;
    private String tname;
    private String tgender;
    private String tage;
    private String tphone;
    private String tnum;
    private String ta;
    private String tb;
    private String tc;
}

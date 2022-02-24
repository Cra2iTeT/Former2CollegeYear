package com.Cra2iTeT.pojo;

import lombok.*;

@Data//代表getter,setter
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
@ToString//tosstring的注解
public class Tea {
    private int tid;
    private String tname;
    private String tgender;
    private String tcollege;
    private String ttitle;
}

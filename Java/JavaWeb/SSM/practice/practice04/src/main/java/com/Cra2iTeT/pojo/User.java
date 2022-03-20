package com.Cra2iTeT.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id; //账号
    private String name;    //用户名
    private String password;    //密码
    private int gender; //性别
}

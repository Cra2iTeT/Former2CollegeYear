package com.Cra2iTeT.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String password;
    private String name;
    private int departId;
    private String departName;
    private int jurisdiction;   //职员权限，例如厂长副厂长权限不同
    private String position;    //职员职位，如厂长副厂长
    private int state;  //职员状态，0停职，1正常工作
}

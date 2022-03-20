package com.Cra2iTeT.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private int id; //职工id
    private String password;    //职工密码
    private String name;    //职工姓名
    private int did;    //职工大部门 0管理员，1办公室，2财务，3销售，4生产
    private int sid;    //职工部门内分工
    private int state;  //员工工作状态，0停，1正常
    private String depart; //职工部门名称
}

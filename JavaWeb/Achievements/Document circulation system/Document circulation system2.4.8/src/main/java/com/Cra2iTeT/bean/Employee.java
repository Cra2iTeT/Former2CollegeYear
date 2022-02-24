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
    private int jurisdictionNum;   //职员权限，例如厂长副厂长权限不同
    private String jurisdiction;
    private String position;    //职员职位，如厂长副厂长
    private int stateNum;  //职员状态，0停职，1正常工作
    private String state;

    public void setState(int stateNum) {
        switch (stateNum) {
            case 0:
                state = "停职";
                break;
            case 1:
                state = "在职";
                break;
        }
    }

    public void setJurisdiction(int jurisdictionNum) {
        switch (jurisdictionNum) {
            case 0:
                jurisdiction = "默认权限";
                break;
            case 1:
                jurisdiction = "主管生产";
                break;
            case 2:
                jurisdiction = "主管销售";
                break;
            case 3:
                jurisdiction = "主管财务";
                break;
        }
    }
}

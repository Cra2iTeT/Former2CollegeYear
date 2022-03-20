package com.Cra2iTeT.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    private int id; //公文id
    private String title;   //公文标题
    private String text;    //公文正文
    private int departId;
    private String departName;   //公文拟制部门
    private String authorName;  //公文拟制作者
    private int authorId;
    private int stateNum;  //公文签审状态
    private String state;
    private String advice;  //公文签审意见
    private int approveId; //审批人
    private String approveName;

    public void setState(int stateNum) {
        switch (stateNum) {
            case 0:
                state = "已拟制";
                break;
            case 1:
                state = "已发送";
                break;
            case 2:
                state = "已签审";
                break;
        }
    }
}

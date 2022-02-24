package com.Cra2iTeT.pojo;

import java.util.Date;

public class User {
    private Integer id;//id;
    private String userCode;//用户编码
    private String userName;//用户姓名
    private String userPassword;//用户密码
    private Integer gender;//性别
    private Date birthday;//出生日期
    private String address;//地址
    private String phone;//电话
    private Integer userRole;//用户角色
    private Integer createdBy;//创建者
    private Date creationDate;//创建日期
    private Integer modifyBy;//更新者
    private Date modifyDate;//更新日期

    private Integer age;//年龄，通过方法计算

    private String userRoleName;//用户角色名称

    public String getUserRoleName() {
        return this.userRoleName;
    }


    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserRole() {
        return this.userRole;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public Integer getAge() {
        Date date = new Date();
        Integer age = date.getYear() - birthday.getYear();
        return age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", userRole=" + userRole +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", age=" + age +
                ", userRoleName='" + userRoleName + '\'' +
                '}';
    }
}

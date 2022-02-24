package com.Cra2iTeT.bean;

public class Student {
    private int id;
    private String name;
    private String gender;
    private String cl;
    private String major;

    public Student() {
        this.id = 0;
    }

    public Student(int id, String name, String gender, String cl, String major) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.cl = cl;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}

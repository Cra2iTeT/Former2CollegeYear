package com.Cra2iTeT.bean;

public class Teacher {
    private int id;
    private String name;
    private String gender;
    private String college;
    private String cl;

    public Teacher() {
        this.id = 0;
    }

    public Teacher(int id, String name, String gender, String college, String cl) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.cl = cl;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }
}

package com.Cra2iTeT.bean;

public class Cl {
    private int id;
    private int tid;
    private String name;
    private int num;
    private String tname;

    public Cl() {
    }

    public Cl(int id, int tid, String name, int num, String tname) {
        this.id = id;
        this.tid = tid;
        this.name = name;
        this.num = num;
        this.tname = tname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}

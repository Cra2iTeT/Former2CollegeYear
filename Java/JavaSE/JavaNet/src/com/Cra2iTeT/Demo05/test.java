package com.Cra2iTeT.Demo05;

public class test {
    public static void main(String[] args) {
        System.out.println(A.m);
    }
}

class A {
    static int m = 100;

    static {
        m = 300;
    }

    public A() {

    }
}

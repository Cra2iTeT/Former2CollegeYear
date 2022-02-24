package com.Cra2iTeT.Demo02;

import java.util.concurrent.locks.ReentrantLock;

public class lockTest {
    public static void main(String[] args) {
        test test = new test();
        new Thread(test).start();
        new Thread(test).start();
        new Thread(test).start();
    }
}

class test implements Runnable{
    int num = 10;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(num>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(num--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}

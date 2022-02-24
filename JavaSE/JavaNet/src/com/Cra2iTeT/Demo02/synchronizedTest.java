package com.Cra2iTeT.Demo02;

public class synchronizedTest {
    public static void main(String[] args) {
        buy b = new buy();
        new Thread(b, "我").start();
        new Thread(b, "你").start();
        new Thread(b, "他").start();

    }
}

class buy implements Runnable {
    private int num = 10;
    boolean flag = true;

    @Override
    public void run() {
        synchronized(this){
            while (flag) {
                try {
                    bu();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private void bu() throws InterruptedException {
        if (num <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName() + "买到了" + num--);
    }
}

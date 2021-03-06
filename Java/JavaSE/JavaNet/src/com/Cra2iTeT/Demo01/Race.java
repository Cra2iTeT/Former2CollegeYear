package com.Cra2iTeT.Demo01;

//模拟龟兔赛跑
public class Race implements Runnable {

    private static String winner;//胜利者

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            //模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子") && i % 10 == 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //比赛结束判断
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "已经跑了" + i + "步");
        }
    }

    //判断比赛是否结束
    private boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}

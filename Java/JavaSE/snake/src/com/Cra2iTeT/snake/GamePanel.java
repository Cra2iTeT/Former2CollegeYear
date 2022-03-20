package com.Cra2iTeT.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int length;//蛇的长度
    int[] snakeX = new int[600];//蛇的x坐标
    int[] snakeY = new int[500];//蛇的y坐标
    String fx = "R";//R:右,L:左,U:上,D:下

    boolean isStart = false;//游戏开始标志

    Timer timer = new Timer(100, this);//定时器

    int foodX;//食物的x坐标
    int foodY;//食物的y坐标
    Random random = new Random();

    boolean isFail = false;//游戏失败标识

    int score;//积分

    //构造器
    public GamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    //初始化方法
    public void init() {
        length = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);
        score = 0;
    }

    //食物坐标生成


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);

        Data.header.paintIcon(this, g, 25, 11);//顶部广告栏

        g.fillRect(25, 75, 850, 600);

        //绘制静态的蛇
        if (fx.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        //积分系统
        g.setColor(Color.white);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度：" + length, 750, 35);
        g.drawString("分数：" + score, 750, 50);

        //绘制食物
        Data.food.paintIcon(this, g, foodX, foodY);

        //游戏开始判断
        if (isStart == false) {
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));//设置字体格式
            g.drawString("按下空格键开始游戏", 300, 350);
        }

        //游戏失败判断
        if (isFail) {
            g.setColor(Color.red);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));//设置字体格式
            g.drawString("游戏失败，按下空格键重新开始", 175, 350);
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFail) {
                isFail = false;
                init();//重新初始化游戏
            } else {
                isStart = !isStart;
            }
            repaint();//刷新
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        } else if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && isFail == false) {
            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            if (fx.equals("R")) {
                snakeX[0] = snakeX[0] + 25;
                //边界判断
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (fx.equals("L")) {
                snakeX[0] = snakeX[0] - 25;
                //边界判断
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (fx.equals("U")) {
                snakeY[0] = snakeY[0] - 25;
                //边界判断
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (fx.equals("D")) {
                snakeY[0] = snakeY[0] + 25;
                //边界判断
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }

            //是否吃到食物判断
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                length++;//长度增加

                //新的食物生成
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);

                score += 10;//增加积分
            }

            //结束判断
            for (int i = 1; i < length; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                    isFail = true;
                }
            }
            repaint();//刷新
        }
        timer.start();
    }
}

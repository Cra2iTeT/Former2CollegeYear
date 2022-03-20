package com.Cra2iTeT.snake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Cra2iTeT");

        jFrame.setBounds(10,10,915,720);
        jFrame.setResizable(false);//窗口固定不可修改
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.add(new GamePanel());
        jFrame.setVisible(true);
    }
}

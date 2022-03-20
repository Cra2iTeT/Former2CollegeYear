package com.Cra2iTeT.snake;

import javax.swing.*;
import java.net.URL;

/**
 * 存放外部数据
 */
public class Data {
    //顶部广告
    public static URL headerUrl = Data.class.getResource("/statics/header.png");
    public static ImageIcon header = new ImageIcon(headerUrl);

    //蛇头部
    public static URL upUrl = Data.class.getResource("/statics/up.png");
    public static URL leftUrl = Data.class.getResource("/statics/left.png");
    public static URL rightUrl = Data.class.getResource("/statics/right.png");
    public static URL downUrl = Data.class.getResource("/statics/down.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    //身体
    public static URL bodyUrl = Data.class.getResource("/statics/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);
    //食物
    public static URL foodUrl = Data.class.getResource("/statics/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);

}

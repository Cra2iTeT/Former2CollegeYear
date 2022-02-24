package Lesson.lesson4;

import java.util.Scanner;


public class main {
    public static void show() {
        System.out.println("1.参数设置");
        System.out.println("2.小学二年级口算题");
        System.out.println("3.小学三年级口算题");
        System.out.println("4.小学四年级口算题");
    }

    public static void showP() {
        System.out.println("1.做新题");
        System.out.println("2.做错题");
    }

    public static void main(String[] args) {
        int nums = 30;//出题个数
        int rangeMin = 0;//出题下限
        int rangeMax = 10;//出题上限

        Scanner sc = new Scanner(System.in);

        while (true) {
            show();
            int choice;
            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.println("请输入出题个数：");
                    nums = sc.nextInt();
                    System.out.println("请输入出题下限：");
                    rangeMin = sc.nextInt();
                    System.out.println("请输入出题上限：");
                    rangeMax = sc.nextInt();
                    break;
                }

                case 2: {
                    Second sd = new Second(nums, 2, rangeMin, rangeMax);
                    int flag = 1;
                    int i = 0;
                    while (i < nums && flag != 0) {
                        if (sd.judge() == 0) {
                            flag = 1;
                            break;
                        } else {
                            showP();
                            flag = sc.nextInt();
                            if (flag == 1) {
                                sd.ff();
                            } else {
                                sd.f6();
                            }
                            i++;
                            System.out.println("按任一数字键继续,输入'0'回到主界面");
                            flag = sc.nextInt();
                        }
                    }
                    break;
                }

                case 3: {
                    Third td = new Third(nums, 4, rangeMin, rangeMax);
                    int flag = 1;
                    int i = 0;
                    while (i < nums && flag != 0) {
                        if (td.judge() == 0) {
                            flag = 1;
                            break;
                        } else {
                            showP();
                            flag = sc.nextInt();
                            if (flag == 1) {
                                td.ff();
                            } else {
                                td.f6();
                            }
                            i++;
                            System.out.println("按任一数字键继续,输入'0'回到主界面");
                            flag = sc.nextInt();
                        }
                    }
                    break;
                }

                case 4: {
                    Forth ft = new Forth(nums, 4, rangeMin, rangeMax);
                    int flag = 1;
                    int i = 0;
                    while (i < nums && flag != 0) {
                        showP();
                        ft.judge();
                        flag = sc.nextInt();
                        if (flag == 1) {
                            ft.ff();
                        } else {
                            ft.f6();
                        }
                        i++;
                        System.out.println("按任一数字键继续,输入'0'回到主界面");
                        flag = sc.nextInt();
                    }
                    break;
                }
            }
        }
    }
}
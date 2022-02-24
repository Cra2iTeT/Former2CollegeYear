package Lesson.lesson2;


import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入需要生成的题数");
        int choice1 = sc.nextInt();
        //System.out.println(len);
        System.out.println("请输入需要生成的操作数");
        int choice2 = sc.nextInt();
        //System.out.println(len2);
        System.out.println("请输入是否需要加入乘除法,1表示需要,0表示不需要");
        int choice3=sc.nextInt();
        System.out.println("请输入是否需要括号,1表示需要,0表示不需要");
        int choice4=sc.nextInt();
        System.out.println("请输入操作数的最小范围");
        int choice5=sc.nextInt();
        System.out.println("请输入操作数的最大范围");
        int choice6=sc.nextInt();


        new fun(choice1,choice2,choice3,choice4,choice5,choice6);


    }
}

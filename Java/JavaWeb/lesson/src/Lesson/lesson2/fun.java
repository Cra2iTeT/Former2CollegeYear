package Lesson.lesson2;

import java.util.Random;

public class fun {
    public int len1;//打印个数
    public int len2;//操作数个数
    public int multi;//乘除法
    public int paren;//括号
    public int leftR;//最小值
    public int rightR;//最大值
    public int leftP;//左括号
    public int rightP;//右括号
    public int index;//记录重复生成次数是否过多
    int[] a;//存储操作数
    int[] b;//存储操作符
    String[] jiLu;//记录出现过的题目

    public fun(int i1, int i2, int i3, int i4, int i5, int i6) {

        this.len1 = i1;
        this.len2 = i2;
        this.multi = i3;
        this.paren = i4;
        this.leftR = i5;
        this.rightR = i6;
        //System.out.println("------"+i1);
        //System.out.println("------"+i2);
        a = new int[len1];//存储操作数
        b = new int[len2];//存储操作符
        jiLu = new String[len1];//记录出现过的题目

        if (this.multi == 1) {
            this.multi = 4;
        } else {
            this.multi = 2;
        }

        Random random = new Random();

        int i = 0;
        if (this.paren == 1) {
            this.paren = len1;
        }

        while (i < len1) {
            jiLu[i] = "";
            String str = "";

            for (int j = 0; j < len2; j++) {//生成操作数
                //System.out.println(j);
                a[j] = random.nextInt(this.rightR - this.leftR + 1) + this.leftR;
                //System.out.println(a[j]);
                //101+200=200-300
                jiLu[i]+=a[j];
            }

            for (int j = 0; j < len2 - 1; j++) {//生成操作符
                b[j] = random.nextInt(this.multi);
                jiLu[i]+=b[j];
            }

            if (this.paren != 0) {
                //0+0+0=
                this.leftP = random.nextInt(len2 - 1);//左括号能存在的位置
                jiLu[i] += this.leftP;
                //System.out.print("------"+this.leftP);
                //0,1,2,3,4
                this.rightP = random.nextInt(len2 - this.leftP - 1) + this.leftP + 1;//右括号位置
                //System.out.println("------"+this.leftP);
                jiLu[i]+=this.rightP;
            }

            int flag = f3(i);

            if (flag == 0) {
                int iFlag = 0;
                for (int j = 0; j < len2; j++) {
                    if (this.paren >= 1 && this.leftP == j) {
                        System.out.print("(");
                    }
                    System.out.print(a[j]);
                    if (this.paren >= 1 && this.rightP == j) {
                        System.out.print(")");
                        this.paren--;
                    }
                    if (iFlag != len2 - 1) {
                        this.f2(b[j]);
                    }
                    iFlag++;

                }

                System.out.println("=");

                //System.out.println(i);

                i++;
            }

        }
    }

    public int f3(int i){
        if (this.index >= len1 * len1) {
            i = len1;
            System.out.println("重复生成次数过多，程序自动结束，请检查操作数个数与生成题目之间是否合法");
        }

        for (int j = 1; j < i; j++) {
            //System.out.println("-------1");
            //System.out.println(jiLu[j]);
            if (jiLu[j].equals(jiLu[i])) {
                this.index++;
                return 1;
            }
        }

        //System.out.println("-------3");

        return 0;
    }

    public void f2(int i) {
        if (i == 0) {
            System.out.print("+");
        } else if (i == 1) {
            System.out.print("-");
        } else if (i == 2) {
            System.out.print("*");
        } else if (i == 3) {
            System.out.print("/");
        }
    }
}

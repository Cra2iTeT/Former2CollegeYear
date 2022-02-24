package Lesson.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Second {
    public int len1;//打印个数
    public int len2;//操作数个数
    public int multi = 1;//乘除法
    public int paren = 0;//括号
    public int leftR;//最小值
    public int rightR;//最大值
    public int leftP;//左括号
    public int rightP;//右括号
    public int index;//记录重复生成次数是否过多
    double[] a;//存储操作数
    int[] b;//存储操作符
    String[] jiLu;//记录出现过的题目
    double[] result;//记录答案
    int[] fault;//记录错题下标
    int id;
    int cs = 2;

    public int judge() {
        if (this.rightR - this.leftR >= 100) {
            System.out.println("操作数范围超过限制，请返回后重新配置正确");
            return 0;
        } else return 1;
    }

    public Second() {
    }

    public Second(int i1, int i2, int i5, int i6) {
        this.len1 = i1;
        this.len2 = i2;
        this.leftR = i5;
        this.rightR = i6;
        a = new double[len2];//存储操作数
        b = new int[len2 - 1];//存储操作符
        jiLu = new String[len1];//记录出现过的题目
        result = new double[len1];
        fault = new int[len1 + 1];
        id = 0;
    }

    public void ff() {
        double index = 0.0;
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

        int temp = 1;
        while (i < len1 && temp != 0) {
            jiLu[i] = "";
            String str = "";
            for (int j = 0; j < len2 - 1; j++) {//生成操作符
                b[j] = random.nextInt(this.multi);
                jiLu[i] += b[j];
            }

            for (int j = 0; j < len2; j++) {//生成操作数
                //System.out.println(j);
                a[j] = random.nextInt(this.rightR - this.leftR + 1) + this.leftR;
                if (j > 0) {
                    int tempR = 1;
                    double temP = 1;
                    if (this.cs == 2) {
                        tempR = (int) (a[j - 1] / a[j]);
                        temP = a[j] - temp;
                        if (temP - tempR != 0) {
                            b[j - 1] = random.nextInt(2);
                        }
                    }
                    while (b[j - 1] == 3 && a[j] == 0) {
                        //System.out.println("----");
                        a[j] = random.nextInt(this.rightR - this.leftR + 1) + this.leftR;
                    }
                }
                jiLu[i] += a[j];
            }

            if (this.paren != 0) {
                //0+0+0=
                this.leftP = random.nextInt(len2 - 1);//左括号能存在的位置
                jiLu[i] += this.leftP;
                this.rightP = random.nextInt(len2 - this.leftP - 1) + this.leftP + 1;//右括号位置
                jiLu[i] += this.rightP;
            }

            int flag = f3(i);//计算是否重复
            jiLu[i] = "";
            if (flag == 0) {
                int iFlag = 0;
                for (int j = 0; j < len2; j++) {
                    if (this.paren >= 1 && this.leftP == j) {
                        System.out.print("(");
                        jiLu[i] += "(";
                    }
                    System.out.print((int) a[j]);
                    jiLu[i] += (int) a[j];
                    if (this.paren >= 1 && this.rightP == j) {
                        System.out.print(")");
                        jiLu[i] += ")";
                        this.paren--;
                    }
                    if (iFlag != len2 - 1) {
                        System.out.print(this.f2(b[j]));
                        jiLu[i] += this.f2(b[j]);
                    }
                    iFlag++;
                }
                System.out.print("=");
                jiLu[i] += "=";
                f4(i);
                if (f5(i) == 0) {
                    this.fault[this.id] = i;
                    this.setId();
                    index++;
                }
                System.out.println("是否继续答题,按任一数字键继续，按0返回");
                Scanner sc = new Scanner(System.in);
                temp = sc.nextInt();
                i++;
            }
        }
        System.out.print("错题率为：");
        //System.out.println(index);
        //System.out.println(len1);
        double len = i + 0.0;
        double rate = index * 100 / len;
        //System.out.println(rate);
        System.out.println(String.format("%.2f", rate) + "%");
    }

    public void setId() {
        this.id++;
    }

    public int f3(int i) {
        if (this.index >= len1 * len1) {
            i = len1;
            System.out.println("重复生成次数过多，程序自动结束，请检查操作数个数与生成题目之间是否合法");
        }

        for (int j = 1; j < i; j++) {
            if (jiLu[j].equals(jiLu[i])) {
                this.index++;
                return 1;
            }
        }
        return 0;
    }

    public String f2(int i) {
        if (i == 0) {
            return "+";
        } else if (i == 1) {
            return "-";
        } else if (i == 2) {
            return "*";
        } else {
            return "/";
        }
    }

    public double f4(int t) {
        double dR = 0.0;
        if (this.paren == 0) {//没有括号
            for (int j = 0; j < len2 - 1; j++) {
                if (this.b[j] == 1) {
                    a[j + 1] = -a[j + 1];
                }
                if (this.b[j] == 2) {
                    dR = a[j] * a[j + 1];
                    a[j] = 0;
                    a[j + 1] = dR;
                }
                if (this.b[j] == 3) {
                    dR = a[j] / a[j + 1];
                    a[j] = 0;
                    a[j + 1] = dR;
                }
            }

            result[t] = 0.0;
            for (int j = 0; j < len2; j++) {
                result[t] += a[j];
            }
        } else {
            //System.out.println("-----");
            for (int i = this.leftP; i < this.rightP; i++) {//计算括号内
                if (this.b[i] == 1) {
                    a[i + 1] = -a[i + 1];
                }
                if (this.b[i] == 2) {
                    dR = a[i] * a[i + 1];
                    a[i] = 0.0;
                    a[i + 1] = dR;
                }
                if (this.b[i] == 3) {
                    dR = a[i] / a[i + 1];
                    a[i] = 0;
                    a[i + 1] = dR;
                }
            }
            dR = 0.0;
            for (int j = this.leftP; j < this.rightP + 1; j++) {
                dR += a[j];
            }
            a[this.leftP] = dR;//括号内计算结果

            double[] temp = new double[len2 - (this.rightP - this.leftP)];//存去掉括号后的操作数
            int[] tempB = new int[len2 - (this.rightP - this.leftP) - 1];//存括号外的操作符

            temp[this.leftP] = dR;
            if (this.rightP != len2 - 1) {
                tempB[this.leftP] = b[this.rightP];
            }

            for (int i = 0; i < this.leftP; i++) {
                temp[i] = a[i];
                tempB[i] = b[i];
            }
            for (int i = this.rightP + 1, index = this.leftP + 1; i < len2; i++, index++) {
                temp[index] = a[i];
            }
            for (int i = this.rightP + 1, index = this.leftP + 1; i < len2 - 1; i++, index++) {
                tempB[index] = b[i];
            }

            for (int j = 0; j < len2 - (this.rightP - this.leftP) - 1; j++) {
                if (tempB[j] == 1) {
                    temp[j + 1] = -temp[j + 1];
                }
                if (tempB[j] == 2) {
                    dR = temp[j] * temp[j + 1];
                    temp[j] = 0;
                    temp[j + 1] = dR;
                }
                if (tempB[j] == 3) {
                    dR = temp[j] / temp[j + 1];
                    temp[j] = 0;
                    temp[j + 1] = dR;
                }
            }

            result[t] = 0.0;
            for (int j = 0; j < len2 - (this.rightP - this.leftP); j++) {
                result[t] += temp[j];
            }
        }
        return result[t];
    }

    public int f5(int i) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        if ((d - result[i] <= 0.01) && (d - result[i] >= -0.01)) {
            System.out.println("回答正确");
            return 1;
        } else {
            System.out.print("计算错误，正确答案为:");
            System.out.println(String.format("%.2f", result[i]));
            return 0;
        }
    }

    public void f6() {
        for (int i = 0; i < this.id; i++) {
            if (this.fault[i] != -1) {
                System.out.print(jiLu[this.fault[i]]);
                if (f5(this.fault[i]) == 1) {
                    this.fault[i] = -1;
                }
            }
        }
        for (int i = 0; i < this.id; i++) {
            if (this.fault[i] == -1) {
                for (int j = i; j < this.id - 1; j++) {
                    this.fault[j] = this.fault[j + 1];
                }
                this.id--;
            }
        }
        System.out.println("错题展示完毕");
    }
}
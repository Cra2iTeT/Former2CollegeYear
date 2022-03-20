package Lesson.lesson4;

public class Third extends Second {
    public int judge() {
        if (this.rightR - this.leftR >= 1000) {
            System.out.println("操作数范围超过限制，请返回后重新配置正确");
            return 0;
        } else return 1;
    }

    public Third(int i1, int i2, int i5, int i6) {
        this.cs=3;
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
}

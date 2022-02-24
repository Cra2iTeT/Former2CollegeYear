package Lesson.lesson4;

public class Forth extends Second {
    public int judge() {
        this.paren = 1;
        return 1;
    }

    public Forth(int i1, int i2, int i5, int i6) {
        this.cs = 4;
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

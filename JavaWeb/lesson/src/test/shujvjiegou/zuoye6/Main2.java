package test.shujvjiegou.zuoye6;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pointNum, edgeNum;

        pointNum = sc.nextInt();
        edgeNum = sc.nextInt();
        if (pointNum <= 1 || (edgeNum < 0 || edgeNum > (pointNum * (pointNum - 1)))) {
            System.out.print("error");
            return;
        }

        int point[][] = new int[pointNum][pointNum];
        HashMap<Character, Integer> hashMap = new HashMap<>();

        char ch;
        for (int i = 0; i < pointNum; i++) {
            ch = sc.next().charAt(0);
            hashMap.put(ch, i);
            for (int j = 0; j < pointNum; j++) {
                point[hashMap.get(ch)][j] = -1;//初始化
            }
        }

        for (int i = 0; i < edgeNum; i++) {
            char temp;
            ch = sc.next().charAt(0);
            temp = sc.next().charAt(0);
            int value;
            value = sc.nextInt();
            point[hashMap.get(ch)][hashMap.get(temp)] = value;
        }

        for (int i = 0; i < pointNum; i++) {
            System.out.print((char) (i + 97));
            for (int j = pointNum - 1; j >= 0; j--) {
                if (point[i][j] != -1) {
                    System.out.print("->" + j + " " + point[i][j]);
                }
            }
            if (i != pointNum) {
                System.out.println();
            }
        }
    }
}
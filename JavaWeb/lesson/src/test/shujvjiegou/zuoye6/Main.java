package test.shujvjiegou.zuoye6;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pointNum, edgeNum;

        pointNum = sc.nextInt();
        //System.out.println(pointNum);
        edgeNum = sc.nextInt();
        //System.out.println(edgeNum);
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
                point[hashMap.get(ch)][j] = 0;
            }
        }

        for (int i = 0; i < edgeNum; i++) {
            char temp;
            ch = sc.next().charAt(0);
            temp = sc.next().charAt(0);
            point[hashMap.get(ch)][hashMap.get(temp)] = 1;
        }

        for (int i = 0; i < pointNum; i++) {
            for (int j = 0; j < pointNum - 1; j++) {
                System.out.print(point[i][j] + " ");
            }
            if (i != pointNum - 1) {
                System.out.println(point[i][pointNum - 1]);
            } else {
                System.out.print(point[i][pointNum - 1]);
            }
        }
    }
}

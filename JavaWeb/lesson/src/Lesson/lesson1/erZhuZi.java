package Lesson.lesson1;

import java.util.Random;
import java.util.Scanner;

public class erZhuZi {
    public static void main(String[] args) {
        int i = 0;

        int[] a1 = new int[31];
        int[] a2 = new int[31];
        int[] a3 = new int[31];
        int flag = 1;

        int i1 = 0, i2 = 0, i3 = 0, i4 = 0;
        while (i < 30) {
            Random rand = new Random();

            while (flag == 1) {
                int iFlag = 1;
                i1 = rand.nextInt(100);
                a1[i] = i1;
                i2 = rand.nextInt(10);
                a2[i] = i2;
                i3 = rand.nextInt(4);
                a3[i] = i3;
                for (int j = 0; j < i && iFlag != 0; j++) {
                    if (a3[i] == a3[j]) {
                        if (a1[i] == a1[j]) {
                            if (a2[i] == a2[j]) {
                                iFlag = 0;
                            }
                        }
                    }
                }
                if (iFlag != 0) {
                    flag = 0;
                }
            }

            //System.out.println(i3);

            if (i3 == 0) {
                System.out.println(i1 + "+" + i2 + "=");
            } else if (i3 == 1) {
                System.out.println(i1 + "-" + i2 + "=");
            } else if (i3 == 2) {
                System.out.println(i1 + "*" + i2 + "=");
            } else if (i3 == 3) {
                System.out.println(i1 + "/" + i2 + "=");
            }
            i++;
            flag = 1;
        }
    }

}

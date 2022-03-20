package Lesson.lesson7;


import java.io.*;
import java.text.DecimalFormat;

public class IoTest {
    public static void main(String[] args) throws IOException {
        //FileReader fr = new FileReader("C:\\CS\\Java\\IdeaProjects\\lesson\\src\\Lesson\\lesson7\\test.txt");
        char[] chars = new char[1024];

        StringBuilder sb = new StringBuilder();

        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\CS\\Java\\IdeaProjects\\lesson\\src\\Lesson\\lesson7\\test.txt"), "GBK");

        int length = 0;
        while ((length = isr.read(chars)) != -1) {
            sb.append(chars, 0, length);
        }

        //System.out.println(sb.toString().toLowerCase());
        String str = sb.toString();
        /*str.split(" ");
        str.split(",");
        str.split(".");*/
        //System.out.println(str);

        int Up[] = new int[26];
        int Low[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if (0 <= (str.charAt(i) - 97) && ((str.charAt(i) - 97) <= 26)) {
                Low[str.charAt(i) - 97]++;
                //System.out.println(Low[str.charAt(i) - 97]);
                //System.out.println(str.charAt(i) - 97);
            } else if ((0 <= (str.charAt(i) - 65)) && ((str.charAt(i) - 65) <= 26)) {
                Up[str.charAt(i) - 65]++;
                //System.out.println(str.charAt(i) - 65);
            }
        }

        //System.out.println(Low[0]);
        isr.close();
        //System.out.println(sb.toString());

        double all = 0.0;
        for (int i = 0; i < 26; i++) {
            all += Low[i];
        }
        for (int i = 0; i < 26; i++) {
            all += Up[i];
        }

        int LowH[] = new int[26];
        int UpH[] = new int[26];

        for (int i = 0; i < 26; i++) {
            LowH[i] = i;
            UpH[i] = i;
        }

        /*for (int i = 0; i < 26; i++) {
            System.out.println((char) (LowH[i] + 97) + ":" + new DecimalFormat("#.##").format(Low[i] / all * 100) + "%");
        }*/

        //System.out.println((char) (LowH[0] + 97));
        for (int i = 0; i < 25; i++) {
            //System.out.println(i);
            //for (int j = i + 1; j < 26; j++) {
                for (int j = 0; j < 25 - i; j++) {
                if (Low[j] < Low[j+1]) {
                    //if(i==10)
                    //System.out.println((char) (LowH[i] + 97) + "-----" + (char) (LowH[j] + 97));
                    int temp = LowH[j];
                    LowH[j] = LowH[j+1];
                    LowH[j+1] = temp;
                }
                if (Up[i] < Up[j]) {
                    int temp = UpH[i];
                    UpH[i] = UpH[j];
                    UpH[j] = temp;
                }
            }

            /*for (int j = 0; j < 26; j++) {
                System.out.println((char) (LowH[j] + 97));
            }*/

            //System.out.println(i);
            /*System.out.println("---------");
            System.out.println();*/
            //System.out.println((char) (LowH[i] + 97));
            //System.out.println(LowH[i]+" "+i);
        }
        //System.out.println(all);
        //System.out.println(LowH[0]);
        for (int i = 0; i < 26; i++) {
            System.out.println((char) (LowH[i] + 97) + ":" + new DecimalFormat("#.##").format(Low[LowH[i]] / all * 100) + "%");
        }
        for (int i = 0; i < 26; i++) {
            System.out.println((char) (UpH[i] + 65) + ":" + new DecimalFormat("#.##").format(Low[LowH[i]] / all * 100) + "%");
        }

    }

}

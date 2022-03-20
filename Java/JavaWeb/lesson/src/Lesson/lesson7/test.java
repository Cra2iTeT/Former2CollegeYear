package Lesson.lesson7;

import java.io.*;
import java.util.*;
import java.text.*;
public class test {
    public static void main(String[] args)throws IOException
    {
        List<Integer> list=new ArrayList<>();
        DecimalFormat df=new DecimalFormat("######0.00");
        FileInputStream fip = new FileInputStream("C:\\CS\\Java\\IdeaProjects\\lesson\\src\\Lesson\\lesson7\\test.txt");
        InputStreamReader reader = new InputStreamReader(fip, "gbk");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        reader.close();
        fip.close();

        int i;
        String A=sb.toString();
        //System.out.println(A);
        String M="abcdefghijklmnopqrstuvwxyz";
        char NUM[]=new char[A.length()];
        char Z[]=new char[26];
        int X[]=new int[26];
        Z=M.toCharArray();
        for(int k=0;k<26;k++)
        {
            X[k]=0;
            for(i=0;i<A.length();i++)
            {
                NUM[i]=A.charAt(i);
                if(Z[k]==NUM[i]||Z[k]==ch(NUM[i]))
                {
                    X[k]++;
                }
            }
        }
        double sum=0;
        for(i=0;i<25;i++)
            for(int k=0;k<25-i;k++)
            {
                if(X[k]<X[k+1])
                {
                    int temp2=X[k];
                    X[k]=X[k+1];
                    X[k+1]=temp2;
                    char temp3=Z[k];
                    Z[k]=Z[k+1];
                    Z[k+1]=temp3;
                }
            }
        for(i=0;i<26;i++)
        {
            sum=sum+X[i];
        }
        System.out.println("一共有"+sum+"个字母。");
        System.out.println("各字母频率如下：");
        for(i=0;i<26;i++)
        {
            double jkl=(X[i])/sum*100;
            System.out.println(Z[i]+":"+df.format(jkl)+"%");
        }
    }
    static char ch(char c)
    {
        if(!(c>=97&&c<=122))
            c+=32;
        return c;
    }


}

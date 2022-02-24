package com.lesson5;

import java.io.*;
import java.util.*;

public class RedirectIn {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("RedirectIn.java");
            //����׼�����ض���fis������
            System.setIn(fis);
            //ʹ��System.in����Scanner�������ڻ�ȡ��׼����
            Scanner sc = new Scanner(System.in);
            //��������һ�н�ֻ�ѻس���Ϊ�ָ���
            sc.useDelimiter("\n");
            //�ж��Ƿ�����һ��������
            while (sc.hasNext()) {
                //���������
                System.out.println("��������������ǣ�" + sc.next());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

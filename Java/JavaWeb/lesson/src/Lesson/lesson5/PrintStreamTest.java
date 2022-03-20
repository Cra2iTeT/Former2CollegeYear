package com.lesson5;

import java.io.*;

public class PrintStreamTest {

    public static void main(String[] args) throws IOException {
        PrintStream ps = null;
        try {
            //����һ���ڵ��������FileOutputStream
            FileOutputStream fos = new FileOutputStream("test.txt");
            //��PrintStream����װFileOutputStream�����
            ps = new PrintStream(fos);
            //ʹ��PrintStreamִ�����
            ps.println("��ͨ�ַ���");
            ps.println(new PrintStreamTest());
        } catch (IOException ioe) {
            ioe.printStackTrace(ps);
        } finally {
            ps.close();
        }
    }
}

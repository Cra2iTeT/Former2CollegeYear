package com.lesson5;

import java.io.*;

public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        FileWriter fw = null;
        try {
            //�����ַ������
            fw = new FileWriter("poem.txt");
            fw.write("��ɪ - ������\r\n");
            fw.write("��ɪ�޶���ʮ�ң�һ��һ��˼���ꡣ\r\n");
            fw.write("ׯ�������Ժ��������۴����жž顣\r\n");
            fw.write("�׺����������ᣬ������ů�����̡�\r\n");
            fw.write("����ɴ���׷�䣬ֻ�ǵ�ʱ���Ȼ��\r\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            //ʹ��finally�����ر��ļ������
            if (fw != null) {
                fw.close();
            }
        }
    }
}

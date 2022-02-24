package com.lesson5;

import java.io.*;

public class KeyinTest {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            //��Sytem.in����ת����Reader����
            InputStreamReader reader = new InputStreamReader(System.in);
            //����ͨReader��װ��BufferedReader
            br = new BufferedReader(reader);
            String buffer = null;
            //����ѭ����ʽ��һ��һ�еĶ�ȡ
            while ((buffer = br.readLine()) != null) {
                //�����ȡ���ַ���Ϊ"exit"�������˳�
                if (buffer.equals("exit")) {
                	System.out.println("�����˳�����");
                    System.exit(1);
                }
                //��ӡ��ȡ������
                System.out.println("��������Ϊ:" + buffer);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } //�ر�������
        finally {
            try {
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}

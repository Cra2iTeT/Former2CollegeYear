package com.lesson5;

import java.io.*;
import java.util.*;
 
public class ByteArrayStreamDemo {
    public static void main(String[] args) {
        try { 
            File file = new File("test.txt"); 
            BufferedInputStream bufferedInputStream = 
                new BufferedInputStream( 
                     new FileInputStream(file)); 

            ByteArrayOutputStream arrayOutputStream = 
                new ByteArrayOutputStream(); 

            byte[] bytes = new byte[10];             

            // ���ļ�����д��λ������
            while(bufferedInputStream.read(bytes) != -1) {
                arrayOutputStream.write(bytes);
            }
            arrayOutputStream.close(); 
            bufferedInputStream.close(); 

             // ���ַ���ʽ��ʾλ�������� 
            bytes = arrayOutputStream.toByteArray(); 
            for(int i = 0; i < bytes.length; i++) {
                System.out.print((char) bytes[i]);
            }
            System.out.println(); 

            // ��ʹ��������λ�����ַ��޸�λ�������� 
            Scanner scanner = new Scanner(System.in);

            System.out.print("�����޸�λ�ã�"); 
            int pos = scanner.nextInt();
            System.out.print("�����޸��ַ���"); 
           // �޸������ж�Ӧ���ַ�
            bytes[pos-1] = (byte) scanner.next().charAt(0);

            // ��λ�������ݴ���ļ� 
            ByteArrayInputStream byteArrayInputStream = 
                new ByteArrayInputStream(bytes); 
            BufferedOutputStream bufOutputStream = 
                new BufferedOutputStream( 
                     new FileOutputStream(file)); 
            byte[] tmp = new byte[1]; 
            while(byteArrayInputStream.read(tmp) != -1) 
                bufOutputStream.write(tmp); 
            byteArrayInputStream.close(); 
            bufOutputStream.flush(); 
            bufOutputStream.close(); 
        } 
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    }
}
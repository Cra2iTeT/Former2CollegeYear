package com.lesson5;

import java.io.*;
 
public class BufferedReaderWriterDemo { 
    public static void main(String[] args) { 
        try { 
        	System.out.println("�����ı�������quit����");
           // ����System.in������
            BufferedReader bufReader = 
                new BufferedReader(
                      new InputStreamReader(System.in)); 
           // ����FileWriter�ַ������
            BufferedWriter bufWriter = 
                new BufferedWriter(new FileWriter("Hello.txt")); 
 
            String input = null; 

           // ÿ��һ�н���һ��д�붯��
            while(!(input = 
                      bufReader.readLine()).equals("quit")) { 
                bufWriter.write(input); 
                 // newLine()����д�������ϵͳ�����Ļ����ַ�
                bufWriter.newLine(); 
            } 
 
            bufReader.close(); 
            bufWriter.close(); 
        } 
         
        catch(IOException e) { 
            e.printStackTrace(); 
        } 
    } 
} 
package com.lesson5;

import java.io.*;
import java.util.*;
 
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Justin", 90), 
                new Student("momor", 95), 
                new Student("Bush", 88), 
                new Student("caterpillar", 84)}; 
        
        try {
            File file = new File("student.dat");
            // ����RandomAccessFileʵ�����Զ�дģʽ�����ļ�
            RandomAccessFile randomAccessFile = 
                    new RandomAccessFile(file, "rw"); 
            
            for(int i = 0; i < students.length; i++) { 
              // ʹ�ö�Ӧ��write����д������
              randomAccessFile.writeChars(students[i].getName());
              randomAccessFile.writeInt(students[i].getScore()); 
            }
 
            Scanner scanner = new Scanner(System.in);
 
            System.out.print("��ȡ�ڼ������ݣ�"); 
            
            int num = scanner.nextInt(); 
            
            // ʹ��seek()����������ȡλ��
            randomAccessFile.seek((num-1) * Student.size()); 
            Student student = new Student(); 

            // ʹ�ö�Ӧ��read������������
            student.setName(readName(randomAccessFile));
            student.setScore(randomAccessFile.readInt());

            System.out.println("������" + student.getName());
            System.out.println("������" + student.getScore());
 
            // �趨�ر��ļ�
            randomAccessFile.close(); 
        }
        catch(IOException e) { 
            e.printStackTrace(); 
        }
    }
 
    private static String readName(
                           RandomAccessFile randomAccessfile)
                               throws IOException { 
        char[] name = new char[15]; 
 
        for(int i = 0; i < name.length; i++) 
            name[i] = randomAccessfile.readChar(); 

        // �����ַ�ȡ��Ϊ�ո��������
        return new String(name).replace('\0', ' '); 
    } 
}


class Student {
    private String name; 
    private int score; 
 
    public Student() { 
        setName("noname"); 
    } 
 
    public Student(String name, int score) {
        setName(name);
        this.score = score; 
    } 
 
    public void setName(String name) {
        StringBuilder builder = null;
        if(name != null) 
            builder = new StringBuilder(name); 
        else 
            builder = new StringBuilder(15); 
 
        builder.setLength(15); // � 15 �ַ�
        this.name = builder.toString();
    }
    
    public void setScore(int score) {
        this.score = score;
    }
 
    public String getName() { 
        return name; 
    } 
 
    public int getScore() { 
        return score; 
    } 
     // ÿ�����ݹ̶�д��34�ֽ� 
    public static int size() { 
        return 34; 
    } 
}
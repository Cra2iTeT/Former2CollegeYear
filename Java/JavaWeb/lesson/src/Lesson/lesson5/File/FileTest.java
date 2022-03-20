package com.lesson5.File;

import java.io.*;
import java.util.ArrayList;

public class FileTest {

    public static void main(String[] args) throws IOException {
    	
    	 File file = new File("c:\\windows");
         if(file.isFile()) { // �Ƿ�Ϊ�ļ�
             System.out.println(" �ļ�"); 
             System.out.print(
                   file.canRead() ? "�ɶ�" : "���ɶ�"); 
             System.out.print(
                   file.canWrite() ? "��д" : "����д"); 
             System.out.println(
                   file.length() + "�ֽ�"); 
         } 
         else { 
             // �г����е��ļ���Ŀ¼
             File[] files = file.listFiles(); 
             ArrayList<File> fileList = 
                                 new ArrayList<File>(); 
             for(int i = 0; i < files.length; i++) { 
                 // ���г�Ŀ¼ 
                 if(files[i].isDirectory()) { //�Ƿ�ΪĿ¼
                     // ȡ��·����
                     System.out.println("[" + 
                             files[i].getPath() + "]"); 
                 }
                 else {
                     // �ļ��ȴ���fileList���������г�??
                     fileList.add(files[i]); 
                 }
             } 

             // �г��ļ� 
             for(File f: fileList) {
                 System.out.println(f.toString());
             }
             System.out.println(); 
         } 
    	
    	
        //�Ե�ǰ·��������һ��File����
        file = new File(".");
        //ֱ�ӻ�ȡ�ļ��������һ��
        System.out.println(file.getName());
        //��ȡ���·���ĸ�·�����ܳ�������������null
        System.out.println(file.getParent());
        //��ȡ����·��
        System.out.println(file.getAbsoluteFile());
        //��ȡ��һ��·��
        System.out.println(file.getAbsoluteFile().getParent());
        //�ڵ�ǰ·���´���һ����ʱ�ļ�
        File tmpFile = File.createTempFile("aaa", ".txt", file);
        //ָ����JVM�˳�ʱɾ�����ļ�
        tmpFile.deleteOnExit();
        //��ϵͳ��ǰʱ����Ϊ���ļ������������ļ�
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile�����Ƿ���ڣ�" + newFile.exists());
        //��ָ��newFile����������һ���ļ�
        newFile.createNewFile();
        //��newFile����������һ��Ŀ¼����ΪnewFile�Ѿ����ڣ�
        //�������淽������false�����޷�������Ŀ¼
        newFile.mkdir();
        //ʹ��list�������г���ǰ·���µ������ļ���·��
        String[] fileList = file.list();
        System.out.println("======��ǰ·���������ļ���·������=====");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }

        //listRoots��̬�����г����еĴ��̸�·����
        File[] roots = File.listRoots();
        System.out.println("======ϵͳ���и�·������=====");
        for (File root : roots) {
            System.out.println(root);
        }
    }
}

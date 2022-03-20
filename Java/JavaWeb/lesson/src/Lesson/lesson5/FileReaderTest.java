package com.lesson5;

import java.io.*;

public class FileReaderTest
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = null;
		try
		{
			//�����ַ�������
			fr = new FileReader("FileReaderTest.java");
			//����һ������Ϊ32�ġ���Ͳ��
			char[] cbuf = new char[32];
			//���ڱ���ʵ�ʶ�ȡ���ַ���
			int hasRead = 0;
			//ʹ��ѭ�����ظ���ȡˮ������
			while ((hasRead = fr.read(cbuf)) > 0 )
			{
				//ȡ������Ͳ����ˮ�Σ��ֽڣ������ַ�����ת�����ַ������룡
				System.out.print(new String(cbuf , 0 , hasRead));
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{
			//ʹ��finally�����ر��ļ�������
			if (fr != null)
			{
				fr.close();
			}
		}
	}
}

package com.lesson5;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;


public class FileChannelTest
{
	public static void main(String[] args)
	{
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try
		{
			File f = new File("FileChannelTest.java");
			//����FileInputStream���Ը��ļ�����������FileChannel
			inChannel = new FileInputStream(f)
				.getChannel();
			//��FileChannel���ȫ������ӳ���ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,
				0 , f.length());
			//ʹ��GBK���ַ���������������
			Charset charset = Charset.forName("GBK");
			//���ļ����������FileBuffer�����Կ������
			outChannel = new FileOutputStream("a.txt")
				.getChannel();
			//ֱ�ӽ�buffer�������ȫ�����
			outChannel.write(buffer);
			//�ٴε���buffer��clear()��������ԭlimit��position��λ��
			buffer.clear();
			//����������(CharsetDecoder)����
			CharsetDecoder decoder = charset.newDecoder();
			//ʹ�ý�������ByteBufferת����CharBuffer
			CharBuffer charBuffer =  decoder.decode(buffer);
			//CharBuffer��toString�������Ի�ȡ��Ӧ���ַ���
			System.out.println(charBuffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();	
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

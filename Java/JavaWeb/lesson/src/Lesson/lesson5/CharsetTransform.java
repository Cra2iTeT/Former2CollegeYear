package com.lesson5;

import java.nio.charset.*;
import java.nio.*;

public class CharsetTransform
{
	public static void main(String[] args)
		throws Exception
	{
		//�����������Ķ�Ӧ��Charset
		Charset cn = Charset.forName("GBK");
		//��ȡcn�����Ӧ�ı������ͽ�����
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();
		//����һ��CharBuffer����
		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('��');
		cbuff.put('��');
		cbuff.put('��');
		cbuff.flip();
		//��CharBuffer�е��ַ�����ת�����ֽ�����
		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		//ѭ������ByteBuffer�е�ÿ���ֽ�
		for (int i = 0; i < bbuff.capacity() ; i++)
		{
			System.out.print(bbuff.get(i) + " ");
		}
		//��ByteBuffer�����ݽ�����ַ�����
		System.out.println("\n"
			+ cnDecoder.decode(bbuff));
	}
}

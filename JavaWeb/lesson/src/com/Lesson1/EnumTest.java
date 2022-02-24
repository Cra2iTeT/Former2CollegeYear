package com.Lesson1;
public class EnumTest {

	public static void main(String[] args) {
		Size s=Size.SMALL;
		Size t=Size.LARGE;
		//s��t����ͬһ������
		System.out.println(s==t);  //
		//��ԭʼ����������
		System.out.println(s.getClass().isPrimitive());
		//���ַ�����ת��
		Size u=Size.valueOf("SMALL");
		System.out.println(s==u);  //true
		//�г���������ֵ
		for(Size value:Size.values()){
			System.out.println(value);
		}
	}

}
 enum Size{SMALL,MEDIUM,LARGE};
package com.Lesson1;

public class Test {
public static void main(String[] args) {
	int intValue=100;
	long longValue=intValue;
	double doubleValue=1234567890;
	float floatValue=(float)doubleValue;
	System.out.println(floatValue);//1.23456794E9
	
	int X=100;
	int Y=200;
	System.out.println("X+Y="+X+Y);
	System.out.println(X+Y+"=X+Y");
	doNotRunme();
	
	String string="";
	double d1=1000.123;
	double d2=1000.123;
	if(Math.abs(d2-d1)<1e-10){
		
	}
	//System.out.println(string);

}

public static void doNotRunme()
{
	doNotRunme();
}
}

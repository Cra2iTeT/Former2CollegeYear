package com.lesson2;

public class CompareFloatNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//compare();
	    compare2();

	}

	private static void compare() {
		double i = 0.0001;
		double j = 0.00010000000000000001;
		System.out.println(i==j);  //�����true
	}
	private static void compare2() {
		double i = 0.0001;
		double j = 0.00010000000000000001;
		if(Math.abs(i-j)<1e-10){
			System.out.println("true");  
		}
		else
		{
			System.out.println("false");
		}
		
	}

}

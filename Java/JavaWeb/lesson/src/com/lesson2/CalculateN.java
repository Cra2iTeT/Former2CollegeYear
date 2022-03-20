package com.lesson2;

import java.math.BigInteger;
import java.util.Scanner;


public class CalculateN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("������N��");
		Scanner scanner=new Scanner(System.in);
		int number=scanner.nextInt();
		System.out.println(number+"!="+calculateN2(number));
		
	}
	
	public static long calculateN(int n) {
		if(n==1 || n==0){
			return 1;
		}
		
		return n*calculateN(n-1);
	}

	public static BigInteger calculateN2(int n) {
		if(n==1 || n==0){
			return BigInteger.valueOf(1);
		}
		return BigInteger.valueOf(n).multiply(calculateN2((n-1)));
	}
}

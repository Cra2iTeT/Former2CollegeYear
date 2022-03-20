package com.lesson2;


public class SquareInt {

	public static void main(String[] args) {
		int result;

		for (int x = 1; x <= 10; x++) {
			result = square(x);
			// Math库中也提供了求平方数的方法
			// result=(int)Math.pow(x,2);
			System.out.println("The square of " + x + " is " + result + "\n");
		}
	}

	// 自定义求平方数的静态方法
	public static int square(int y) {
		return y * y;
	}
}

package com.lesson2;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class VariableArgumentsTest{
	
	public static double max(double...values)
	{
		double largest=Double.MIN_VALUE;
		for (double v:values)
			if(v>largest) largest=v;
		return largest;
	}

	public static void main(String args[]) {
	
	     System.out.println("Max:"+max(1,11,300,2,3));
			
	}
}


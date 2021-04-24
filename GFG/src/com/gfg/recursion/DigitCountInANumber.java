package com.gfg.recursion;

public class DigitCountInANumber {
	
	public static int digitCount(int n) {
		if(n < 10)
			return 1;
		return 1 + digitCount(n/10);
	}
	
	public static void main(String[] args) {
		System.out.println(digitCount(1234567898));
	}
}

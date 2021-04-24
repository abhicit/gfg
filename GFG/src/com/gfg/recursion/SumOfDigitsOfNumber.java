package com.gfg.recursion;

public class SumOfDigitsOfNumber {
	
	public static int sum(int n) {
		if(n < 10)
			return n;
		return sum(n/10) + n%10;
	}
	
	public static void main(String[] args) {
		System.out.println(sum(5));
	}
}

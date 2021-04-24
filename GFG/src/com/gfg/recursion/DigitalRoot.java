package com.gfg.recursion;

public class DigitalRoot {
	
	public static int root(int n) {
		if(n < 10)
			return n;
		int sum = root(n/10) + n%10;
		return root(sum/10) + sum%10;
	}
	
	public static void main(String[] args) {
		System.out.println(root(892));
	}
}

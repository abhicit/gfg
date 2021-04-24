package com.gfg.maths;

public class GcdOfArray {
	
	public static int gcd(int a, int b) {
		if(a == 0)
			return b;
		return gcd(b%a, a);
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 7, 3, 9, 4 };
		int result = 0;
		for(int i = 0; i < arr.length; i++) {
			result = gcd(result, arr[i]);
		}
		System.out.println(result);
	}
}

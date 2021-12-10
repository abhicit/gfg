package com.gfg.maths;

public class LcmOfArray {
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	
	public static int lcm(int a, int b) {
		return (a/gcd(a,b))*b;
	}
	
	public static void main(String[] args) {
		int[] arr = { 2,3,6 };
		int result = 1;
		for(int i = 0; i < arr.length; i++) {
			result = lcm(result, arr[i]);
		}
		System.out.println("LCM of array : "+result);
		System.out.println("GCD is : "+gcd(15, 20));
		System.out.println("LCM is : "+lcm(15, 20));
	}
}

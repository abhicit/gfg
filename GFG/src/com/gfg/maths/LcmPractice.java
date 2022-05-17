package com.gfg.maths;

public class LcmPractice {
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		System.out.println(lcm(a, b));
		System.out.println(lcmEfficient(a, b));
	}

	private static int lcm(int a, int b) {
		int res = Math.max(a, b);
		while(true) {
			if(res%a == 0 && res%b == 0)
				return res;
			res++;
		}
	}
	
	private static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	
	private static int lcmEfficient(int a, int b) {
		return (a*b)/gcd(a, b);
	}
}

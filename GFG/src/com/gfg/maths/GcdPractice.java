package com.gfg.maths;

public class GcdPractice {
	public static void main(String[] args) {
		int a = 1050;
		int b = 255;
		
		System.out.println(gcd(a, b));
		System.out.println(gcdEfficient(a, b));
	}

	private static int gcd(int a, int b) {
		int res = Math.min(a, b);
		while(res > 0) {
			if(a%res == 0 && b%res == 0)
				return res;
			res--;
		}
		return -1;
	}
	
	private static int gcdEfficient(int a, int b) {
		if(b == 0)
			return a;
		return gcdEfficient(b, a%b);
	}
}

package com.gfg.maths;

/*
 * Basic Euclidean Method to find GCD
 * GCD(15, 20)
 * 20 - 15 = 5
 * 15 - 5 = 10
 * 10 - 5 = 5
 * 5 - 5 = 0
 * GCD is 5
 */

public class BasicEuclideanGCD {
	
	public static int gcd(int a, int b) {
		if((a-b) == 0)
			return a;
		return gcd(Math.min(a, b), Math.max(a, b) - Math.min(a, b));
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(60,20));
	}
}

package com.gfg.maths;

public class PrimePractice {
	public static void main(String[] args) {
		int n = 36;
		System.out.println(isPrime(n));
	}

	private static boolean isPrime(int n) {
		if(n == 0 || n == 1)
			return false;
		if(n == 2)
			return true;
		for(int i = 2; i*i < n; i++) {
			if(n%i == 0)
				return false;
		}
		return true;
	}
}

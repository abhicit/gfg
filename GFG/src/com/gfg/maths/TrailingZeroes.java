package com.gfg.maths;

public class TrailingZeroes {
	public static void main(String[] args) {
		int n = 251;
		System.out.println(countTrailingZeroes(n));
	}

	private static int countTrailingZeroes(int n) {
		int res = 0;
		for(int i = 5; i <= n; i=i*5) {
			res += n/i;
		}
		
		return res;
	}
}

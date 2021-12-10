package com.gfg.recursion;

public class MaxRopeCut {
	public static void main(String[] args) {
		System.out.println(maxRopeCut(5, 1, 2, 3));
	}

	private static int maxRopeCut(int n, int a, int b, int c) {
		if(n == 0)
			return 0;
		if(n < 0)
			return -1;
		int res = Math.max(Math.max(maxRopeCut(n-a, a, b, c), 
				maxRopeCut(n-b, a, b, c)), maxRopeCut(n-c, a, b, c));
		return (res == -1) ? -1 : res+1;
	}
}

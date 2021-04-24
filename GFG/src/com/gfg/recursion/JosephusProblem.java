package com.gfg.recursion;

public class JosephusProblem {
	
	public static int jos(int n, int k) {
		if(n == 1)
			return n;
		return (jos(n-1, k)+k-1)%n;
	}
	
	public static void main(String[] args) {
		System.out.println(jos(5, 3));
	}
}

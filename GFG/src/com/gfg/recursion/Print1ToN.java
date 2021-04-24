package com.gfg.recursion;

public class Print1ToN {
	
	public static void print1ToN(int n) {
		if(n == 1) {
			System.out.println(n);
			return;
		}
		print1ToN(n-1);
		System.out.print(n+" ");
	}
	
	public static void main(String[] args) {
		print1ToN(64);
	}
}

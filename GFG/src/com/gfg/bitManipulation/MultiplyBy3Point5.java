package com.gfg.bitManipulation;

public class MultiplyBy3Point5 {
	
	public static double multiplyBy3Point5(int n) {
		return (n << 1) + n + (n >> 1);
	}
	
	public static void main(String[] args) {
		System.out.println(multiplyBy3Point5(3));
	}
}

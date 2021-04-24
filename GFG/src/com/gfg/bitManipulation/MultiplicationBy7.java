package com.gfg.bitManipulation;

public class MultiplicationBy7 {
	
	public static int mulBy7(int n) {
		return (n << 3) - n;
	}
	
	public static void main(String[] args) {
		System.out.println(mulBy7(10));
	}
}

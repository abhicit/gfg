package com.gfg.bitManipulation;

/*
 *13 = 1101
 *14 = 1110 
 */

public class Add1ToANumber {
	
	public static int add1(int n) {
		return -(~n);
	}
	
	public static void main(String[] args) {
		System.out.println(add1(Integer.MAX_VALUE - 1));
	}
}


package com.gfg.bitManipulation;

public class RotateBits {
	
	public static int rotateBits(int n, int d) {
		return (n >> d) | (n << (32-d));
	}
	
	public static void main(String[] args) {
		System.out.println(rotateBits(16, 2));
	}
}

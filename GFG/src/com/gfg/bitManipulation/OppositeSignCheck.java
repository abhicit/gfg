package com.gfg.bitManipulation;

public class OppositeSignCheck {
	
	public static boolean isOpposite(int a, int b) {
		return ((a^b) < 0);
	}
	
	public static void main(String[] args) {
		System.out.println("Integers have opposite sign: "+isOpposite(5, 100));
	}
}

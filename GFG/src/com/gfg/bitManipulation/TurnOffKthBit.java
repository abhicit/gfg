package com.gfg.bitManipulation;

public class TurnOffKthBit {
	
	public static int offBit(int n, int k) {
		return n & ~(1 << (k-1));
	}
	
	public static void main(String[] args) {
		System.out.println(offBit(15,4));
	}
}

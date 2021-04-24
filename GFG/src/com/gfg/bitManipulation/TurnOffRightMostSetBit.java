package com.gfg.bitManipulation;

public class TurnOffRightMostSetBit {
	
	public static int turnOffRightMostSetBit(int n) {
		return n & (n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(turnOffRightMostSetBit(7));
	}
}

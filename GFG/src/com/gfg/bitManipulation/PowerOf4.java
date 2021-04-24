package com.gfg.bitManipulation;

public class PowerOf4 {
	
	public static boolean isPowerOf4(int n) {
		int count = 0;
		if((n & (n-1)) == 0) {
			while((n & 1) != 1) {
				count++;
				n >>= 1;
			}
		}else {
			return false;
		}
		return (count%2 == 0) ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf4(16));
	}
}

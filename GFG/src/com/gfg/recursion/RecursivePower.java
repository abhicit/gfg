package com.gfg.recursion;

public class RecursivePower {
	
	public static int recPower(int n, int p) {
		if(p == 0)
			return 1;
		return n*recPower(n, p-1);
	}
	
	public static void main(String[] args) {
		System.out.println(recPower(9, 9));
	}
}

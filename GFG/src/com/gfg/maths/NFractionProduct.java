package com.gfg.maths;

public class NFractionProduct {
	
	public static int gcd(int a, int b) {
		if(a == 0)
			return b;
		return gcd(b%a, a);
	}
	
	public static void product(int[] num, int[] den) {
		int new_num = 1;
		int new_den = 1;
		for(int i = 0; i < num.length; i++) {
			new_num *= num[i];
			new_den *= den[i];
		}
		int gcd = gcd(new_num, new_den);
		System.out.println("Product is "+new_num/gcd+"/"+new_den/gcd);
	}
	
	public static void main(String[] args) {
		int[] num = {1, 2, 5};
		int[] den = {4, 5, 6};
		product(num, den);
	}
}

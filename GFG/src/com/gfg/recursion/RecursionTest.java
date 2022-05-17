package com.gfg.recursion;

public class RecursionTest {
	public static void main(String[] args) {
		fun(3);
	}

	private static void fun(int i) {
		if(i == 0)
			return;
		fun(i-1);
		System.out.println(i);
		fun(i-1);
	}
}

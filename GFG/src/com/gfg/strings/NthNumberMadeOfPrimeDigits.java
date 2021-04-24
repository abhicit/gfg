package com.gfg.strings;

import java.util.HashSet;

public class NthNumberMadeOfPrimeDigits {
	
	public static void main(String[] args) {
		int N = 21;
		System.out.println(primeDigits(N));
	}

	public static int primeDigits(int n) {
		int res = 0;
		int i;
		int nos = 2;
		for(i = 0; i < n; ) {
			String str = String.valueOf(nos);
			if(isPrimeDigits(str)) {
				i++;
			}
			nos++;
		}
		return nos-1;
	}
	
	public static boolean isPrimeDigits(String str) {
		HashSet<Character> set = new HashSet<Character>();
		set.add('2');
		set.add('3');
		set.add('5');
		set.add('7');
		for(int i = 0; i < str.length(); i++) {
			if(!set.contains(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}

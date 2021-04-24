package com.gfg.strings;

public class LpsForKmp {
	
	public static void fillLPSNaive(String str, int[] lps) {
		for(int i = 0; i < str.length(); i++)
			lps[i] = longPropPreSuff(str, i+1);
	}

	public static int longPropPreSuff(String str, int n) {
		for(int len = n-1; len > 0; len--) {
			boolean flag = true;
			for(int i = 0; i < len; i++) {
				if(str.charAt(i) != str.charAt(n-len+i))
					flag = false;
			}
			
			if(flag)
				return len;
		}
		return 0;
	}
	
	public static void fillLPSEfficient(String str, int[] lps) {
		int n = str.length();
		int i = 1;
		int len = 0;
		lps[0] = 0;
		
		while(i < n) {
			if(str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len == 0) {
					lps[i] = 0;
					i++;
				}
				else {
					len = lps[len-1];
				}
					
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "ababacab";
		int[] lps = new int[str.length()];
		//fillLPSNaive(str, lps);
		fillLPSEfficient(str, lps);
		for(int i : lps)
			System.out.print(i+" ");
	}
	
}

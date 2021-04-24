package com.gfg.strings;

public class KMPImplementation {
	
	public static void fillLps(String pat, int[] lps) {
		int n = pat.length();
		lps[0] = 0;
		int i = 1;
		int len = 0;
		
		while(i < n) {
			if(pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}else {
				if(len == 0) {
					lps[i] = 0;
					i++;
				}else {
					len = lps[len-1];
				}
			}
		}
	}
	
	public static void kmpSearch(String txt, String pat) {
		int n = txt.length();
		int m = pat.length();
		int[] lps = new int[m];
		int i = 0;
		int j = 0;
		fillLps(pat, lps);
		while(i < n) {
			if(txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if(j == m) {
				System.out.println(i-j);
				j = lps[j-1];
			}else if(i < n && pat.charAt(j) != txt.charAt(i)) {
				if(j == 0)
					i++;
				else
					j = lps[j-1];
			}
		}
	}
	
	public static void main(String[] args) {
		String txt = "ababcababaad";
		String pat = "ababa";
		kmpSearch(txt, pat);
	}
	
}

package com.gfg.prefixsum;

import java.util.Arrays;

public class MaxAppearingElementInRange {
	static int[] aux = new int[100];
	public static void main(String[] args) {
		int[] L = {1, 2, 5, 15};
		int[] R = {5, 8, 7, 18};
		
		System.out.println(maxElement(L, R));
	}

	private static int maxElement(int[] l, int[] r) {
		int res = 0;
		int max = 0;
		Arrays.fill(aux, 0);
		for(int i = 0; i < l.length; i++) {
			aux[l[i]]++;
			aux[r[i]+1]--;
		}
		for(int i = 1; i < aux.length; i++) {
			aux[i] += aux[i-1];
		}
		
		for(int i = 0; i < aux.length; i++) {
			if(max < aux[i]) {
				max = aux[i];
				res = i;
			}
		}
		return res;
	}
}

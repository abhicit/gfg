package com.gfg.arrays;

public class MaximumAppearingElement {
	static int count = 1;
	
	public static int maxElement(int[] l, int[] r, int max, int n) {
		int[] arr = new int[max+2];
		for(int i = 0; i < n; i++) {
			arr[l[i]]++;
			arr[r[i]+1]--;
		}
		int maxm = arr[0];
		int res = 0;
		for(int i = 1; i < max; i++) {
			arr[i] += arr[i-1];
			if(maxm < arr[i]) {
				maxm = arr[i];
				res = i;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] l = {2, 1, 3};
		int[] r = {5, 3, 9};
		int max = 9;
		int n = 3;
		System.out.println(maxElement(l, r, max, n));
	}
}

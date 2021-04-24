package com.gfg.arrays;

public class RearrangeO1 {
	
	public static void rearrange(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			arr[i] += (arr[arr[i]]%n) * n;
		}
		for(int i = 0; i < n; i++) {
			arr[i] /= n;
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 0, 2, 1, 3};
		int n = 5;
		rearrange(arr, n);
	}
}

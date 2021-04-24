package com.gfg.searching;

import java.util.Arrays;

public class NByKOccurrences {
	
	static class eleCount{
		int element;
		int count;
	}
	
	public static void efficientOccurrences(int[] arr, int n, int k) {
		if(k < 2)
			return;
		eleCount[] temp = new eleCount[k-1];
		for(int i = 0; i < k-1; i++)
			temp[i] = new eleCount();
		for(int i = 0; i < k-1; i++)
			temp[i].count = 0;
		
		for(int i = 0; i < n; i++) {
			int j;
			for(j = 0; j < k-1; j++) {
				if(temp[j].element == arr[i]) {
					temp[j].count++;
					break;
				}
			}
			
			if(j == k-1) {
				int l;
				for(l = 0; l < k-1; l++) {
					if(temp[l].count == 0) {
						temp[l].element = arr[i];
						temp[l].count = 1;
						break;
					}
				}
				
				if(l == k-1)
					for(l = 0; l < k-1; l++)
						temp[l].count--;
			}
		}
		for(int i = 0; i < k-1; i++) {
			int ac = 0;
			for(int j = 0; j < n; j++)
				if(arr[j] == temp[i].element)
					ac++;
			if(ac > n/k)
				System.out.print("Number:" +  temp[i].element
		                + " Count:" +  ac +"\n");
		}
	}
	
	public static int occurrences(int[] arr, int n, int k) {//Wrong O(n^2)
		int res = 0;
		for(int i = 0; i < n; i++) {
			int count = 1;
			for(int j = i+1; j < n; j++) {
				if(arr[i] == arr[j]) {
					count++;
					if(count > n/k)
						res++;
				}
			}
		}
		return res;
	}
	
	public static int sortOccurrences(int[] arr, int n, int k) {//Wrong O(nlogn)
		int res = 0;
		int count = 1;
		Arrays.sort(arr);
		for(int i = 1; i < n; i++) {
			if(arr[i] == arr[i-1]) {
				count++;
				if(count > n/k)
					res++;
			}else {
				count = 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,1,2,2,1,2,3,3};
		int n = 8;
		int k = 4;
		/*
		 * System.out.println(occurrences(arr, n, k));
		 * System.out.println(sortOccurrences(arr, n, k));
		 */
		efficientOccurrences(arr, n, k);
	}
	
}

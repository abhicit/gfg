package com.gfg.searching;

import java.util.ArrayList;

/*
 * [1,2,3,7,5,6,8], sum = 11
 */

public class SubArrayWithGivenSum {
	
	public static ArrayList<Integer> subArray(int[] arr, int n, int s){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = arr[0], start = 0, i;
		for(i = 1; i < n; i++) {
			
			if(i < n) {
				sum += arr[i];
			}
			
			while(sum > s && start < i) {
				sum -= arr[start];
				start++;
			}
			
			if(sum == s) {
				list.add(start+1);
				list.add(i+1);
				return list;
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int arr[] = { 1, 8 }; 
        int n = arr.length; 
        int sum = 8;
        ArrayList<Integer> list = subArray(arr, n, sum);
        for(int i : list) {
        	System.out.print(i+" ");
        }
	}
}

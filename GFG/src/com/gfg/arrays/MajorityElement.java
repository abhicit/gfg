package com.gfg.arrays;

public class MajorityElement {
	
	public static int majorityElement(int[] arr) { //O(n^2)
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count = 0;
			for(int j = i; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			if(count > arr.length/2) {
				return i;
			}
		}
		return -1;
	}
	
	public static int majElement(int[] arr) {//O(n) - Moore's voting algorithm
		int res = 0;
		int count = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[res] == arr[i])
				count++;
			else
				count--;
			if(count == 0) {
				count = 1;
				res = i;
			}
		}
		count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[res] == arr[i])
				count++;
		}
		if(count <= arr.length/2)
			res = -1;
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 8, 8, 4, 8, 8, 8};
		System.out.println(majorityElement(arr));
		System.out.println(majElement(arr));
	}
}

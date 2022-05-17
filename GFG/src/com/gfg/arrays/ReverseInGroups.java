package com.gfg.arrays;

import java.util.ArrayList;

public class ReverseInGroups {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		
		reverseInGroups(arr, arr.size(), 3);
		
		for(Integer i : arr)
			System.out.print(i+" ");
	}
	static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        reverse(arr, 0, k);
        reverse(arr, k, n);
    }
    
    static void reverse(ArrayList<Integer> arr, int s, int d){
        int start = s;
        int end = d-1;
        for(int i = s; i < d; i++){
        	if(start<end) {
	            int temp = arr.get(start);
	            arr.set(start, arr.get(end));
	            arr.set(end, temp);
	            start++;
	        	end--;
        	}
        }
    }
}

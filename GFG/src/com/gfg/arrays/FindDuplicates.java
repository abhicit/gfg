package com.gfg.arrays;

import java.util.ArrayList;

public class FindDuplicates {
	public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	int id = arr[i] % n;
            arr[id] += n;
        }
        for(int i = 0; i < n; i++) {
        	if(arr[i]/n > 1)
        		res.add(i);
        }
        if(res.size() == 0)
            res.add(-1);
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {2,3,1,2,3};
		System.out.println(duplicates(arr, arr.length));
	}
}

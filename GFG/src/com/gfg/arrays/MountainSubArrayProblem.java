package com.gfg.arrays;

import java.util.ArrayList;

class Pair{
	int l, r;
	Pair(int l, int r){
		this.l = l;
		this.r = r;
	}
}

public class MountainSubArrayProblem {
	
	public static void main(String[] args) {
		int arr[] = {2, 3, 2, 4, 4, 6, 3, 2};
        int N = arr.length;
        ArrayList<Pair> queries = new ArrayList<>();
        queries.add(new Pair(0,2));
        queries.add(new Pair(1,3));
        
        ArrayList<Boolean> result = processQueries(arr, N, queries, queries.size());
        System.out.println(result);
	}
	
	public static void processArray(int[] left, int[] right, int[] arr, int n) {
		
		left[0] = 0;
		int lastIncr = 0;
		for(int i = 1; i < n; i++) {
			if(arr[i] > arr[i-1])
				lastIncr = i;
			left[i] = lastIncr;
		}
		
		right[n-1] = n-1;
		int firstDecr = n-1;
		for(int i = n-2; i >= 0; i--) {
			if(arr[i] > arr[i+1])
				firstDecr = i;
			right[i] = firstDecr;
		}
		
	}
	
	public static Boolean isMountain(int[] arr, int[] left, int[] right, int l, int r) {
		return right[l] >= left[r];
	}
	
	public static ArrayList<Boolean> processQueries(int[] a, int n, ArrayList<Pair> queries, int q){
		ArrayList<Boolean> res = new ArrayList<>();
		int[] left = new int[n];
		int[] right = new int[n];
		
		processArray(left, right, a, n);
		
		for(int i = 0; i < q; i++) {
			res.add(isMountain(a, left, right, queries.get(i).l, queries.get(i).r));
		}
		return res;
	}
	
}

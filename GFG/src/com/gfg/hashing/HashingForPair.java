package com.gfg.hashing;

import java.util.HashSet;

public class HashingForPair {
	public static int sumExists(int arr[], int N, int sum)
    {
       HashSet<Integer> set = new HashSet<Integer>();
       for(int i = 0; i < N; i++){
           if(set.contains(sum - arr[i])){
                return 1;
           }
            else{
                set.add(arr[i]);
            }
       }
       return 0;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int n = arr.length;
		int sum = 14;
		System.out.println(sumExists(arr, n, sum));
	}
}

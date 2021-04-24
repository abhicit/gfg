package com.gfg.hashing;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArray {
	
	public static int findSubarray(int[] arr ,int n) 
	{
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int[] presum = new int[n];
	    presum[0] = arr[0];
	    for(int i = 1; i < n; i++)
	        presum[i] = arr[i] + presum[i-1];
	    int count = 0;    
	    for(int i = 0; i < n; i++){
	        if(presum[i] == 0)
	            count++;
	        if(map.containsKey(presum[i])){
	            count+= map.get(presum[i]);
	            map.put(presum[i], map.getOrDefault(presum[i], 0)+1);
	        }else{
	            map.put(presum[i], 1);
	        }
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {6,-1,-3,4,-2,2,4,6,-12,-7};
		int n = arr.length;
		System.out.println(findSubarray(arr, n));
	}
}

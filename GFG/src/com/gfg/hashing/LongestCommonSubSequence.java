package com.gfg.hashing;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class LongestCommonSubSequence {
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   int res = 1;
	   TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
	   for(int i : arr)
	        map.put(i, map.getOrDefault(i, 0)+1);
	   ArrayList<Integer> temp = new ArrayList<Integer>();  
	   for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	       temp.add(entry.getKey());
	   }
	   int count = 1;
	   for(int i = 1; i < temp.size(); i++){
	       if(temp.get(i) == temp.get(i-1)+1)
	            count++;
	       else {
	            res = Math.max(res, count);
	            count = 1;
	       }
	   }
	   return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};//{86, 177, 115, 193, 135, 186, 92, 49, 21, 162, 27, 90, 59, 163, 126, 140, 26, 172, 136, 11, 168, 167, 29, 182, 130, 62, 123, 67, 129, 2, 22, 58, 69, 56, 42, 173, 119, 184, 137, 198, 124, 170, 13, 91, 180, 156, 73, 196, 81, 105, 125, 84, 127, 46, 113, 57, 95, 145, 14, 34, 164, 43, 150, 87, 8, 76, 178, 188, 3, 51, 154, 199, 132, 60, 139, 12, 94, 195, 1, 97, 102, 117, 52, 101};
		int n = arr.length;
		System.out.println(findLongestConseqSubseq(arr, n));
	}
}

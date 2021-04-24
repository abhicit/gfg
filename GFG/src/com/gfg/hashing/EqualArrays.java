package com.gfg.hashing;

import java.util.HashSet;

public class EqualArrays {
	public static boolean check(long arr[],long brr[],int n)
	{
		HashSet<Long> hs1 = new HashSet<Long>();
	    for(long i : arr)
	        hs1.add(i);
	    for(int i = 0; i < n; i++){
	        if(hs1.contains(brr[i])){
	            continue;
	        }else{
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	public static void main(String[] args) {
		long[] arr = {445, 627, 523,466, 709, 417, 283, 259, 925, 638, 63, 625, 601, 37, 453, 900, 380, 551, 469, 72, 974, 132, 882, 931, 934, 895, 661, 164, 200, 982, 900, 997, 960, 774, 814, 669, 191};
		long[] brr = {709, 900, 469, 37, 283, 417, 259, 132, 974, 814, 551, 466, 982, 627, 63, 669, 934, 625, 661, 960, 601, 380, 523, 200, 900, 191, 895, 774, 72, 997, 638, 931, 445, 925, 453, 164, 882};
		int n = arr.length;
		System.out.println(check(arr, brr, n));
		System.out.println("");
	}
}

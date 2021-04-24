package com.gfg.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {
	
	static int isSum(int arr[], int n, int sum)
    {
        Set<Integer> s = new HashSet<Integer>();
        int pre_sum = 0;
        int res = 0;
        for(int i = 0; i < n; i++)
        {
            if(pre_sum==sum)
                res++;
            pre_sum += arr[i];
            if(s.contains(pre_sum-sum) == true)
                res++;
              
            s.add(pre_sum);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int arr[] = {10,2,-2,-20,10};
        int sum=-10;
        int n = arr.length;
        
        System.out.println(isSum(arr, n, sum));
	}
	
}

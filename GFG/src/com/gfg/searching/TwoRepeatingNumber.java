package com.gfg.searching;

import java.util.Arrays;

public class TwoRepeatingNumber {
	public static int[] twoRepeated(int arr[], int N)
    {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        int max = Integer.MIN_VALUE;
        for(int i : arr)
            max = Math.max(max, i);
            
        int div = max+1;
        for(int i = 0; i < N; i++){
            arr[arr[i]%N] += div;
        }
        int j = 0;
        for(int i = 0; i < N; i++){
            if((arr[i]/div) >= 2)
                res[j++] = i;
            
            if(res[1] != -1)
                break;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 1};
		int N = 4;
		
		int[] res = twoRepeated(arr, N);
		for(int i : res)
			System.out.println(i);
	}
}

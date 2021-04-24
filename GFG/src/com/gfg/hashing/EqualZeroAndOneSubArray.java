package com.gfg.hashing;

import java.util.HashMap;
import java.util.Map;

public class EqualZeroAndOneSubArray {
	static int countSubarrWithEqualZeroAndOne(int arr[], int N)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        int sum = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] == 0)
                arr[i] = -1;
            sum += arr[i];
            if(sum == 0)
                count++;
            if(map.containsKey(sum))
                count += map.get(sum);
            if(!map.containsKey(sum))
                map.put(sum, 1);
            else    
                map.put(sum, map.get(sum)+1);
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,0,0,1,0,1,1};
		int N = arr.length;
		System.out.println(countSubarrWithEqualZeroAndOne(arr, N));
	}
}

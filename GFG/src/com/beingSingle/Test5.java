package com.beingSingle;

import java.util.HashMap;
import java.util.Map;

public class Test5 {
	public static int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                res -= nums[i];
            }else{
                int count = 0;
                map.put(nums[i], ++count);
                res += nums[i];
            }
        }
        
        return (res < 0) ? 0 : res;
    }
	
	public static void main(String[] args) {
		int[] arr = {10,6,9,6,9,6,8,7};
		System.out.println(sumOfUnique(arr));
	}
}

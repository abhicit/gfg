package com.gfg.arrays;

import java.util.HashMap;

public class MaxProduct {
	public static int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
        	if(firstMax < nums[i]) {
        		secondMax = firstMax;
        		firstMax = nums[i];
        	}else if(secondMax < nums[i]){
        		secondMax = nums[i];
        	}
        }
        
        return (firstMax-1)*(secondMax-1);
    }
	
	public static void main(String[] args) {
		int[] nums = {10,2,5,2};
		System.out.println(maxProduct(nums));
	}
}

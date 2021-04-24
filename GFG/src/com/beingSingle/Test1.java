package com.beingSingle;

import java.util.Arrays;

public class Test1 {
	public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[index.length];
        Arrays.fill(target, -1);
        int ptr = 0;
        for(int i = 0; i < index.length; i++){
            if(target[index[i]] == -1){
                target[index[i]] = nums[i];
            }else{
                int j = ptr;
                while(j >= target[index[i]] && j < target.length && j >= 0){
                    target[j] = target[j-1];
                    j--;
                }
                target[index[i]] = nums[i];
            }
            ptr++;
        }
        return target;
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4};
		int[] index = {0,1,2,2,1};
		int[] res = createTargetArray(nums, index);
		for(int i : res)
			System.out.print(i+" ");
	}
}

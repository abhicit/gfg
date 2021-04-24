package com.beingSingle;

public class Test {
	public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i == j)
                    continue;
                if(nums[i] > nums[j]){
                    res[i]++;
                }
            }
        }
        return res;
    }
	
	public static int[] efficient(int[] nums) {
		int[] count = new int[101];
		for(int i = 0; i < nums.length; i++) {
			count[nums[i]] += 1;
		}
		
		for(int i = 0; i < nums.length; i++) {
			int counter = nums[i]-1;
			int res = 0;
			while(counter >= 0) {
				if(count[counter] != 0) {
					res += count[counter];
				}
				counter--;
			}
			nums[i] = res;
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {8,1,2,2,3};
		int[] res = efficient(nums);
		for(int num : res) {
			System.out.print(num+" ");
		}
	}
}

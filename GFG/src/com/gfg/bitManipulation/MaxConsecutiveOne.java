package com.gfg.bitManipulation;

public class MaxConsecutiveOne {
	public static int maxConsecutiveOnes(int x) {
        int count = 0;
        while(x != 0){
            if((x&1) == 1){
                count++;
            }else {
            	if(count >= 1)
            		count--;
            }
            x >>= 1;
        }
        return count;
    }
	public static void main(String[] args) {
		System.out.println(maxConsecutiveOnes(222));
	}
}

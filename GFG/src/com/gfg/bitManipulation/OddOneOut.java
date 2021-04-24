package com.gfg.bitManipulation;
/*
 *all the no appear thrice accept one 
 */
public class OddOneOut {
	
	static final int INT_SIZE = 32;
	public static int approach1(int[] arr, int n) {
		int ones = 0, twos = 0; 
        int common_bit_mask; 
  
        for (int i = 0; i < n; i++) { 
            
            twos = twos | (ones & arr[i]); 
            
            ones = ones ^ arr[i]; 
  
            common_bit_mask = ~(ones & twos); 
  
            ones &= common_bit_mask; 
  
            twos &= common_bit_mask; 
        } 
        return ones; 
	}
	
	static int getSingle(int arr[], int n) 
	{ 
		int result = 0; 
		int x, sum; 

		// Iterate through every bit 
		for (int i = 0; i < INT_SIZE; i++) { 
			// Find sum of set bits at ith position in all 
			// array elements 
			sum = 0; 
			x = (1 << i); 
			for (int j = 0; j < n; j++) { 
				if ((arr[j] & x) != 0) 
					sum++; 
			} 
			// The bits with sum not multiple of 3, are the 
			// bits of element with single occurrence. 
			if ((sum % 3) != 0) 
				result |= x; 
		} 
		return result; 
	} 
	
	public static void main(String[] args) {
		int arr[] = { 12, 12, 3, 12, 1, 3, 1, 3, 1, 7}; 
        int n = arr.length; 
        System.out.println("The element with single occurrence is " + approach1(arr, n)); 
        System.out.println("The element with single occurrence is " + getSingle(arr, n));
	}
	
}

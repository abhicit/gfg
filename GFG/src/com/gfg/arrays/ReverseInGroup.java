package com.gfg.arrays;

import java.util.ArrayList;

public class ReverseInGroup {
	public static void main(String[] args) {
		ArrayList<Integer> mv = new ArrayList<Integer>();
		mv.add(1);
		mv.add(2);
		mv.add(3);
		mv.add(4);
		mv.add(5);
		for(int i : reverseInGroups(mv, mv.size(), 3))
			System.out.print(i+" ");
	}
	
	public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        // add your code here
		for (int i = 0; i < n; i += k) { 
            int left = i; 
            // to handle case when k is not multiple of n 
            int right = Math.min(i + k - 1, n - 1); 
            int temp; 
            // reverse the sub-array [left, right] 
            while (left < right) { 
                temp = mv.get(left); 
                mv.set(left, mv.get(right)); 
                mv.set(right, temp); 
                left+=1; 
                right-=1; 
            } 
        }
        
        return mv;
    }
}

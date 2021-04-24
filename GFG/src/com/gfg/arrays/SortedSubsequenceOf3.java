package com.gfg.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedSubsequenceOf3 {
	static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int first = -1, second = -1, third = -1;
        for(int i = 0; i < n; i++){
            if(third < arr.get(i)){
                first = second;
                second = third;
                third = arr.get(i);
            }else if(second < arr.get(i) && arr.get(i) < third){
                first = second;
                second = arr.get(i);
            }else if(first < arr.get(i) && arr.get(i) < second){
                first = arr.get(i);
            }
        }
        if(first == -1 || second == -1 || third == -1)
            return res;
        res.add(third);
        res.add(second);
        res.add(first);
        return res;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> arr  = new ArrayList<>(Arrays.asList(33, 24, 92, 74, 100, 72, 72, 97, 54, 77, 95, 52, 11, 95, 29));
		System.out.println(find3Numbers(arr, arr.size()));
	}
}

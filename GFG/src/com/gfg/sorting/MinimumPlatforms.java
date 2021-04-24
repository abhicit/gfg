package com.gfg.sorting;

import java.util.HashMap;
import java.util.Map;

public class MinimumPlatforms {
	static int findPlatform(int arr[], int dep[], int n)
    {
        int platforms = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(platforms, dep[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < dep[i-1]){
                int counter = platforms;
                while(counter >= 1){
                    if(map.get(counter) < arr[i]){
                        map.put(counter, dep[i]);
                        break;
                    }
                    counter--;
                    if(counter == 0)
                    	map.put(++platforms, dep[i]);
                }
                
            }else{
                map.put(platforms, dep[i]);
            }
        }
        return map.size();
        
    }
	
	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		int n = arr.length;
		System.out.println(findPlatform(arr, dep, n));
	}
}

package com.gfg.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.List;
class MyComparator implements Comparator<Map.Entry<Integer, Integer>>{

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		if(o1.getValue() > o2.getValue())
			return -1;
		else if(o1.getValue() == o2.getValue()) {
			if(o1.getKey() > o2.getKey())
				return 1;
			else
				return -1;
		}else if(o1.getValue() < o2.getValue())
			return  1;
		return Integer.MIN_VALUE;
	}
	
}

public class SortByElementsFrequency {
	
	public static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i : arr)
        	hm.put(i, hm.getOrDefault(i, 0)+1);
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(hm.entrySet());
        Collections.sort(list, new MyComparator());
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < hm.size(); i++) {
        	int count = list.get(i).getValue();
        	while(count > 0) {
        		res.add(list.get(i).getKey());
        		count--;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {5,5,4,6,4};
		int n = arr.length;
		ArrayList<Integer> res = sortByFreq(arr, n);
		for(int i : res)
			System.out.print(i+" ");
	}
	
}

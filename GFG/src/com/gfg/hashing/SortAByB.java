package com.gfg.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortAByB {
	
	public static void sort(int[] A1, int N, int[] A2, int M) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i : A1)
			hm.put(i, hm.getOrDefault(i, 0)+1);
		int counter = 0;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			if(hm.containsKey(A2[i])) {
				while(hm.get(A2[i]) > 0) {
					A1[counter] = A2[i];
					counter++;
					hm.put(A2[i], hm.get(A2[i])-1);
				}
				if(hm.get(A2[i]) == 0)
					hm.remove(A2[i]);
			}
		}
		
		for(Map.Entry<Integer, Integer> e : hm.entrySet()) {
			int count = e.getValue();
			while(count > 0) {
				temp.add(e.getKey());
				count--;
			}
		}
		Collections.sort(temp);
		
		for(int i = 0; i < temp.size(); i++) {
			A1[counter] = temp.get(i);
			counter++;
		}
	}
	
	public static void main(String[] args) {
		int[] a1 = {9, 8, 5, 0, 3, 8, 9, 0};//{2,1,2,5,7,1,9,3,6,8,8};
		int[] a2 = {0, 9};//{2,1,8,3};
		int n = a1.length;
		int m = a2.length;
		sort(a1, n, a2, m);
		for(int i : a1)
			System.out.print(i+" ");
	}
	
}

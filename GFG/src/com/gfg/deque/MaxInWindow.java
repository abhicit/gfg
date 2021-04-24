package com.gfg.deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaxInWindow {
	static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        Deque<Integer> dq = new ArrayDeque<>(k);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.removeLast();
            dq.addLast(i);
        }
        
        for(int i = k; i < n; i++){
        	res.add(arr[dq.peekFirst()]);
            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.removeFirst();
            
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.removeLast();
            
            dq.addLast(i);
        }
        res.add(arr[dq.peekFirst()]);
        return res;
    }
	
	public static void main(String[] args) {
		int n = 10, k = 4;
		int arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		System.out.println(max_of_subarrays(arr, n, k));
	}
}

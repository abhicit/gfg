package com.gfg.greedy;

import java.util.Arrays;

class Item implements Comparable<Item>{
	int wt;
	int val;
	
	Item(int wt, int val){
		this.wt = wt;
		this.val = val;
	}

	@Override
	public int compareTo(Item i) {
		return i.val*this.wt - i.wt*this.val;
	}

}

public class FractionalKnapsack {
	public static void main(String[] args) {
		Item[] arr = {new Item(10, 60), new Item(40, 40), 
				new Item(20, 100), new Item(30, 120)};
		int W = 50;
		
		System.out.println(fractionalKnapsack(arr, W));
	}

	private static double fractionalKnapsack(Item[] arr, int W) {
		Arrays.sort(arr);
		double res = 0.0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].wt <= W) {
				res += arr[i].val;
				W -= arr[i].wt;
			}else {
				res += arr[i].val * (double)W/(double)arr[i].wt;
				break;
			}
		}
		return res;
	}
}

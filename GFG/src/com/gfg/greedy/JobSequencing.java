package com.gfg.greedy;

import java.util.Arrays;

class Job implements Comparable<Job>{
	int deadline;
	int profit;
	
	Job(int deadline, int profit){
		this.deadline = deadline;
		this.profit = profit;
	}

	@Override
	public int compareTo(Job i) {
		return i.profit - this.profit;
	}
}

public class JobSequencing {
	public static void main(String[] args) {
		Job[] arr = {new Job(4, 50), new Job(1, 5), new Job(1, 20),
				new Job(5, 10), new Job(5, 80)};
		Arrays.sort(arr);
		System.out.println(getProfit(arr));
	}

	private static int getProfit(Job[] arr) {
		int res = 0;
		int maxIndex = 0;
		for(int i = 0; i < arr.length; i++)
			maxIndex = Math.max(maxIndex, arr[i].deadline);
		int[] time = new int[maxIndex+1];
		Arrays.fill(time, -1);
		time[arr[0].deadline] = arr[0].profit;
		for(int i = 1; i < arr.length; i++) {
			if(time[arr[i].deadline] == -1)
				time[arr[i].deadline] = arr[i].profit;
			else {
				int j = arr[i].deadline-1;
				while(j >= i) {
					if(time[j] == -1) {
						time[j] = arr[i].profit;
						break;
					}
					j--;
				}
			}
		}
		for(int i : time)
			if(i != -1)
				res += i;
		return res;
	}
}

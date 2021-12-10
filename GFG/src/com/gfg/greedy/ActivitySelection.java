package com.gfg.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Activity{
	int startTime;
	int endTime;
	
	Activity(int startTime, int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

class MyCmp implements Comparator<Activity>{

	@Override
	public int compare(Activity o1, Activity o2) {
		return o1.endTime - o2.endTime;
	}
	
}

public class ActivitySelection {
	public static void main(String[] args) {
		Activity[] ac = {new Activity(1,3), new Activity(2, 5),
				new Activity(6, 8), new Activity(8, 10)};
		System.out.println(getCount(ac));
	}

	private static int getCount(Activity[] ac) {
		int res = 1;
		Arrays.sort(ac, new MyCmp());
		int prev = 0;
		for(int curr = 1; curr < ac.length; curr++) {
			if(ac[curr].startTime >= ac[prev].endTime) {
				res++;
				prev = curr;
			}
		}
		return res;
	}
}

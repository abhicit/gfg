package com.gfg.searching;

public class WaterBetweenBuildings {
	
	public static int maxWater(int[] arr) { //Wrong
		if(arr.length == 2)
			return 0;
		int i = 1;
		int res = 0;
		int lastBuilding = arr.length-1;
		while(lastBuilding - i > 1) {
			int diff = lastBuilding - i;
			int prod = diff*Math.min(arr[i-1], arr[lastBuilding]);
			res = Math.max(res, prod);
			i++;
		}
		return res;
	}
	
	public static int maxTrappedWater(int[] arr) {
		int firstBuilding = 0;
		int lastBuilding = arr.length-1;
		int res = 0;
		while(lastBuilding > firstBuilding) {
			int count = 0;
			if(arr[lastBuilding] > arr[firstBuilding]) {
				count = arr[firstBuilding]*(lastBuilding-firstBuilding-1);
				firstBuilding++;
			}
			else if(arr[lastBuilding] < arr[firstBuilding]) {
				count = arr[lastBuilding]*(lastBuilding-firstBuilding-1);
				lastBuilding--;
			}else {
				count = arr[firstBuilding]*(lastBuilding-firstBuilding-1);
				firstBuilding++;
				lastBuilding--;
			}
			res = Math.max(res, count);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {16, 11, 16, 62, 2, 97, 61, 1, 66, 32, 58, 48, 17, 5, 93, 3, 83, 91, 84, 14, 5, 52, 58, 26, 37, 36, 81, 55, 55, 40, 65, 24, 97, 98, 75, 88, 97, 29, 45, 36, 77, 40, 26, 13, 84, 90, 89, 91, 43, 41, 51, 66, 86, 63, 96, 92, 8, 60, 77, 99, 60, 90, 59, 48, 30, 49};
		System.out.println(maxTrappedWater(arr));
	}
	
}

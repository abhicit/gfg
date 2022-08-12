package com.beingSingle;

public class Test6 {
	public static void main(String[] args) {
		String str = "promatics is most promising IT company in punjab";
		reverseString(str);
	}

	private static void reverseString(String str) {
		String[] arr = str.split(" ");
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]+" ");
		}
	}
}

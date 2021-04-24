package com.gfg.recursion;

public class PrintPermutation {
	
	public String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
	
	public void permute(String str, int cnt) {
		if(cnt == str.length()-1) {
			System.out.print(str+" ");
			return;
		}else {
			for(int j = cnt; j < str.length(); j++) {
				str = swap(str, cnt, j);
				permute(str, cnt+1);
				str = swap(str, cnt, j);
			}
		}
	}
	
	public static void main(String[] args) {
		new PrintPermutation().permute("ABC", 0);
	}
}

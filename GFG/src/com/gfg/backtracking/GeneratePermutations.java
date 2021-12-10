package com.gfg.backtracking;

public class GeneratePermutations {
	public static void main(String[] args) {
		permute("ABCD", "");
	}

	private static void permute(String str, String asf) {
		
		if(str.length() == 0) {
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(isSafe(str, asf)) {
				char ch = str.charAt(i);
				String left = str.substring(0, i);
				String right = str.substring(i+1);
				permute(left+right, asf+ch);
			}
		}
		
	}
	
	public static boolean isSafe(String str, String asf) {
		if (asf.equalsIgnoreCase("AB") || (asf.length() > 0 
				&& asf.charAt(asf.length() - 1) == 'A') 
				&& (str.length() > 0 && str.charAt(str.length()-1) == 'B' ))
			return false;
		return true;
	}
}

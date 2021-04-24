package com.gfg.strings;

public class BruteForcePatternSearchIndex {
	
	public static int strstr(String str, String target) {
		if(target.length() == 0)
			return -1;
		
		for(int i = 0; i < str.length(); i++) {
			if(i+target.length() > str.length())
				return -1;
			for(int j = 0; j < target.length(); j++) {
				if(str.charAt(i+j) == target.charAt(j)) {
					if(j == target.length()-1)
						return i;
				}else
					break;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str = "GeeksForGeeks";
		String target = "For";
		System.out.println(strstr(str, target));
	}
	
}

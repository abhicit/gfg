package com.gfg.strings;

public class DistinctPatternSearch {
	static boolean search(String pat, String txt)
    {
        for(int i = 0; i <= txt.length()-pat.length(); ) {
        	int j;
        	for(j = 0; j < pat.length(); j++) {
        		if(txt.charAt(i+j) != pat.charAt(j)) {
					break;
        		}
        	}
			if(j == pat.length())
				return true;
			if(j == 0)
				i++;
			else 
				i += j;
        	
        }
        return false;
    }
	
	public static void main(String[] args) {
		String txt = "ABCABCD";
		String pat = "ABCD";
		System.out.println(search(pat, txt));
	}
}

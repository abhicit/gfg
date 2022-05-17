package com.gfg.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	private static Set<String> dict = new HashSet<String>();
	
	public static int wordBreak(String A, ArrayList<String> B )
    {
        return ((util(A)) ? 1 : 0);
    }
	
	public static int wordBreakTab(String str) {
		boolean[] dp = new boolean[str.length()+1];
		dp[0] = true;
		for(int i = 0; i <= str.length(); i++) {
			for(int j = 0; j < i; j++) {
				if(dp[j] && dict.contains(str.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return (dp[str.length()] ? 1 : 0);
	}
    
    public static boolean util(String str){
    	int size = str.length();
    	
    	if(size == 0)
    		return true;
    	
    	for(int i = 1; i <= size; i++) {
    		if(dict.contains(str.substring(0, i)) && util(str.substring(i, size)))
    			return true;
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
		ArrayList<String> li = new ArrayList<>();
		li.add("i");
		li.add("like");
		li.add("sam");
		li.add("sung");
		li.add("samsung");
		li.add("mobile");
		li.add("man");
		li.add("ice");
		li.add("mango");
		li.add("go");
		li.add("cream");
		li.add("icecream");
		
		for(String s : li)
			dict.add(s);
		
		System.out.println(wordBreak("ilikesamsung", li));
		System.out.println(wordBreakTab("ilikesamsung"));
	}
}

package com.gfg.stack;

import java.util.ArrayDeque;

public class ParenthesisChecker {
	static boolean ispar(String x)
    {
        ArrayDeque<Character> ad = new ArrayDeque<>();
        for(int i = 0; i < x.length(); i++) {
        	if(x.charAt(i) == '(' || x.charAt(i) == '{' || x.charAt(i) == '[') {
        		ad.push(x.charAt(i));
        	}else {
        		if(ad.isEmpty())
        			return false;
	        	if(!isMatching(ad.peek(), x.charAt(i)))
	        		return false;
	        	else
	        		ad.pop();
        	}
        }
        
        return ad.isEmpty();
    }
	
	static boolean isMatching(char str, char peek) {
		return ((str == '(' && peek == ')') || (str == '{' && peek == '}') || (str == '[' && peek == ']'));
	}
	
	public static void main(String[] args) {
		System.out.println(ispar("((())))"));
	}
}

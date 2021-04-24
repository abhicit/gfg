package com.gfg.strings;

import java.util.HashMap;
import java.util.Map;

public class Keypad {
	
	public static String printNumber(String s, int n) 
	{
	    String[] keypad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i = 2; i < keypad.length; i++){
	        String key = keypad[i];
	        int counter = 0;
	        while(counter < key.length()){
	            map.put(key.charAt(counter), i);
	            counter++;
	        }
	    }
	    
	    StringBuilder res = new StringBuilder("");
	    for(int i = 0; i < n; i++){
	        res.append(map.get(s.charAt(i)));
	    }
	    
	    return res.toString();
	}
	
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		int n = s.length();
		System.out.println(printNumber(s, n));
	}
	
}

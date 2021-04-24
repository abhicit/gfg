package com.gfg.stack;

import java.util.ArrayDeque;

public class ConsecutiveDuplicates2 {
	public static String removePair(String str){
        ArrayDeque<String> ad = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder("");
        ad.push(String.valueOf(str.charAt(0)));
        for(int i = 1; i < str.length(); i++) {
        	if(!ad.isEmpty() && ad.peek().equals(String.valueOf(str.charAt(i))))
        		ad.pop();
        	else
        		ad.push(String.valueOf(str.charAt(i)));
        }
        
        int size = ad.size();
        for(int i = 0; i < size; i++)
            sb.append(ad.pop());
        return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		System.out.println(removePair("aaabbaaccd"));
	}
}

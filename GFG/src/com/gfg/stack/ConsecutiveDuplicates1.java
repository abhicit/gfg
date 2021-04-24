package com.gfg.stack;

import java.util.ArrayDeque;

public class ConsecutiveDuplicates1 {
	public static String removeConsecutiveDuplicates(String str){
        ArrayDeque<String> ad = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder("");
        ad.push(String.valueOf(str.charAt(0)));
        for(int i = 1; i < str.length(); i++){
            if(!ad.peek().equals(String.valueOf(str.charAt(i)))){
                ad.push(String.valueOf(str.charAt(i)));
            }
        }
        
        for(int i = 0; i < ad.size(); i++)
            sb.append(ad.pop());
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(removeConsecutiveDuplicates("aaaaaabaabccccccc"));
	}
}

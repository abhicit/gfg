package com.gfg.maths;

import java.util.HashMap;

public class RecurringSequenceInFraction {
	
	public static String  fractionToDecimal(int num, int den)
    {
        StringBuilder res = new StringBuilder("");
		StringBuilder dec = new StringBuilder("");
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		res = res.append((int)Math.floor(num/den)).append(".");
		
		int rem = num%den;
		if(rem == 0)
		    return String.valueOf(num/den);
		int idx = 0;
		int res_part = 0;
		while((rem != 0) && !map.containsKey(rem)) {
			map.put(rem, idx++);
			
			rem = rem * 10;
			
			res_part = rem / den;
			
			dec = dec.append(String.valueOf(res_part));
			
			rem = rem % den;
		}
		if(rem == 0){
			return res.append(dec).toString();
		}
		else {
			dec.insert(map.get(rem), "(");
			dec.append(")");
			res.append(dec);
		}
		return res.toString();
        
    }
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(7, 14));
	}
	
}

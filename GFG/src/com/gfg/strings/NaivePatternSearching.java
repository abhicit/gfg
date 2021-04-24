package com.gfg.strings;

public class NaivePatternSearching {
	static boolean search(String pat, String txt)
    {
        boolean flag = true;
        for(int i = 0; i <= txt.length()-pat.length(); i++){
        	int counter = i;
        	flag = true;
            for(int j = 0; j < pat.length(); j++){
                if(txt.charAt(counter) != pat.charAt(j)){
                    flag = false;
                    break;
                }
                counter++;
            }
            if(flag)
                return flag;
        }
        return flag;
    }
	
	public static void main(String[] args) {
		String txt = "lkjsdfhaiuehaoewiuraoikdehjakdsfhlsjdkihalieushralkehfailuewhfaklfjsdhfliuewahf";
		String pat = "ahf";
		System.out.println(search(pat, txt));
	}
}

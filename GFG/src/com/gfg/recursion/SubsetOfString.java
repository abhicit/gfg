package com.gfg.recursion;

public class SubsetOfString {
	
	static void printSub(String str, String curr, int index)
	{
		if(str.length() == index)
		{
			System.out.print(curr+" ");
			return;
		}

		printSub(str, curr, index+1);
		printSub(str, curr+str.charAt(index), index+1);
	}
    public static void main(String [] args) 
    {
    	printSub("ABC", "", 0);
    }
}

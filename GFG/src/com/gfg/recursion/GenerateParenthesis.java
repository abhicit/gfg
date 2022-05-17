package com.gfg.recursion;

import java.util.ArrayList;
import java.util.List;

//Java program to print all
//combinations of balanced parentheses

class GenerateParenthesis {
 // Function that print all combinations of
 // balanced parentheses
 // open stores the count of opening parenthesis
 // close stores the count of closing parenthesis
 static void generateParenthesis(List<String> li, String str,
                               int n, int open,
                               int close)
 {
     if (open == n && close == n) {
         // print the possible combinations
         li.add(str);
         return;
     }
     
     if(open < n)
    	 generateParenthesis(li, str+"(", n, open+1, close);
     
     if(close < open)
    	 generateParenthesis(li, str+")", n, open, close+1);
 }

 // Wrapper over _printParenthesis()
 static void printParenthesis(List<String> str, int n)
 {
     if (n > 0)
         generateParenthesis(str, "", n, 0, 0);
     return;
 }

 // driver program
 public static void main(String[] args)
 {
     int n = 3;
     List<String> str = new ArrayList<>();
     printParenthesis(str, n);
     System.out.println(str);
 }
}

//Contributed by Pramod Kumar
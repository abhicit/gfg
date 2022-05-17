package com.beingSingle;

public class Test8 {
	public static void main(String[] args) {
		diamond(10);
	}

	private static void diamond(int n) {
		int space = n - 1;
	     
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
            space--;
        }
     
        space = 1;
     
        for (int i = n-1; i > 0; i--)
        {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
            space++;
        }
	}
}

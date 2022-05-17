package com.gfg.maths;

import java.util.ArrayList;
import java.util.TreeSet;

public class Maths1 {
	public static ArrayList<Long> generateNumbers(int N){
        TreeSet<Long> s = new TreeSet<>();
        s.add(1L);
        ArrayList<Long> v = new ArrayList<>();
        for (int i = 0; i < N; i++)
        {
            long it = s.first();
            long h = (it);
            v.add(h);
            s.remove(it);
            long k = h * 2;
            s.add(k);
            k = h * 3;
            s.add(k);
            k = h * 5;
            s.add(k);
            k = h * 7;
            s.add(k);
        }
        return v;
    }
	
	public static void main(String[] args) {
		ArrayList<Long> res = generateNumbers(15);
		res.forEach(System.out::println);
	}
}

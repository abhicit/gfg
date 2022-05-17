package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class CountPaths {
	
	static int res = 0;
	
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);
        
        //int[] recSt = new int[5];
        countPaths(adj, 0, 3);
        
        System.out.println(res);
	}
	
	private static void countPaths(ArrayList<ArrayList<Integer>> adj, int s, int d) {
		if(s == d)
			res++;
		else {
			//recSt[s] = 1;
			for(int u : adj.get(s)) {
				countPaths(adj, u, d);
				//recSt[s] = 0;
			}
		}
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
}

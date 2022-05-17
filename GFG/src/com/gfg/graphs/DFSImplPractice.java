package com.gfg.graphs;

import java.util.ArrayList;

public class DFSImplPractice {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int n = 6;
		
		for(int i = 0; i < n; i++)
			adj.add(new ArrayList<Integer>());
		
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 2);
		
		boolean[] visited = new boolean[n];
		
		dfs(adj, 0, visited);
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited) {
		visited[i] = true;
		System.out.print(i+" ");
		for(int u : adj.get(i)) {
			if(!visited[u]) {
				dfs(adj, u, visited);
			}
		}
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
}

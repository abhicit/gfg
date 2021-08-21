package com.gfg.graphs;

import java.util.ArrayList;

public class DFSImpl {
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 4);
		
		dfs(adj, 0);
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> adj, int s) {
		boolean[] visited = new boolean[adj.size()];
		dfsRec(adj, s, visited);
	}

	private static void dfsRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;
		System.out.print(s+" ");
		for(int v : adj.get(s))
			if(!visited[v]) {
				dfsRec(adj, v, visited);
			}
	}
}

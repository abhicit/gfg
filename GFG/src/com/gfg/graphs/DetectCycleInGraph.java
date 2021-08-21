package com.gfg.graphs;

import java.util.ArrayList;

public class DetectCycleInGraph {
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
		addEdge(adj, 4, 0);
		//addEdge(adj, 0, 5);
		
		System.out.println(dfs(adj));
	}
	
	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public static boolean dfs(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		for(int i = 0; i < adj.size(); i++) {
			if(!visited[i])
				if(!dfsRec(adj, i, visited, -1))
					return false;
		}
		return true;
	}

	private static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, int parent) {
		visited[i] = true;
		for(int u : adj.get(i)) {
			if(!visited[u]) {
				visited[u] = true;
				if(dfsRec(adj, u, visited, i))
					return true;
			}else if(u != parent) {
				return true;
			}
		}
		return false;
	}
}

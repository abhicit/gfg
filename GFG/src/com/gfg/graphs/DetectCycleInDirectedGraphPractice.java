package com.gfg.graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphPractice {
	public static void main(String[] args) {
		int v = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 2, 1);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 3);
		
		System.out.println(dfs(adj));
	}
	
	private static boolean dfs(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		boolean[] recSt = new boolean[adj.size()];
		for(int i = 0; i < adj.size(); i++)
			if(!visited[i] && dfsRec(adj, i, visited, recSt))
				return true;
		return false;
	}

	private static boolean dfsRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, boolean[] recSt) {
		visited[i] = true;
		recSt[i] = true;
		
		for(int u : adj.get(i)) {
			if(!visited[u] && dfsRec(adj, u, visited, recSt))
				return true;
			if(recSt[u])
				return true;
		}
		recSt[i] = true;
		
		return false;
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
}

package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleUndirectedGraphPractice {
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
	
	
	private static boolean dfs(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		Arrays.fill(visited, false);
		for(int i = 0; i < adj.size(); i++) {
			if(!visited[i] && hasCycle(adj, i, visited, -1))
				return true;
		}
		return false;
	}


	private static boolean hasCycle(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, int parent) {
		visited[i] = true;
		
		for(int u : adj.get(i)) {
			if(!visited[u] && hasCycle(adj, u, visited, i))
				return true;
			else if(u != parent)
				return true;
		}
		return false;
	}


	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
}

package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		addEdge(adj, 0, 1);
		addEdge(adj, 1, 3);
		addEdge(adj, 3, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 2, 4);
		
		dfs(adj);
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < adj.size(); i++) {
			if(!visited[i])
				dfsRec(i, visited, st, adj);
		}
		
		while(!st.isEmpty())
			System.out.print(st.pop()+" ");
	}

	public static void dfsRec(int s, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
		visited[s] = true;
		for(int i : adj.get(s)) 
			if(!visited[i]) {
				dfsRec(i, visited, st, adj);
			}
		st.add(s);
	}
}

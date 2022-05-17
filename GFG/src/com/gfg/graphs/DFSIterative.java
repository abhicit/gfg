package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class DFSIterative {
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 1, 0);
        addEdge(adj, 0, 2);
        addEdge(adj, 2, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 4);
        
        dfs(adj, 0);
	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int s) {
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[adj.size()];
		
		st.push(s);
		
		while(!st.empty()) {
			int u = st.pop();
			if(!visited[u]) {
				System.out.print(u+" ");
				visited[u] = true;
			}
			for(int v : adj.get(u)) {
				if(!visited[v]) {
					st.push(v);
				}
			}
		}
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
}

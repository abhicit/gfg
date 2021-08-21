package com.gfg.graphs;

import java.util.ArrayList;

public class DFSDisconnected {
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u); 
	}
	
	public static void main(String[] args) {
		int v = 8;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 5, 3); 
		addEdge(adj, 6, 4);
		addEdge(adj, 6, 7);
		System.out.println(dfsDis(adj));
	}
	
	public static int dfsDis(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		int count = 0;
		for(int i = 0; i < adj.size(); i++) {
			if(!visited[i]) {
				dfsDisRec(adj, i, visited);
				count++;
			}
		}
		System.out.println();
		return count;
	}

	private static void dfsDisRec(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited) {
		visited[i] = true;
		System.out.print(i+" ");
		for(int v : adj.get(i)) {
			if(!visited[v]) {
				visited[v] = true;
				dfsDisRec(adj, v, visited);
			}
		}
	}
}

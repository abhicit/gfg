package com.gfg.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortKahnPractice {
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 2);
		addEdge(adj, 0, 3);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		
		bfs(adj);
	}
	
	private static void bfs(ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[adj.size()];
		for(int i = 0; i < adj.size(); i++)
			for(int u : adj.get(i))
				++indegree[u];
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < adj.size(); i++)
			if(indegree[i] == 0)
				q.add(i);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u+" ");
			for(int v : adj.get(u)) {
				--indegree[v];
				if(indegree[v] == 0)
					q.add(v);
			}
		}
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
}

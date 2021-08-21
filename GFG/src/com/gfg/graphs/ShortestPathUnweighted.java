package com.gfg.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweighted {
	public static void main(String[] args) {
		int v = 4;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 3);
		
		shortestPath(adj, 0);
	}
	
	private static void shortestPath(ArrayList<ArrayList<Integer>> adj, int i) {
		boolean[] visited = new boolean[adj.size()];
		int[] dist = new int[adj.size()];
		dist[i] = 0;
		visited[i] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u+" ");
			for(int v : adj.get(u)) {
				if(!visited[v]) {
					visited[v] = true;
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}
		System.out.println();
		for(int j : dist)
			System.out.print(j+" ");
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(v).add(u);
		adj.get(u).add(v);
	}
}

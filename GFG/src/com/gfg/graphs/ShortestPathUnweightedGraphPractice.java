package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnweightedGraphPractice {
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u); 
	}
	
	public static void main(String[] args) {
		int v = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 0, 5);
		
		int[] dist = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		shortestDist(adj, 0, dist);
		
		for(int i : dist)
			System.out.print(i+" ");
	}

	private static void shortestDist(ArrayList<ArrayList<Integer>> adj, int i, int[] dist) {
		boolean[] visited = new boolean[adj.size()];
		visited[i] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		dist[0] = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : adj.get(u)) {
				if(!visited[v]) {
					dist[v] = dist[u]+1;
					visited[v] = true;
					q.add(v);
				}
			}
		}
	}
}

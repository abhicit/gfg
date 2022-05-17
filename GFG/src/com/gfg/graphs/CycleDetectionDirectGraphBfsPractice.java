package com.gfg.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionDirectGraphBfsPractice {
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 1, 2);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 1);
		addEdge(adj, 4, 1);
		
		System.out.println(bfs(adj));
	}
	
	private static boolean bfs(ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[adj.size()];
		for(int i = 0; i < adj.size(); i++)
			for(int u : adj.get(i))
				++indegree[u];
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < adj.size(); i++)
			if(indegree[i] == 0)
				q.add(i);
		
		int count = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : adj.get(u)) {
				--indegree[v];
				if(indegree[v] == 0)
					q.add(v);
			}
			count++;
		}
		
		return (count != adj.size());
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
}

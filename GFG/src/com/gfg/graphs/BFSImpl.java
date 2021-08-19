package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSImpl {
	
	public static void bfs(ArrayList<ArrayList<Integer>> adj, int s) {
		boolean[] visited = new boolean[adj.size()];
		Arrays.fill(visited, false);
		visited[s] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u+" ");
			for(int v : adj.get(u)) {
				if(!visited[v]) {
					q.add(v);
					visited[v] = true;
				}
			}
		}
	}
	
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	 
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
		//addEdge(adj, 0, 5);
		
		bfs(adj, 0);
	}
	
}

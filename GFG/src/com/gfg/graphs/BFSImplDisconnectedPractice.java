package com.gfg.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSImplDisconnectedPractice {
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
		
		System.out.println("No. of islands : "+bfsDis(adj));
	}

	private static int bfsDis(ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[adj.size()];
		int res = 0;
		for(int i = 0; i < adj.size(); i++) {
			if(visited[i]) {
				bfs(adj, i, visited);
				res++;
			}
		}
		return res;
	}

	private static void bfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited) {
		visited[i] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		
		while(!q.isEmpty()) {
			int u = q.poll();
			System.out.print(u+" ");
			
			for(int v : adj.get(u)) {
				if(!visited[v]) {
					visited[v] = true;
					q.add(v);
				}
			}
		}
	}
}

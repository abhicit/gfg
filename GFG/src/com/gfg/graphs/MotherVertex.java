package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class MotherVertex {
	public static void main(String[] args) {
		int V = 7;
	    int E = 8;
	     
	    ArrayList<
	    ArrayList<Integer>> adj = new ArrayList<
	                                  ArrayList<Integer>>();
	    for(int i = 0; i < V; i++)
	    {
	        adj.add(new ArrayList<Integer>());
	    }
	    addEdge(0, 1,adj);
	    addEdge(0, 2,adj);
	    addEdge(1, 3,adj);
	    addEdge(4, 1,adj);
	    addEdge(6, 4,adj);
	    addEdge(5, 6,adj);
	    addEdge(5, 2,adj);
	    addEdge(6, 0,adj);
	     
	    System.out.println("The mother vertex is " +
	                        motherVertex(adj, V));
	}
	
	private static int motherVertex(ArrayList<ArrayList<Integer>> adj, int V) {
		int u = -1;
		
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				util(adj, i, visited);
				u = i;
			}
		}
		
		Arrays.fill(visited, false);
		util(adj, u, visited);
		for(boolean i : visited)
			if(!i)
				return -1;
		return u;
	}
	
	private static void util(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s] = true;
		
		for(int u : adj.get(s))
			if(!visited[u])
				util(adj, u, visited);
	}

	static void addEdge(int u, int v, ArrayList<ArrayList<Integer>> adj) {
		adj.get(u).add(v);
	}
}

package com.gfg.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class AdjListNode{
	private int v;
	private int w;
	public AdjListNode() {}
	public AdjListNode(int v, int w) {
		this.v = v;
		this.w = w;
	}
	public int getV() {return v;}
	public int getW() {return w;}
}

public class ShortestPathInDAG {
	static ArrayList<ArrayList<AdjListNode>> adj = new ArrayList<>();
	public static void main(String[] args) {
		int v = 5;
		
		for(int i = 0; i < v; i++) {
			adj.add(new ArrayList<AdjListNode>());
		}
		
		addEdge(adj, 0, 1, 2);
		addEdge(adj, 0, 4, 1);
		addEdge(adj, 1, 2, 3);
		addEdge(adj, 2, 3, 6);
		addEdge(adj, 4, 2, 2);
		//addEdge(adj, 4, 5, 4);
		//addEdge(adj, 5, 3, 1);
		
		shortestPath(0);
		System.out.println();
		shortestPathTest(0);
	}
	
	public static void addEdge(ArrayList<ArrayList<AdjListNode>> adj, int u, int v, int w) {
		adj.get(u).add(new AdjListNode(v, w));
	}
	
	public static void topologicalSortUtil(ArrayList<ArrayList<AdjListNode>> adj, int s, boolean[] visited, Stack<Integer> st) {
		visited[s] = true;
		for(AdjListNode i : adj.get(s)) {
			if(!visited[i.getV()])
				topologicalSortUtil(adj, i.getV(), visited, st);
		}
		st.push(s);
	}
	
	public static void shortestPath(int s) {
		Stack<Integer> st = new Stack<Integer>();
		int[] dist = new int[adj.size()];
		
		boolean[] visited = new boolean[adj.size()];
		for(int i = 0; i < adj.size(); i++) {
			if(!visited[i])
				topologicalSortUtil(adj, i, visited, st);
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[s] = 0;
		
		while(!st.isEmpty()) {
			int u = st.pop();
			for(AdjListNode i : adj.get(u)) {
				if(dist[i.getV()] > dist[u] + i.getW())
					dist[i.getV()] = dist[u] + i.getW();
			}
		}
		
		for (int i = 0; i < adj.size(); i++)
        {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print( "INF ");
            else
                System.out.print( dist[i] + " ");
        }
	}
	
	public static void shortestPathTest(int s) {
		int[] dist = new int[adj.size()];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> q = new LinkedList<>();
		//boolean[] visited = new boolean[adj.size()];
		dist[s] = 0;
		q.add(s);
		while(!q.isEmpty()) {
			int u = q.poll();
			for(AdjListNode v : adj.get(u)) {
				//if(!visited[v.getV()]) {
					//visited[v.getV()] = true;
					q.add(v.getV());
					if(dist[v.getV()] > v.getW() + dist[u])
						dist[v.getV()] = v.getW() + dist[u];
				//}
			}
		}
		
		for(int i : dist)
			System.out.print(i+" ");
	}
}

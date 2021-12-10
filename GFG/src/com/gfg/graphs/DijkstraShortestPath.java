package com.gfg.graphs;

import java.util.Arrays;

public class DijkstraShortestPath {
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 50, 100, 0}, 
			{ 50, 0, 30, 200 }, 
			{ 100, 30, 0, 20 }, 
			{ 0, 200, 20, 0 }}; 
			
		int[] res = dijkstra(graph, 0);
		for(int i : res)
			System.out.print(i+" ");
	}

	public static int[] dijkstra(int[][] graph, int s) {
		int V = graph.length;
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		boolean[] finalized = new boolean[V];
		for(int count = 0; count < V-1; count++) {
			int u = -1;
			for(int i = 0; i < V-1; i++)
				if(!finalized[i] && (u == -1 || dist[i] < dist[u]))
					u = i;
			finalized[u] = true;
			for(int v = 0; v < V; v++) {
				if(!finalized[v] && graph[u][v] != 0)
					dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
			}
		}
		return dist;
	}
}

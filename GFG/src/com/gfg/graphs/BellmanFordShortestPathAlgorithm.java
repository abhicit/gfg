package com.gfg.graphs;

public class BellmanFordShortestPathAlgorithm {
	class Edge { 
		int src, dest, weight; 
		Edge() 
		{ 
			src = dest = weight = 0; 
		} 
	};
	
	int V, E; 
	Edge edge[];
	
	BellmanFordShortestPathAlgorithm(int V, int e){
		this.V = V;
		this.E = e;
		edge = new Edge[e];
		for(int i = 0; i < e; i++)
			edge[i] = new Edge();
	}
	
	public static void bellmanFord(BellmanFordShortestPathAlgorithm graph, int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];
		
		for(int i = 0; i < V; i++) 
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;
		
		for(int i = 1; i < V; i++) {
			for(int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int wt = graph.edge[j].weight;
				if(dist[v] > dist[u] + wt)
					dist[v] = dist[u] + wt;
			}
		}
		
		for(int j = 0; j < E; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int wt = graph.edge[j].weight;
			if(dist[v] > dist[u] + wt) {
				System.out.println("There's a negative weight cycle");
				return;
			}
		}
		
		printDist(dist);
	}

	private static void printDist(int[] dist) {
		for(int i : dist)
			System.out.print(i+" ");
	}
	
	public static void main(String[] args) {
		int V = 4;
		int E = 5;
		
		BellmanFordShortestPathAlgorithm graph = new BellmanFordShortestPathAlgorithm(V, E);
		
    	graph.edge[0].src = 0; 
    	graph.edge[0].dest = 1; 
    	graph.edge[0].weight = 1; 
    
    	graph.edge[1].src = 0; 
    	graph.edge[1].dest = 2; 
    	graph.edge[1].weight = 4; 
    
    	graph.edge[2].src = 1; 
    	graph.edge[2].dest = 2; 
    	graph.edge[2].weight = -3; 
    
    	graph.edge[3].src = 1; 
    	graph.edge[3].dest = 3; 
    	graph.edge[3].weight = 2; 
    
    	graph.edge[4].src = 2; 
    	graph.edge[4].dest = 3; 
    	graph.edge[4].weight = 3;
    	
    	bellmanFord(graph, 0);
	}
}

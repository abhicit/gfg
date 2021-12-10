package com.gfg.graphs;

import java.util.Arrays;

public class PrimsMST {
	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 5, 8, 0}, 
			{ 5, 0, 10, 15 }, 
			{ 8, 10, 0, 20 }, 
			{ 0, 15, 20, 0 },};  

			System.out.print(primMST(graph)); 
	}

	public static int primMST(int[][] graph) {
		int[] key = new int[graph.length];
		int res = 0;
		Arrays.fill(key, Integer.MAX_VALUE);
		boolean[] mSet = new boolean[graph.length];
		key[0] = 0;
		for (int count = 0; count < graph.length ; count++) 
    	{ 
    		int u = -1; 
    
    		for(int i=0;i<graph.length;i++)
    		    if(!mSet[i]&&(u==-1||key[i]<key[u]))
    		        u=i;
    		mSet[u] = true; 
    		res+=key[u];
    
    		
    		for (int v = 0; v < graph.length; v++) 
    
    			if (graph[u][v]!=0 && mSet[v] == false) 
    				key[v] = Math.min(key[v],graph[u][v]); 
    	} 
        return res;
	}
}

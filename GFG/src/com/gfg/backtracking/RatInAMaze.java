package com.gfg.backtracking;

public class RatInAMaze {
	static int N = 3;
	static int[][] maze = {{1,0,1}, {1,1,0}, {0,1,1}};
	static int[][] sol = new int[N][N];
	
	public static void main(String[] args) {
		System.out.println(solveMaze());
	}
	
	public static boolean solveMaze() {
		if(!solveMazeRec(0,0))
			return false;
		else {
			print(sol);
			return true;
		}
	}

	private static void print(int[][] sol) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(sol[i][j] == 1)
					System.out.print(sol[i][j]+"");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static boolean solveMazeRec(int i, int j) {
		if(i == N-1 && j == N-1) {
			sol[i][j] = 1;
			return true;
		}
		if(isSafe(i, j)) {
			sol[i][j] = 1;
			if(solveMazeRec(i+1, j))
				return true;
			else if(solveMazeRec(i, j+1))
				return true;
			sol[i][j] = 0;
		}
		return false;
	}

	private static boolean isSafe(int i, int j) {
		return (i < N && j < N && maze[i][j] == 1);
	}
}

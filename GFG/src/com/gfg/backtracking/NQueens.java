package com.gfg.backtracking;

public class NQueens {
	static int N = 4;
	static char[][] board = new char[N][N];
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	public static boolean solve() {
		if(!solveRec(0))
			return false;
		else {
			print(board);
			return true;
		}
	}
	
	private static void print(char[][] sol) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(sol[i][j] == 'Q')
					System.out.print(sol[i][j]+"");
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}

	private static boolean solveRec(int col) {
		if(col == N)
			return true;
		for(int i = 0; i < N; i++) {
			if(isSafe(i, col)) {
				board[i][col] = 'Q';
				if(solveRec(col+1))
					return true;
				board[i][col] = '$';
			}
		}
		return false;
	}

	private static boolean isSafe(int row, int col) {
		for(int i = 0; i < col; i++)
			if(board[row][i] == 'Q')
				return false;
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if(board[i][j] == 'Q')
				return false;
		for(int i = row, j = col; j >= 0 && i < N; i++, j--)
			if(board[i][j] == 'Q')
				return false;
		return true;
	}
}

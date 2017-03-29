/*
 *Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.
 *
 *
 *i/p:
 *None

 *o/p:
 *different ways 8 queens can be arranged
 *
 *NB: I wrote an N Queens placement generator.
 */


import java.io.*;
import java.util.*;

class NQueens {
	static int n;
    public static void main(String args[]) {
		n = 8;
		System.out.println("All placements for " + n + " Queens:");
		generateNQueens();
    }

	private static void generateNQueens() {
		boolean[][] board = new boolean[n][n];
		placeNQueens(board, 0);	
	}

	private static boolean placeNQueens(boolean[][] board, int col) {
		if (col >= n)	return true;

		for (int row = 0; row < n; row++) {
			if (canPlaceQueen(board, row, col)) {
				board[row][col] = true;
				if (placeNQueens(board, col + 1)) {
					if (col == n - 1)	printBoard(board);
					if (col > 0) {
						board[row][col] = false;	
						return true;
					}
				}
				board[row][col] = false;
			}
		}	
		return false;	
	}

	private static boolean canPlaceQueen(boolean[][] board, int r, int c) {
		for (int col = 0; col < c; col++) {
			if (board[r][col])	return false;	
		}

		for (int row = r, col = c; row >= 0 && col >= 0; row--, col--) {
			if (board[row][col])	return false;	
		}	

		for (int row = r, col = c; row < n && col >= 0; row++, col--) {
			if (board[row][col])	return false;	
		}
		return true;
	}

	private static void printBoard(boolean board[][]) {
		for (int i = 0; i <= 2 * n; i++)		System.out.print("*");
		System.out.println();

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (board[row][col])	System.out.print("|Q");
				else System.out.print("| ");
			}	
			System.out.println("|");
		}	

		for (int i = 0; i <= 2 * n; i++)		System.out.print("*");
		System.out.println();
	}
}


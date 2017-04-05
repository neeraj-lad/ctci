/*
 *Given an M x N matrix in which each row and each column is sorted in ascending order,
 *write a method to find an element.
 *
 *i/p:
 *int[][] M, int x
 *
 *o/p:
 *int[] idx
 *
 *Mtd		Time		Space
 *Search	O(m + n)	O(1)		//m = number of rows, n = number of columns
 *
 */


import java.io.*;
import java.util.*;

class SortedMatrixSearch {
    public static void main(String args[]) {
		int[][] M = {
					{1, 2, 3, 4, 5, 6},	
					{7, 12, 13, 14, 15, 16},	
					{8, 25, 26, 27, 28, 29},	
					};
		int x = 1;
		int[] res = sortedMatrixSearch(M, x);
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				System.out.print(M[i][j] + " ");	
			}	
			System.out.println();
		}
		System.out.println("Index of " + x + " is:");
		System.out.println(res[0] + ", " + res[1]);
    }

	private static int[] sortedMatrixSearch(int[][] M, int x) {
		if (M == null || M.length == 0 || M[0].length == 0)		return new int[]{-1, -1};

		int m = M.length, n = M[0].length;

		int i = 0, j = n - 1;
		while (i >= 0 && j < n) {
			if (M[i][j] < x)	i++;
			else if (M[i][j] > x)	j--;	
			else	return new int[]{i, j};
		}
		return new int[]{-1, -1};
	}
}


/*
 *Pond Sizes: You have an integer matrix representing a plot of land, where the value at that loca- tion represents 
 *the height above sea level. A value of zero indicates water. A pond is a region of water connected vertically, 
 *horizontally, or diagonally. The size of the pond is the total number of connected water cells. 
 *Write a method to compute the sizes of all ponds in the matrix.
 *EXAMPLE
 *Input:
 *0 2 1 0
 *0 1 0 1
 *1 1 0 1
 *0 1 0 1
 *
 *Output: 2, 4, 1 (in any order)
 *
 *i/p:
 *int[][] plot
 *
 *o/p:
 *List<Integer> res
 *
 *Mtd		Time	Space
 *BFS		O(m*n)	O(m*n)
 *
 */


import java.io.*;
import java.util.*;

class PondSizes {
    public static void main(String args[]) {
		int[][] plot = {{0, 2, 1, 0},
						{0, 1, 0, 1},
						{1, 1, 0, 1},
						{0, 1, 0, 1}
		};
		printMatrix(plot);	
		System.out.println(getPondSizes(plot));
    }

	private static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)	System.out.print(a[i][j] + " ");	
			System.out.println();
		}	
	}

	private static List<Integer> getPondSizes(int[][] plot) {
		if (plot == null)	throw new IllegalArgumentException();
		
		List<Integer> res = new ArrayList<Integer>();
		int m = plot.length, n = plot[0].length;	
		if (m == 0 || n == 0)	return res;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (plot[i][j] == 0) {
					res.add(bfs(plot, i, j));	
				}	
			}	
		}		
		return res;
	}

	private static int bfs(int[][] plot, int I, int J) {
		int res = 0;
		
		Queue<Integer> iQ = new LinkedList<Integer>();	
		Queue<Integer> jQ = new LinkedList<Integer>();	

		plot[I][J] = -1;			//Mark co-ord(I, J)	as visited
		iQ.add(I);
		jQ.add(J);

		while (!iQ.isEmpty()) {
			I = iQ.remove();
			J = jQ.remove();
			res++;
			
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (!(i == 0 && j == 0)) {
						if (isValid(plot, I + i, J + j)) {
							plot[I + i][J + j] = -1;
							iQ.add(I + i);
							jQ.add(J + j);
						}	
					}	
				}	
			}
		}
		return res;
	}

	private static boolean isValid(int[][] plot, int i, int j) {
		int m = plot.length, n = plot[0].length;
		return((0 <= i && i < m) && (0 <= j && j < n) && (plot[i][j] == 0));	
	}

		
}


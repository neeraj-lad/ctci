/*
 *Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, 
 *write a method to rotate the image by 90 degrees. (an you do this in place?
 *
 *i/p:
 *int[][] matrix
 *
 *o/p:
 *void
 *
 *Mtd			Time	Space 
 *Four swaps	O(N*N)	O(1)
 */

import java.io.*;
import java.util.*;

class RotateMatrix {
    public static void main(String args[]) {
		int[][] matrix = {
						{1, 2, 3},
						{3, 4, 5},
						{6, 7, 8}
						};
		printMatrix(matrix);
		rotateMatrix(matrix);
		printMatrix(matrix);
    }

	private static void rotateMatrix(int[][] matrix) {
		if (matrix == null)		throw new IllegalArgumentException();
		int n = matrix.length;
		if (n == 0)		return;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int t1 = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                
                int t2 = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = t1;
                
                int t3 = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = t2;
                
                matrix[i][j] = t3;
			}		
		}	
	}

	private static void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");		
			}	
			System.out.println();
		}	
		System.out.println();
	}
}

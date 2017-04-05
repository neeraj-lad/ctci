/*
 * In an array of integers, a "peak" is an element which is greater than or equal to the adjacent integers 
 * and a "valley" is an element which is less than or equal to the adjacent inte- gers. 
 * For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {S, 2} are valleys. 
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 *
 *i/p:
 *int[] a
 *
 *o/p:
 *void
 *
 *Mtd:			Time	Space
 *Swapping		O(n)	O(1)
 *
 *
 */

import java.io.*;
import java.util.*;

class PeaksAndValleys {
    public static void main(String args[]) {
		int[] a = {1, 3, 8, 9, 10, 4, 3, 0};
		peaksAndValleys(a);
    }

	private static void peaksAndValleys(int[] a) {
		if (a == null)	return;

		printArray(a);
		for (int i = 0; i < a.length - 1; i++) {
			if (i % 2 == 0 && a[i] < a[i + 1])	swap(a, i, i + 1);
			else if (i % 2 == 1 && a[i] > a[i + 1])		swap(a, i, i + 1);	
		}	
		printArray(a);
	}

	private static void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;	
	}

	private static void printArray(int[] a) {
		for (int i : a)		System.out.print(i + " ");
		System.out.println();	
	}
}


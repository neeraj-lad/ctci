/*
 *You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 *Write a method to merge B into A in sorted order.
 *
 *i/p:
 *float a[], int m, float b[], int n
 *
 *o/p:
 *void
 *
 *Mtd			Time		Space
 *Two pointer	O(m + n)	O(1)
 *
 */

import java.io.*;
import java.util.*;

class SortedMerge {
    public static void main(String args[]) {
		float[] a = {0.1f, 1.5f, 2.0f, 0.0f, 0.0f, 0.0f};
		float[] b = {0.3f, 1.0f, 3.0f};
		sortedMerge(a, 3, b, 3);
    }

	private static void sortedMerge(float[] a, int m, float[] b, int n) {
		if (a == null || b == null)		return;
		if (a.length < m + n)	throw new IllegalArgumentException();

		printArray(a);
		printArray(b);

		int i = m - 1, j = n - 1, k = a.length - 1;
		while (i >= 0 && j >= 0) {
			if (Float.compare(a[i], b[j]) >= 0) {
				a[k--] = a[i--];	
			}	
			else {
				a[k--] = b[j--];	
			}
		}	

		while (i >= 0)	a[k--] = a[i--];
		while (j >= 0)	a[k--] = b[j--];

		printArray(a);
	}

	private static void printArray(float[] a) {
		for (float i : a)		System.out.print(i + " ");
		System.out.println();	
	}
}


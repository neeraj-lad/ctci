/*
 *Given two arrays of integers, compute the pair of values (one value in each array) with the smallest 
 *(non-negative) difference. Return the difference.
 *EXAMPLE
 *Input: {1, 3, 15, 11, 2}, {23, 127, 235, 19, 8} 
 *Output: 3. That is, the pair (11 , 8).
 *
 *i/p:
 *int[] a, int[] b
 *
 *o/p:
 *int res
 *
 *Mtd			Time				Space		//m = len(a), n = len(b)
 *Brute Force	O(m*n)				O(1)	
 *Sorting		O(mlogm + nlogn)	O(1)
 *
 *
 *
 */

import java.io.*;
import java.util.*;

class SmallestDifference {
    public static void main(String args[]) {
		/*
		int[] a = {3, 2, 7, 8, 9, 10, 3};
		int[] b = {6, 1, 8, 9, 0, 3, 4, 5, 8, 9};
		*/

		int[] a = {1, 3, 15, 11, 2};
		int[] b = {23, 127, 235, 19, 8};

	
		printArray(a);
		printArray(b);
		System.out.println(bruteForceMtd(a, b));
		System.out.println(sortingMtd(a, b));
    }

	private static void printArray(int[] a) {
		for (int i : a)		System.out.print(i + " ");
		System.out.println();	
	}

	private static int bruteForceMtd(int[] a, int[] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0)	return -1;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				res = Math.min(res, Math.abs(a[i] - b[j]));
				if (res == 0)	return res;						//Minimum possible non-negative value
			}	
		}	
		return res;
	}

	private static int sortingMtd(int[] a, int[] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0)	return -1;
		Arrays.sort(a);
		Arrays.sort(b);

		int res = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			res = Math.min(res, Math.abs(a[i] - b[j]));

			if (a[i] < b[j])	i++;
			else	j++;	
		}	
		return res;
	}
}

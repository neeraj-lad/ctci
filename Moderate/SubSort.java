/*
 *Given an array of integers, write a method to find indices m and n such that if you sorted
 *elements m through n, the entire array would be sorted. Minimize n - m (that is, find the smallest such sequence).
 *EXAMPLE
 *Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 
 *Output: (3, 9)
 *
 *i/p:
 *int[] a
 *
 *o/p:
 *Pair(m, n) res
 *
 *Mtd:
 *Brute Force:	O(l^2)	O(1)		//l is the length of the input array
 *Linear		O(l)	O(1)
 *
 */

import java.io.*;
import java.util.*;

class SubSort {
	static class Pair {
		int m, n;

		Pair() {
			m = -1;
			n = -1;	
		}

		public String toString() {
			return "(" + m + ", " + n + ")";	
		}	
	}

    public static void main(String args[]) {
		//int[] a = {1, 2, 3, 15, 6, 17, 4, 25, 20, 31, 32};
		int[] a = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		printArray(a);
		System.out.println(linearMtd(a));
    }

	private static void printArray(int[] a) {
		for (int i : a)		System.out.print(i + " ");
		System.out.println();	
	}

	private static Pair linearMtd(int[] a) {
		Pair res = new Pair();
		int m = 0, n = a.length - 1;

		for (; m < a.length - 1; m++) {
			if (a[m] > a[m + 1])	break;
		}
		m++;
		for (; n > 0; n--) {
			if (a[n - 1] > a[n])	break;	
		}
		n--;

		int[] minMax = new int[2];
		getMinMax(a, minMax, m, n);

		while (m > 0 && n < a.length - 1) {
			if (a[m - 1] <= minMax[0] && minMax[1] <= a[n + 1])		break;
			
			while (m > 0 && a[m - 1] > minMax[0]) {
				updateMinMax(minMax, a[m - 1]);	
				m--;	
			}
			while (n < a.length - 1 && a[n + 1] < minMax[1]) {
				updateMinMax(minMax, a[n + 1]);	
				n++;
			}
		}
		res.m = m;
		res.n = n;
		return res;
	}

	private static void getMinMax(int[] a, int[] minMax, int start, int end) {
		int min = a[start], max = a[start];
		for (int i = start + 1; i <= end; i++) {
			min	= Math.min(min, a[i]);	
			max	= Math.max(max, a[i]);	
		}
		minMax[0] = min;
		minMax[1] = max;
	}

	private static void updateMinMax(int[] minMax, int x) {
		minMax[0] = Math.min(minMax[0], x);
		minMax[1] = Math.max(minMax[1], x);	
	}
}


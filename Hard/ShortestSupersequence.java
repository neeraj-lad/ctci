/*
 *You are given two arrays, one shorter (with all distinct elements) and one longer. 
 *Find the shortest subarray in the longer array that contains all the elements in the shorter array.
 *The items can appear in any order.
 *EXAMPLE
 *Input:{1, 5, 9} | {7, 5, 9, 13, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7} 
 *Output: [7, 113] 
 *
 *i/p:
 *int[] a, int[] b
 *
 *o/p:
 *int[] res
 *
 *Mtd				Time	Space
 *Sliding Window	O(n)	O(m)		//m, n are the number of elements in the shorter and longer arrays respectively.
 *
 */

import java.io.*;
import java.util.*;

class ShortestSupersequence {
    public static void main(String args[]) {
		int[] a = {1, 5, 9};
		int[] b = {7, 5, 9, 13, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
		printArray(a, 0, a.length - 1);
		printArray(b, 0, b.length - 1);
		int res[] = getShortestSupersequence(a, b);
		System.out.println(res[0] + " " + res[1]);
		printArray(b, res[0], res[1]);
    }

	private static void printArray(int[] a, int start, int end) {
		for (int i = start; i <= end; i++)	System.out.print(a[i] + " ");
		System.out.println();	
	}

	private static int[] getShortestSupersequence(int[] a, int[] b) {
		if (a == null || b == null)		throw new IllegalArgumentException();
		int m = a.length, n = b.length;
		if (m == 0 || n == 0)	return new int[]{-1, -1};

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i : a)	hm.put(i, 1);

		int left = 0, right = 0;
		int minLeft = -1, minRight = -1, minLen = Integer.MAX_VALUE;

		while (right < n) {
			if (hm.containsKey(b[right])) {
				hm.put(b[right], hm.get(b[right]) - 1);
			}	
			right++;
			while (getHMCount(hm) == 0) {
				if (right - left < minLen) {
					minLen = right - left;
					minLeft = left;
					minRight = right;	
				}	
				if (hm.containsKey(b[left]))	hm.put(b[left], hm.get(b[left]) + 1);
				left++;
			}
		}

		return new int[]{minLeft, minRight - 1};
	}

	private static int getHMCount(Map<Integer, Integer> hm) {
		int res = 0;
		for (Integer i : hm.keySet())	if (hm.get(i) > 0)	res++;
		return res;	
	}
}


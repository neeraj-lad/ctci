/*
 *You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. 
 *Return the sum.
 *EXAMPLE
 *Input: 2, -8, 3, -2, 4, -10 Output: 5 (.ie., {3, -2, 4})
 *
 *i/p:
 *int[] a
 *
 *o/p:
 *int res
 *
 * Mtd		Time	Space
 *Kadane	O(n)	O(1)
 *
 */

import java.io.*;
import java.util.*;

class ContiguousSequence {
    public static void main(String args[]) {
		int[] a = {3, 0, -1, 5, -5, -3, 1, 5};
		printArray(a);
		System.out.println(kadaneMtd(a));	
    }

	private static void printArray(int[] a) {
		for (int i : a)		System.out.print(i + " ");
		System.out.println();	
	}

	private static int kadaneMtd(int[] a) {
		if (a == null)		throw new IllegalArgumentException();	
		if (a.length == 0)	return 0;

		boolean allNeg = true;
		for (int i : a) {
			if (i >= 0) {
				allNeg = false;
				break;	
			}	
		}

		if (allNeg) {
			int res = Integer.MIN_VALUE;
			for (int i : a)		res = Math.max(res, i);
			return res;	
		}

		int sum = 0, start = 0, maxSum = 0, maxStart = 0, maxEnd = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (sum < 0) {
				sum = 0;
				start = i + 1;	
			}	
			else if (sum > maxSum) {
				maxSum = sum;
				maxStart = start;
				maxEnd = i;	
			}
		}
	
		for (int i = maxStart; i <= maxEnd; i++)	System.out.print(a[i] + " ");	
		System.out.println();
		return maxSum;
	}
}


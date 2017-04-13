/*
 *Given two arrays of integers, find a pair of values (one value from each array) that you can swap 
 *to give the two arrays the same sum.
 *EXAMPLE
 *Input: (4, 1, 2, 1, 1, 2) and (3, 6, 3, 3)
 *Output: (1, 3)
 *
 *i/p:
 *int[] a, int[] b
 *
 *o/p:
 *int[] res
 *
 *Mtd			Time			Space
 *Sorting	O(mlom + nlogn)		O(1)
 *HashMap	O(m + n)			O(m)
 *
 */


import java.io.*;
import java.util.*;

class SumSwap {
    public static void main(String args[]) {
		int[] a = {3, 6, 8, 1, 4, 2};
		int[] b = {8, 3, 1, 10, 5, 3};
		printArray(a);
		printArray(b);

		int[] res1 = sortingMtd(a, b);
		printArray(res1);

		int[] res2 = hashMtd(a, b);
		printArray(res2);
    }

	private static void printArray(int[] a) {
		for (int i : a)		System.out.print(i + " ");
		System.out.println();	
	}

	private static int getArraySum(int[] a) {
		int res = 0;
		for (int i : a)		res += i;
		return res;	
	}

	private static int getDiff(int[] a, int[] b) {
		if (a == null || b == null || a.length == 0 || b.length == 0)	throw new IllegalArgumentException();

		int aSum = getArraySum(a);
		int bSum = getArraySum(b);
		
		if (aSum < bSum) {
			int[] t = a;
			a = b;
			b = t;
			int tSum = aSum;
			aSum = bSum;
			bSum = tSum;	
		}

		int diff = aSum - bSum;
		if (diff % 2 == 1)	throw new IllegalArgumentException();

		return diff / 2;
	}

	private static int[] sortingMtd(int[] a, int[] b) {
		int diff = getDiff(a, b);

		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] - b[j] == diff) {
				return new int[]{a[i], b[j]};	
			}	
			else if (a[i] - b[j] < diff)	i++;
			else	j++;
		}
		return null;
	}

	private static int[] hashMtd(int[] a, int[] b) {
		int diff = getDiff(a, b);

		Set<Integer> hs = new HashSet<Integer>();
		for (int i : a)	hs.add(i);

		for (int i : b) {
			if (hs.contains(diff + i)) {
				return new int[]{diff + i, i};	
			}	
		}
		return null;
	}
}


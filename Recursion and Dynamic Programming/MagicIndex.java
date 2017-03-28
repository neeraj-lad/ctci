/*
 *A magic index in an array A[e... n-1] is defined to be an index such that A[ i] = i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 *FOLLOW UP
 *What if the values are not distinct?
 *
 *i/p:
 *int[] a
 *
 *o/p:
 *int idx
 *
 *Distinct values:
 *Mtd:			Time	Space
 *Linear		O(n)	O(1)
 *Binary Search O(logn) O(1)
 *
 *Non-distinct values
 *Mtd:			Time	Space
 *Linear		O(n)	O(1)
 *Binary Search O(n)	O(n)		//It is not possible to apply an iterative binary search to reduce space complexity.
 *
 *Below is a binary search solution for non-distinct values.
*/
import java.io.*;
import java.util.*;

class MagicIndex {
    public static void main(String args[]) {
		int a[] = {-1, 1, 1, 2, 2, 6, 7, 8, 8, 8, 9};
		System.out.println(getMagicIndex(a, 0, a.length - 1));
    }

	private static int getMagicIndex(int a[], int start, int end) {
		if (start > end)	return -1;

		int mid = start + (end - start) / 2;
		
		if (mid == a[mid])	return mid;

		int leftBound = Math.min(mid - 1, a[mid]);
		int leftIdx = getMagicIndex(a, start, leftBound);
		if (leftIdx >= 0)	return leftIdx;

		int rightBound = Math.max(mid + 1, a[mid]);
		int rightIdx = getMagicIndex(a, rightBound, end);
		if (rightIdx >= 0)	return rightIdx;

		return -1;	
	}
}


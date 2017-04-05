/*
 *Given a sorted array of n integers that has been rotated an unknown number of times, 
 *write code to find an element in the array. 
 *You may assume that the array was originally sorted in increasing order.
 *EXAMPLE
 *Input:find 5 in {15, 16, 19, 20, 25, 1, 3 ,4 ,5 ,7 , 10, 14}
 *
 *i/p:
 *rotated, sorted array int[] a, int x
 *
 *o/p:
 *int idx
 *
 *Mtd:				Time		Space
 *Binary Search		O(nlogn)	O(logn)		//Space can be reduced to O(1) by implementing Iterative Binary Search
 *
 */


import java.io.*;
import java.util.*;

class SearchInRotatedArray {
    public static void main(String args[]) {
		int[] a = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
		int x = 7;
		for (int i : a)		System.out.print(i + " ");
		System.out.println("\nIndex of " + x + " is:");
		System.out.println(searchInRotatedArray(a, x));
    }

	private static int searchInRotatedArray(int[] a, int x) {
		if (a == null)	return -1;

		int pivot = getPivot(a);
		if (x >= a[0] && x > a[pivot])	return binarySearch(a, x, 0, pivot - 1);
		else	return binarySearch(a, x, pivot, a.length - 1);	
	}

	private static int getPivot(int[] a) {
		int start = 0, end = a.length - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid == 0 || a[mid - 1] > a[mid])	return mid;
			else if (a[start] <= a[mid])	start = mid + 1;
			else	end = mid;
		}		
		return start;
	}

	private static int binarySearch(int[] a, int x, int start, int end) {
		if (start > end)	return -1;
		int mid = start + (end - start) / 2;
		if (a[mid] == x)	return mid;
		else if (a[mid] > x)	return binarySearch(a, x, start, mid - 1);
		else	return binarySearch(a, x, mid + 1, end);	
	}
}


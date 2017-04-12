/*
 *A majority element is an element that makes up more than half of the items in an array. 
 *Given a positive integers array, find the majority element. If there is no majority element, return -1. 
 *Do this in 0 (N) time and O( 1) space.
 *
 *i/p:
 *int[] a
 *
 *o/p:
 *int res
 *
 * Mtd			Time		Space
 *BruteForce	O(n^2)		O(1)
 *Sorting		O(nlogn)	O(1)
 *Moore's Mtd	O(n)		O(1)
 *
 */


import java.io.*;
import java.util.*;

class MajorityElement {
    public static void main(String args[]) {
		int[] a = {3, 3, 5, 4, 2, 3, 3, 4, 5};
				   //2, 3, 3, 3, 3, 4, 4, 5, 5
		printArray(a);
		System.out.println(mooresMtd(a));
    }

	private static void printArray(int[] a) {
		for (int i : a)	System.out.print(i + " ");
		System.out.println();	
	}

	private static int mooresMtd(int[] a) {
		if (a == null)	throw new IllegalArgumentException();
		if (a.length == 0)	return -1;

		int candidate = a[0];
		int count = 0;
		for (int i : a) {
			if (count == 0)	{
				count++;
				candidate = i;	
			}
			if (i == candidate)	count++;
			else	count--;
		}	
		count = 0;
		for (int i : a)	if (i == candidate)	count++;

		return (count >= a.length / 2) ? candidate : -1;
	}
}


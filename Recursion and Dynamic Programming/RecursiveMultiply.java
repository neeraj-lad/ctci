/*
 * Write a recursive function to multiply two positive integers without using the * operator. You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 *
 *
 *i/p:
 *int a, int b
 *
 *o/p:
 *int res
 *
 *Mtd					Time			Space		//Assuming a > b
 *Addition Recursive	O(b)			O(b)
 *Addition + Bit shift	O(b/2)=O(b)		O(b)
 *Division 				O(logb)			O(logb)
 *
 *Todo: Think of an elegant bottom up solution for Divison mtd
 *
 *
 * */

import java.io.*;
import java.util.*;

class RecursiveMultiply {
    public static void main(String args[]) {
		int a = 100, b = 66;
		System.out.println(mtd1(a, b));
		System.out.println(dpMtd1(a, b));
		System.out.println(mtd2(a, b));
		System.out.println(dpMtd2(a, b));
		System.out.println(mtd3(a, b));
    }

	private static int mtd1(int a, int b) {
		if (b == 0)	return 0;
		return a + mtd1(a, b - 1);
	}

	private static int dpMtd1(int a, int b) {
		int dp[] = new int[b + 1];
		for (int i = 1; i <= b; i++) {
			dp[i] = dp[i - 1] + a;	
		}
		return dp[b];
	}

	private static int mtd2(int a, int b) {
		if (b == 0)	return 0;
		if (b == 1)	return a;
		return mtd2(a, b - 2) + (a << 1);
	}

	private static int dpMtd2(int a, int b) {
		int dp[] = new int[b + 1];
		dp[1] = a;
		for (int i = 2; i <= b; i++) {
			dp[i] = dp[i - 2] + (a << 1);	
		}	
		return dp[b];
	}

	private static int mtd3(int a, int b) {
		if (b == 0)	return 0;
		if (b == 1)	return a;
		return (b % 2 == 0) ? (mtd3(a, b / 2)) << 1 : ((mtd3(a, b/ 2)) << 1) + a;
	}
}


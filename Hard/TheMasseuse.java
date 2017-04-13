/*
 *A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept. 
 *She needs a 15-minute break between appointments and therefore she cannot accept any adjacent requests. 
 *Given a sequence of back-to-back appointment requests(all multiples of 15 minutes, none overlap, and none can be moved), 
 *find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.
 *
 *EXAMPLE
 *Input: {30, 15, 60, 75, 45, 15, 15, 45}
 *Output: 180 minutes ({30, 60,45, 45}).
 *
 *Mtd		Time	Space
 *DP		O(n)	O(n)		//n is the number of appointment requests
 *
 */

import java.io.*;
import java.util.*;

class TheMasseuse {
    public static void main(String args[]) {
		int[] a = {30, 15, 60, 75, 45, 15, 15, 45};
		printArray(a);
		System.out.println(dpMtd(a));
    }

	private static void printArray(int[] a) {
		for (int i : a)		System.out.print(i + " ");
		System.out.println();	
	}

	private static int dpMtd(int[] a) {
		if (a == null)	throw new IllegalArgumentException();
		if (a.length == 0)	return 0;
		if (a.length == 1)	return a[0];

		int n = a.length;
		int dp[] = new int[n];
		int s[] = new int[n];
		Arrays.fill(s, -1);

		dp[0] = a[0];
		s[0] = -1;
		dp[1] = Math.max(dp[0], dp[1]);
		if (dp[0] >= dp[1])		s[1] = 0;

		for (int i = 2; i < n; i++) {
			if (dp[i - 2] + a[i] >= dp[i - 1]) {
				dp[i] = dp[i - 2] + a[i];
				s[i] = i - 2;
			}
			else {
				dp[i] = dp[i - 1];
				s[i] = i - 1;	
			}
		}

		printArray(dp);

		int maxIdx = -1, maxVal = -1;	
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > maxVal)	{
				maxVal = dp[i];
				maxIdx = i;	
			}	
		}	
		printAppointments(a, s, maxIdx);
		return dp[n - 1];
	}

	private static void printAppointments(int[] a, int[] s, int idx) {
		int p;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		do {
			stack.push(a[idx]);
			p = s[idx];
			idx = p;
		} while (idx != -1);
		System.out.println(stack);
	}
}


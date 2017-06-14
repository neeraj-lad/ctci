/*
 *You are building a diving board by placing a bunch of planks of wood end-to-end. 
 *There are two types of planks, one of length shorter and one of length longer. 
 *You must use exactly K planks of wood.
 *Write a method to generate all possible lengths for the diving board.
 *
 *i/p:
 *int k, int shorterLen, int longerLen
 *
 *o/p:
 *int res
 *
 *Mtd				Time	Space
 *Recursive			O(2^k)	O(K)
 *Recursive-Memo	O(K*K)	O(K)
 *Combinatorics		O(K)	O(1)
 *
 */


import java.io.*;
import java.util.*;

class DivingBoard {
    public static void main(String args[]) {
		int k = 2, a = 2, b = 1;
		System.out.println(combinatoricsMtd(k, a, b));	
		Set<Integer> res = new HashSet<Integer>();
		recursiveMemo(k, 0, a, b, res, new HashSet<String>());
		System.out.println(res);
    }

	private static void recursiveMemo(int k, int len, int shorterLen, int longerLen, Set<Integer> res, Set<String> memo) {
		if (k == 0) {
			res.add(len);
			return;	
		}	

		if (memo.contains("" + k + " " + len))	return;

		recursiveMemo(k - 1, len + shorterLen, shorterLen, longerLen, res, memo);
		recursiveMemo(k - 1, len + longerLen, shorterLen, longerLen, res, memo);
	}

	private static List<Integer> combinatoricsMtd(int k, int shorterLen, int longerLen) {
		List<Integer> res = new ArrayList<Integer>();
		for (int longer = 0; longer <= k; longer++) {
			res.add(longer * longerLen + (k - longer) * shorterLen);	
		}	
		return res;
	}
}


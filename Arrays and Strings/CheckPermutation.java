/*Given two strings, write a method to decide if one is a permutation of the
other.
 *
 * i/p:
 * String s1, String s2
 *
 * o/p:
 * boolean res
 *
 * mtd: (time) (space)
 * 1. Brute force - O(n^2) O(1)
 * 2. Sorting - O(nlogn) O(1)
 * 3. HashMap - O(n) O(n)
 *
*/

import java.io.*;
import java.util.*;

class CheckPermutation {
    public static void main(String args[]) {
		String s1 = "treau";
		String s2 = "eautr";
		System.out.println("CheckPermutation of " + s1 + " and " + s2 + ": " + checkPermutation(s1, s2));
    }

	private static boolean checkPermutation(String s1, String s2) {
		if (s1.length() != s2.length())	return false;

		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (char c : s1.toCharArray()) {
			if (!hm.containsKey(c))	hm.put(c, 1);
			hm.put(c, hm.get(c) + 1);
		}

		for (char c : s2.toCharArray()) {
			if (hm.get(c) < 1)	return false;
			hm.put(c, hm.get(c) - 1);	
		}

		return true;
	}
}


/*
 *There are three types of edits that can be performed on strings: insert a character, 
 *remove a character, or replace a character. 
 *Given two strings, write a function to check if they are one edit (or zero edits) away.
 *EXAMPLE
 *pale, ple -> true 
 *pales, pale -> true 
 *pale, bale -> true 
 *pale, bake -> false
 *
 *i/p:
 *String s1, String s2
 *
 *o/p:
 *boolean res
 *
 *Mtd:			Time			Space
 *Linear	O(min(m, n))	O(1)
 *
 *
 */

import java.io.*;
import java.util.*;

class OneAway {
    public static void main(String args[]) {
		String s1 = "ab", s2 = "ba";
		System.out.println("isOneAway(" + s1  + ", " + s2 + ") = " + isOneAway(s1, s2));
    }

	private static boolean isOneAway(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (m == n)		return s1.substring(i + 1).equals(s2.substring(i + 1));
				if (m + 1 == n)		return s1.substring(i + 1).equals(s2.substring(i + 1));
				if (m == n + 1)		return s1.substring(i).equals(s2.substring(i + 1));
			}	
		}
		return Math.abs(m - n) == -1;
	}
}


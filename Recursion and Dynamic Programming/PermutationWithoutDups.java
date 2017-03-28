/*
 *Write a method to compute all permutations of a string of unique characters.
 *
 *i/p:
 *String s of unique characters
 *
 *o/p:
 *List<String> res
 *
 *Mtd			Time	Space
 *Recursive			
 *
 *
*/




import java.io.*;
import java.util.*;

class PermutationWithoutDups {
    public static void main(String args[]) {
		String s = "abc";
		System.out.println(getPermutation(s));
    }

	private static List<String> getPermutation(String s) {
		List<String> res = new ArrayList<String>();
		recursiveHelper(res, "", s);
		return res;	
	}

	private static void recursiveHelper(List<String> res, String str, String s) {
		if (str.length() == s.length()) {
			res.add(str);
			return;	
		}	
		for (char c : s.toCharArray()) {
			if (!str.contains("" + c)) {
				str += c;
				recursiveHelper(res, str, s);	
				str = str.substring(0, str.length() - 1);
			}	
		}
	}
}


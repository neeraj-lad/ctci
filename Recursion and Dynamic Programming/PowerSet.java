/*
 *Write a method to return all subsets of a set.
 *
 *i/p:
 *Set<Character> set
 *
 *o/p:
 *List<Set<Character>> res
 *
 *Mtd			Time		Space
 *Brute force	O(2^n * n)	O(2 * 2^n)
 *Recursive		O(2^n * n)	O(n)	
 *
*/

import java.io.*;
import java.util.*;

class PowerSet {
    public static void main(String args[]) {
		Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'b', 'c'));
		System.out.println(set);
		System.out.println(getPowerSetBruteForce(set));
		System.out.println(getPowerSetRecursive(set));
    }

	private static List<Set<Character>> getPowerSetBruteForce(Set<Character> set) {
		List<Set<Character>> res = new ArrayList<Set<Character>>();
		int n = set.size();
		List<Character> elem = new ArrayList<Character>(set);

		for (int i = 0; i < Math.pow(2, n); i++) {
			addSet(res, elem, i); 	
		}
		return res;
	}

	private static void addSet(List<Set<Character>> res, List<Character> elem, int n) {
		Set<Character> hs = new HashSet<Character>();
		int idx = 0;
		while (n != 0) {
			if ((n & 1) == 1)	hs.add(elem.get(idx));
			idx++;
			n >>= 1;	
		}	
		res.add(hs);
	}

	private static List<Set<Character>> getPowerSetRecursive(Set<Character> set) {
		List<Set<Character>> res = new ArrayList<Set<Character>>();
		List<Character> elem = new ArrayList<Character>(set);
		recursiveHelper(res, new ArrayList<Character>(), elem, 0);	
		return res;
	}

	private static void recursiveHelper(List<Set<Character>> res, List<Character> al, List<Character> elem, int idx) {
		if (idx == elem.size())	{
			res.add(new HashSet<Character>(al));	
			return;
		}
		recursiveHelper(res, al, elem, idx + 1);
		al.add(elem.get(idx));
		recursiveHelper(res, al, elem, idx + 1);
		al.remove(al.size() - 1);	
	}
}


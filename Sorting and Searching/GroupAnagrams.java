/*
 *Write a method to sort an array of strings so that all the anagrams are next to each other.
 *
 *i/p:
 *List<String> al
 *
 *o/p:
 *void
 *
 *Mtd:		Time		Space
 *HashMap	O(n*mlogm)	O(n*m)		//n = number of strings, m = average length of the strings	
 */


import java.io.*;
import java.util.*;

class GroupAnagrams {
    public static void main(String args[]) {
		List<String> al = new ArrayList<String>();
		al.add("abcd");
		al.add("xyz");
		al.add("zxy");
		al.add("zyx");
		al.add("cdab");
		al.add("cdba");
		al.add("ab");
		al.add("a");
		groupAnagrams(al);
    }

	private static void groupAnagrams(List<String> al) {
		if (al == null)		return;

		System.out.println(al);
		Map<String, List<String>> hm = new HashMap<String, List<String>>();
		for (String s : al) {
			char[] cs = s.toCharArray();
			Arrays.sort(cs);
			String key = new String(cs);
			if (!hm.containsKey(key))	hm.put(key, new ArrayList<String>());
			hm.get(key).add(s);	
		}	

		al.clear();
		for (String key : hm.keySet())		al.addAll(hm.get(key));

		System.out.println(al);
	}
}


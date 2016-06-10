/*
i/p
s subset [ascii vals]
0 < len(s) < 10^6

o/p
true/false

**********************
1. Brute force: O(n^2) -
2. HashMap: O(n) O(n)
3. Set: O(n) O(n)
*/

import java.io.*;
import java.util.*;

class Test11
{

public static void main(String args[]) throws IOException 
{
    String s = "ha";
    System.out.println(mtd1(s));
    System.out.println(mtd2(s));
    System.out.println(mtd3(s));
}

static boolean mtd1(String s)
{
    for (int i = 0; i < s.length(); i++)
        for (int j = i+1; j < s.length(); j++)
            if (s.charAt(i) == s.charAt(j))
                return false;

    return true;
}

static boolean mtd2(String s)
{
    Map<Character, Integer> hm = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++)
        if (hm.get(s.charAt(i)) == null)
            hm.put(s.charAt(i), 1);
        else
            hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);

    for (Integer i : hm.values())
        if (i > 1)
            return false;

    return true;
}

static boolean mtd3(String s)
{
    Set<Character> st = new HashSet<Character>();
    for (int i = 0; i < s.length(); i++)
        st.add(s.charAt(i));

    return (s.length() == st.size());
}

}

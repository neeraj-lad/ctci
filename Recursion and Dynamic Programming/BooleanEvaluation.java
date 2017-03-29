/*
 *Given a boolean expression consisting of the symbols 0 (false), 1 (true), & (AND), | (OR), and ^ (XOR), and a desired boolean result value result, implement a function to count the number of ways of parenthesizing the expression such that it evaluates to result.
 *EXAMPLE
 *countEval("1^0|0|1", false) -> 2 
 *countEval("0&0&0&1^1|0", true) -> 10
 *
 *
 *i/p:
 *String exp, boolean val
 *
 *o/p:
 *int cnt
 *
 *
 *Mtd							Time	Space
 *Recursion with Memoization	
 *
*/

import java.io.*;
import java.util.*;

class BooleanEvaluation {
	static Map<String, Integer> hm = new HashMap<String, Integer>();

    public static void main(String args[]) {
		String exp = "0&0&0&1^1|0";
		boolean val = true;
		System.out.println(exp + ", " + val);
		System.out.println(getCount(exp, val));
    }

	private static int getCount(String exp, boolean val) {
		if (exp.length() == 0)	return 0;
		if (exp.length() == 1)	return ((exp.equals("1") && val) || (exp.equals("0") && !val)) ? 1 : 0;
		if (hm.containsKey(val + exp))	return hm.get(val + exp);

		int res = 0;
		for (int i = 1; i < exp.length(); i++) {
			String lExp = exp.substring(0, i);
			String rExp = exp.substring(i + 1);
			
			int lTrue = getCount(lExp, true);
			int lFalse = getCount(lExp, false);
			int rTrue = getCount(rExp, true);
			int rFalse = getCount(rExp, false); 
			int totCnt = (lTrue + lFalse) * (rTrue + rFalse);

			int cnt = 0;
			if (exp.charAt(i) == '^')	cnt += lTrue * rFalse + lFalse * rTrue;
			else if (exp.charAt(i) == '&')	cnt += lTrue * rTrue;
			else if (exp.charAt(i) == '|')	cnt += lTrue * rTrue + lTrue * rFalse + lFalse * rTrue;

			if (!val)	cnt = totCnt - cnt;

			res += cnt;
		}

		hm.put(val + exp, res);
		return res;	
	}
}


/*
 *English Int: Given any integer, print an English phrase that describes the integer 
 *(e.g., "One Thousand, Two Hundred Thirty Four").
 *
 *i/p:
 *int n
 *
 *o/p:
 *String res
 *
 *
 *Mtd			Time	Space
 *Iterative		O(1)	O(1)		//Time depends on number of digits which is constant (9 digits at worst)
 *									//No auxiliary space is used
 */


import java.io.*;
import java.util.*;

class EnglishInt {
	private static final String UNITS[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private static final String TENS[] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private static final String THOUSANDS[] = {"", "Thousand", "Million", "Billion"};
	private static final String HUNDRED = "Hundred";
	private static final String NEGATIVE = "Negative";
    
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter a number:");
		long n = Long.parseLong(br.readLine());
		System.out.println(getEnglishInt(n));
    }

	private static String getEnglishInt(long n) {
		if (n == 0)		return "Zero";
		if (n < 0) {
			return NEGATIVE + " " + getEnglishInt(n * -1);	
		}

		LinkedList<String> res = new LinkedList<String>();
		int cnt = 0;
		
		while (n > 0) {
			if (n % 1000 != 0) {
				String s = getString((int)(n % 1000)) + " " + THOUSANDS[cnt];
				res.addFirst(s);	
			}	
			n /= 1000;
			cnt++;
		}

		return llToString(res).trim();
	}

	private static String getString(int n) {
		LinkedList<String> res = new LinkedList<String>();
		
		if (n >= 100) {
			res.addLast(UNITS[n / 100] + " Hundred");
			n %= 100;	
		}	
		if (n >= 20) {
			res.addLast(TENS[n / 10]);
			n %= 10;	
		}
		if (1 <= n && n <= 19) {
			res.addLast(UNITS[n]);	
		}
		
		return llToString(res);
	}

	private static String llToString(LinkedList<String> ll) {
		if (ll.size() == 0)		return "";

		StringBuilder sb = new StringBuilder();
		
		while (ll.size() > 1) {
			sb.append(ll.pop());
			sb.append(" ");	
		}	
		sb.append(ll.pop());
		
		return sb.toString();
	}
}

/*
 *Write an algorithm which computes the number of trailing zeros in n factorial.
 *
 *i/p:
 *int n
 *
 *o/p:
 *int res
 *
 *Mtd			Time	Space
 *Iterative		O(n)	O(1)
 *Logarithmic	O(logn)	O(1)
 *
 */

import java.io.*;
import java.util.*;

class FactorialZeros {
    public static void main(String args[]) {
		int n = 125;
		System.out.println(iterativeMtd(n));
		System.out.println(logarithmicMtd(n));
    }

	private static int iterativeMtd(int n) {
		int res = 0;
		while (n >= 5) {
			res += powersOfFive(n--);	
		}	
		return res;
	}
	
	private static int powersOfFive(int n) {
		int res = 0;
		while (n % 5 == 0) {
			n /= 5;
			res++;
		}	
		return res;
	}

	private static int logarithmicMtd(int n) {
		int res = 0;
		int div = 5;
		while (n >= div) {
			res += n / div;
			div *= 5;	
		}	
		return res;
	}
}


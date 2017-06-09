/*Rand7 from RandS: Implement a method rand7() given rand5 (). 
 * That is, given a method that generates a random number between 0 and 4 (inclusive), 
 *write a method that generates a random number between 0 and 6 (inclusive).
 *
 *i/p:
 *None
 *
 *o/p:
 *A random int between 0 and 6 inclusive
 *
 *Mtd:
 *Form an eq using rand5(), which generates the range 0, 1, 2, ... such that *there are atleast 7 elements.
 *Non-deterministic time & constant space
 */

import java.io.*;
import java.util.*;

class Rand7FromRand5 {
    public static void main(String args[]) {
		System.out.println(nonDeterministicMtd());
    }

	private static int nonDeterministicMtd() {
		Random rand = new Random();
		while(true) {
			int res = 5 * rand.nextInt(5) + rand.nextInt(5);
			if (res < 21)	return res % 7;
		}	
	}
}


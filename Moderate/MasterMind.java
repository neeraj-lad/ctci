/*
 *The Game of Master Mind is played as follows:
 *The computer has four slots, and each slot will contain a ball that is red (R), 
 *yellow (V), green (G) or blue (B). For example, the computer might have RGGB 
 *(Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
 *You, the user, are trying to guess the solution.You might, for example, guess YRGB.
 *When you guess the correct color for the correct slot, you get a "hit:' 
 *If you guess a color that exists but is in the wrong slot, you get a "pseudo-hit:' 
 *Note that a slot that is a hit can never count as a pseudo-hit.
 *For exam ple, if the actual solution is RGBY and you guess GGRR, 
 *you have one hit and one pseudo -hit.
 *Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
 *
 *i/p:
 *String solution, String guess
 *
 *o/p:
 *Result(hits, pseudoHits) res
 *
 *Mtd:			Time	Space
 *Iterative		O(n)	O(1)
 *
 */

import java.io.*;
import java.util.*;



class MasterMind {
	private static final int MAX_COLORS = 4;

	static class Result {
		int hits, pseudoHits;
		
		public String toString() {
			return "Hits: " + hits + ", PseudoHits: " + pseudoHits;	
	}
}   

	public static void main(String args[]) {
		String solution = "RGBB";
		String guess = "YRGB";
		System.out.println("Solution: " + solution + ", Guess: " + guess);
		System.out.println(iterativeMtd(solution, guess));
    }

	private static int getCode(char c) {
		switch(c) {
			case 'R':	return 0;
			case 'Y':	return 1;
			case 'G':	return 2;
			case 'B':	return 3;
			default:	return -1;
		}	
	}

	private static Result iterativeMtd(String solution, String guess) {
		if (solution.length() != guess.length())	return null;

		Result res = new Result();
		
		int[] freq = new int[MAX_COLORS];
		for (int i = 0; i < solution.length(); i++) {
			if (solution.charAt(i) == guess.charAt(i))	res.hits++;	
			else	freq[getCode(solution.charAt(i))]++;
		}	

		for (int i = 0; i < guess.length(); i++) {
			if (solution.charAt(i) != guess.charAt(i)) {
				int code = getCode(guess.charAt(i));
				if (freq[code] > 0) {
					res.pseudoHits++;
					freq[code]--;	
				}	
			}	
		}
		
		return res;
	}
}


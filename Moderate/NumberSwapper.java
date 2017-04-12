/*
 *Write a function to swap a number in place (that is, without temporary variables).
 *
 *i/p:
 *None
 *
 *o/p:
 *None
 *
 *Mtd		Time	Space
 *Add		O(1)	O(1)
 *Multiply	O(1)	O(1)
 *XOR		O(1)	O(1)
 *
 */


import java.io.*;
import java.util.*;

class NumberSwapper {
    public static void main(String args[]) {
		addMtd();
		multiplyMtd();
		xorMtd();
    }

	private static void addMtd() {
		double a = 21.5, b = 3.05;
		System.out.println("a = " + a + " b = " + b);	
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + " b = " + b);	
	}

	private static void multiplyMtd() {
		double a = 21.5, b = 3.05;
		System.out.println("a = " + a + " b = " + b);	
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("a = " + a + " b = " + b);	
	}

	private static void xorMtd() {
		int a = 21, b = 3;
		System.out.println("a = " + a + " b = " + b);	
		a = (a ^ b);
		b = (a ^ b);
		a = (a ^ b);
		System.out.println("a = " + a + " b = " + b);	
	}
}


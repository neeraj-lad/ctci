/*
 *In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom (Le., each disk sits on top of an even larger one). You have the following constraints:
 *(1) Only one disk can be moved at a time.
 *(2) A disk is slid off the top of one tower onto another tower.
 *(3) A disk cannot be placed on top of a smaller disk.
 *Write a program to move the disks from the first tower to the last using stacks.
 *
 *
 *i/p:
 *int N
 *
 *o/p:
 *Representation of movement of disks
 *
 */


import java.io.*;
import java.util.*;

class TowersOfHanoi {
	static List<List<Integer>> towers = new ArrayList<List<Integer>>();
	static int N;
	static char map[] = {'A', 'B', 'C'};
    public static void main(String args[]) {
		towers.add(new ArrayList<Integer>());
		towers.add(new ArrayList<Integer>());
		towers.add(new ArrayList<Integer>());
		
		N = 3;
		for (int i = N; i >= 1; i--)	towers.get(0).add(i);
		
		printTowersOfHanoi();
		moveDisk(0, 2, 1, N);
    }

	private static void moveDisk(int source, int dest, int aux, int N) {
		if (N < 1)	return;
		
		moveDisk(source, aux, dest, N - 1);
		//move Nth disk from source to dest	using aux
		System.out.println("Moving disk " + N + " from " + map[source] + " to " + map[dest]);
		towers.get(source).remove(towers.get(source).size() - 1);
		towers.get(dest).add(N);
		printTowersOfHanoi();
		moveDisk(aux, dest, source, N - 1);
	}

	private static void printTowersOfHanoi() {
		int k = 0;
		for (List<Integer> tower : towers) {
			System.out.print(map[k++] + ": ");
			for (int disk : tower) 	System.out.print(disk + " ");
			System.out.println();
		}	
	}
}


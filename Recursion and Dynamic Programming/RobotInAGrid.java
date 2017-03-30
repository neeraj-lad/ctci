/*
 *Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
 *
 *i/p:
 *boolean[][] grid, Coord cur, List<Coord> path
 *
 *o/p:
 *boolean isPath
 *
 *Mtd		Time	Space
 *Recursion	?		O(1)
 *
 *
 */



import java.io.*;
import java.util.*;

class Coord {
	int r, c;

	Coord (int i, int j) {
		r = i;
		c = j;	
	}

	Coord getRightCell(int n) {
		if (c >= n - 1)	return null;
		return new Coord(r, c + 1);
	}

	Coord getDownCell(int m) {
		if (r >= m - 1)	return null;
		return new Coord(r + 1, c);	
	}

	@Override
	public String toString() {
		return "{" + r + ", " + c + "}";	
	}
}

class RobotInAGrid {
    public static void main(String args[]) {
		boolean[][] grid = {{true, true, true, false, false},
						{true, true, false, false, false},
						{true, true, true, true, false},
						{true, false, true, false, true},
						{true, true, true, true, true}
						};
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print((grid[i][j]) ? "_" : "#");	
			}	
			System.out.println();
		}

		List<Coord> res = new ArrayList<Coord>();
		if (getPath(grid, new Coord(0, 0), res))	System.out.println(res);
    }

	private static boolean getPath(boolean[][] grid, Coord cur, List<Coord> path) {
		if (!grid[cur.r][cur.c])	return false;
		if (cur.r == grid.length - 1 && cur.c == grid[0].length - 1) {
			path.add(cur);
			return true;	
		}	

		path.add(cur);
		Coord right = cur.getRightCell(grid[0].length);
		Coord down = cur.getDownCell(grid.length);
		if (right != null && getPath(grid, right, path))	return true;
		if (down != null && getPath(grid, down, path))	return true;

		path.remove(path.size() - 1);
		return false;
	}
}


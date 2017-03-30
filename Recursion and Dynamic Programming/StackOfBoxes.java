/*
 *You have a stack of n boxes, with widths Wi' heights hi' and depths di.The boxes cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly larger than the box above it in width, height, and depth. Implement a method to compute the height of the tallest possible stack.The height of a stack is the sum of the heights of each box.
 *
 *i/p:
 *List<Box>
 *
 *o/p:
 *int height
 *
 *Mtd		Time	Space
 *Top-down	O(n^2)	O(n)
 *Bottom-up	O(n^2)	O(n)
 *
 */


import java.io.*;
import java.util.*;

class Box {
	int width;
	int height;
	int depth;

	Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;	
	}

	boolean canHold(Box b) {
		return (width > b.width && height > b.height && depth > b.depth);	
	}

	@Override
	public String toString() {
		return "(" + width + ", " + height + ", " + depth + ")";	
	}
}

class BoxComparator implements Comparator<Box> {
	@Override
	public int compare(Box a, Box b) {
		if (a.width > b.width && a.height > b.height && a.depth > b.depth)	return 1;
		else if (b.width > a.width && b.height > a.height && b.depth > a.depth)	return -1;
		else if (a.width != b.width)	return b.width - a.width;
		else if (a.height != b.height)	return b.height - a.height;
		else	return b.depth - a.depth;
	}	
}

class StackOfBoxes {
    public static void main(String args[]) {
		List<Box> al = new ArrayList<Box>();
		al.add(new Box(3, 2, 1));
		al.add(new Box(5, 8, 9));
		al.add(new Box(5, 4, 6));
		al.add(new Box(1, 1, 1));
		al.add(new Box(10, 10, 12));
		
		Collections.sort(al, new BoxComparator());

		System.out.println(getHeight(al));
    }

	private static int getHeight(List<Box> al) {
		int n = al.size();		
		int dp[] = new int[n];
		for (int i = 0; i < n; i++)	dp[i] = al.get(i).height;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if	(al.get(i).canHold(al.get(j))) {
					dp[i] = Math.max(dp[i], al.get(i).height + dp[j]);	
				}	
			}	
		}

		int res = 0;
		for (int i : dp)	res = Math.max(res, i);

		return res;	
	}
}


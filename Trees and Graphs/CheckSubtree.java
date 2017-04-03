/*
 *T l and T2 are two very large binary trees, with T l much bigger than T2. 
 *Create an algorithm to determine if T2 is a subtree of Tl.
 *A tree T2 is a subtree ofT i if there exists a node n in T i such that the subtree of n is identical to T2. 
 *That is, if you cut off the tree at node n, the two trees would be identical.
 *
 *i/p:
 *Node a, Node b
 *
 *o/p:
 *boolean res
 *
 *
 * Mtd					Time		Space
 *Preorder Substring	O(m + n)	O(m + n)
 *
 *Direct comparison		O(m * n)	O(log(m) + log(n))
 *
 */

import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left, right;

	Node (int d) {
		data = d;	
	}
}

class BT {
	Node root;

	String printPreorder(Node root) {
		StringBuilder sb = new StringBuilder();
		printPreorderHelper(root, sb);
		return sb.toString();
	}

	private void printPreorderHelper(Node root, StringBuilder sb) {
		if (root == null) {
			sb.append("X ");
			return;	
		}	
		sb.append(root.data + " ");
		printPreorderHelper(root.left, sb);
		printPreorderHelper(root.right, sb);
	}

	boolean isSubtreeSubstring(Node a, Node b) {
		String as = printPreorder(a);
		String bs = printPreorder(b);
		return (as.indexOf(bs) != -1);	
	}

	boolean isSubtreeRecursive(Node a, Node b) {
		if (b == null)	return true;
		if (a == null)	return false;

		if (a.data == b.data && isSubtreeRecursiveHelper(a, b))		return true;

		return (isSubtreeRecursive(a.left, b) || isSubtreeRecursive(a.right, b));
	}

	private boolean isSubtreeRecursiveHelper(Node a, Node b) {
		if (a == null && b == null)		return true;
		if (a == null || b == null)		return true;
		if (a.data != b.data)	return false;
		return (isSubtreeRecursiveHelper(a.left, b.left) && isSubtreeRecursiveHelper(a.right, b.right));	
	}
}

class CheckSubtree {
    public static void main(String args[]) {
		BT bt = new BT();
		bt.root = new Node(10);
		bt.root.left = new Node(9);
		bt.root.right = new Node(8);
		bt.root.left.left = new Node(7);
		bt.root.left.right = new Node(6);
		bt.root.right.right = new Node(5);
		bt.root.left.right.left = new Node(3);
		bt.root.left.right.right = new Node(4);

		System.out.println(bt.printPreorder(bt.root));

		Node a = bt.root;
		Node b = bt.root.left.right;

		System.out.println(bt.isSubtreeSubstring(a, b));
		System.out.println(bt.isSubtreeRecursive(a, b));
    }
}


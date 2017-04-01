/*
 *Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 *Avoid storing additional nodes in a data structure. 
 *NOTE: This is not necessarily a binary search tree.
 *
 *i/p:
 *Node root, Node a, Node b
 *
 *o/p:
 *Node res
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

	void printInorder() {
		printInorderHelper(root);		
		System.out.println();
	}

	private void printInorderHelper(Node root) {
		if (root == null)	return;
		printInorderHelper(root.left);
		System.out.print(root.data + " ");
		printInorderHelper(root.right);	
	}

	Node getFirstCommonAncestor(Node a, Node b) {
		return getFirstCommonAncestorHelper(root, a, b);	
	}

	private Node getFirstCommonAncestorHelper(Node root, Node a, Node b) {
		if (root == null)	return null;
		if (root == a)	return a;
		if (root == b)	return b;

		Node leftVal = getFirstCommonAncestorHelper(root.left, a, b);
		Node rightVal = getFirstCommonAncestorHelper(root.right, a, b);

		if (leftVal == null && rightVal == null)	return null;
		if (leftVal != null && rightVal != null)	return root;
		return (leftVal != null) ? leftVal : rightVal;	
	}
}

class FirstCommonAncestor {
    public static void main(String args[]) {
		BT bt = new BT();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(30);
		bt.root.left.left = new Node(40);
		bt.root.left.right = new Node(50);
		bt.root.right.right = new Node(60);
		bt.root.left.right.right = new Node(70);

		bt.printInorder();

		Node a = bt.root.left.left;
		Node b = bt.root.left.right.right;
		Node fca = bt.getFirstCommonAncestor(a, b);
		System.out.println("FirstCommonAncestor of " + a.data + " and " + b.data + " is: " + fca.data);
    }
}


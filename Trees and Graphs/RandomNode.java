/*
 *You are implementing a binary tree class from scratch which, in addition to insert, find, and delete, 
 *has a method getRandomNode() which returns a random node from the tree. 
 *All nodes should be equally likely to be chosen. Design and implement an algorithm for getRandomNode, 
 *and explain how you would implement the rest of the methods.
 *
 *i/p:
 *int randomNo
 *
 *o/p:
 *Node res
 *
 *Mtd			Time	Space
 *Store size	O(D)	O(D)		//D = depth
 *
 */

import java.io.*;
import java.util.*;

class Node {
	int data, size;
	Node left, right;

	Node (int d) {
		data = d;
		size = 1;	
	}
}

class BT {
	Node root;

	Node addInorder(int d) {
		return addInorderHelper(root, d);	
	}

	private Node addInorderHelper(Node root, int d) {
		if (root == null) {
			root = new Node(d);
			return root;
		}	
		if (root.data < d) {
			root.right = addInorderHelper(root.right, d);	
		}
		else {
			root.left = addInorderHelper(root.left, d);
		}
		root.size++;
		return root;
	}

	Node find(int d) {
		return findHelper(root, d);	
	}
	
	private Node findHelper(Node root, int d) {
		if (root == null)	return null;
		if (root.data == d)	return root;
		if (root.data > d)	return findHelper(root.left, d);
		return findHelper(root.right, d);
	}

	Node getRandomNode() {
		Random rand = new Random();
		int r = rand.nextInt(root.size);

		return getRandomNodeHelper(root, r);
	}

	private Node getRandomNodeHelper(Node root, int r) {
		int leftSize = (root.left == null) ? 0 : root.left.size;
		if (r < leftSize)	return getRandomNodeHelper(root.left, r);
		else if (r == leftSize)	return root;
		else	return getRandomNodeHelper(root.right, r - leftSize - 1);	
	}
}

class RandomNode {
    public static void main(String args[]) {
		BT bt = new BT();
		bt.root = bt.addInorder(20);
		bt.root = bt.addInorder(10);
		bt.root = bt.addInorder(5);
		bt.root = bt.addInorder(2);
		bt.root = bt.addInorder(12);
		bt.root = bt.addInorder(13);
		bt.root = bt.addInorder(50);
		bt.root = bt.addInorder(30);
		bt.root = bt.addInorder(25);
		bt.root = bt.addInorder(35);
		bt.root = bt.addInorder(60);
		bt.root = bt.addInorder(70);

		Node rand = bt.getRandomNode();
		System.out.println(rand.data);
    }
}


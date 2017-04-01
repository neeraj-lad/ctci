/*
 *A binary search tree was created by traversing through an array from left to right and inserting each element. 
 *Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
 *
 *i/p:
 *Node root
 *
 *o/p:
 *List<List<Integer>> res
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

class BST {
	Node root;

	void add(int v) {
		root = addHelper(root, v);		
	}

	private Node addHelper(Node root, int v) {
		if (root == null) {
			root = new Node(v);
			return root;	
		}	
		if (root.data < v) {
			root.right = addHelper(root.right, v);	
		}
		else {
			root.left = addHelper(root.left, v);	
		}
		return root;
	}

	List<LinkedList<Integer>> getBSTSequences() {
		return getBSTSequencesHelper(root);
	}

	private List<LinkedList<Integer>> getBSTSequencesHelper(Node root) {
		List<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>();
		if (root == null) {
			res.add(new LinkedList<Integer>());
			return res;	
		}	

		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.addLast(root.data);

		List<LinkedList<Integer>> left = getBSTSequencesHelper(root.left);
		List<LinkedList<Integer>> right = getBSTSequencesHelper(root.right);

		for (LinkedList<Integer> l : left) {
			for (LinkedList<Integer> r : right) {
				List<LinkedList<Integer>> temp = new ArrayList<LinkedList<Integer>>();
				weave(l, r, prefix, temp);
				res.addAll(temp);	
			}	
		}

		return res;
	}

	private void weave(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix, List<LinkedList<Integer>> res) {
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> t = new LinkedList<Integer>(prefix);
			t.addAll(first);
			t.addAll(second);
			res.add(t);
			return;	
		}	

		int v = first.removeFirst();
		prefix.addLast(v);
		weave(first, second, prefix, res);
		prefix.removeLast();
		first.addFirst(v);

		v = second.removeFirst();
		prefix.addLast(v);
		weave(first, second, prefix, res);
		prefix.removeLast();
		second.addFirst(v);
	}

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
}

class BSTSequences {
    public static void main(String args[]) {
		BST bst = new BST();
		bst.add(3);
		bst.add(1);
		bst.add(2);
		bst.add(4);
		bst.add(5);
		bst.printInorder();

		System.out.println(bst.getBSTSequences());
    }
}


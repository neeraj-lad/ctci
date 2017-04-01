/*
 * Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 *
 *i/p:
 *none
 *
 *o/p:
 *boolean res
 *
 *Mtd			Time	Space
 *Brute force	O(n^2)	O(n)
 *Optimized		O(n)	O(n)
 *
 */
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left, right;

    Node(int d)
    {
        data = d; 
    }
}

class BT
{
    Node root;

    void levelOrderTraversal()
    {
		System.out.println("Level Order Traversal:\n{");
        if (root == null)
        {
            System.out.println("}");
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
		
        while (!q.isEmpty())
        {
			int num = q.size();

			System.out.print("[");
			while (num-- > 0) {
				Node n = q.poll();
				System.out.print(n.data + ", ");

				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
		
			}
			System.out.println("]");
        }
		System.out.println("}");
        
    }

    int height(Node root)
    {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    boolean isBalancedBruteForce(Node root)
    {
        if (root == null)
            return true;

        return (Math.abs(height(root.left) - height(root.right)) < 2 && isBalancedBruteForce(root.left) && isBalancedBruteForce(root.right));
    }

	boolean isBalancedOptimized() {
		return (isBalancedOptimizedHelper(root) != -1);	
	}

	int isBalancedOptimizedHelper(Node root) {
		if (root == null)	return 0;
		
		int leftHeight = isBalancedOptimizedHelper(root.left);
		int rightHeight = isBalancedOptimizedHelper(root.right);
	
		//Check if either subtree is imbalanced	
		if (leftHeight == -1 || rightHeight == -1)	return -1;
		//Check if the current tree is imbalanced
		if (Math.abs(leftHeight - rightHeight) > 1)	return -1;

		return 1 + Math.max(leftHeight, rightHeight);	
	}
}

class CheckBalanced
{
    public static void main(String args[])throws IOException
    {
       BT bt = new BT();
       bt.root = new Node(10);
       bt.root.left = new Node(11);
       bt.root.right = new Node(7);
       bt.root.right.right = new Node(6);
//	   bt.root.right.right.right = new Node(8);

       bt.levelOrderTraversal();
       
       if (bt.isBalancedBruteForce(bt.root))
           System.out.println("BT is balanced.");
       else
           System.out.println("BT is not balanced.");

	   if (bt.isBalancedOptimized())
           System.out.println("BT is balanced.");
       else
           System.out.println("BT is not balanced.");


    }
}


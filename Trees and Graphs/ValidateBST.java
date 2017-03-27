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

class BST
{
    Node root;

    Node insert(Node root, int data)
    {
        if (root == null)
            return new Node(data);
        else
        {
            if (root.data > data)
                root.left = insert(root.left, data);
            else
                root.right = insert(root.right, data);
        }
        return root;
    }

    void inorderTraversal(Node root)
    {
        if (root != null)
        {
            inorderTraversal(root.left);
            System.out.print(root.data + " "); 
            inorderTraversal(root.right);
        }
    }

    boolean isBST(Node root, int min, int max)
    {
        if (root == null)
            return true;

        if (root.data < min || root.data > max)
            return false;

        return (isBST(root.left, min, root.data-1) && isBST(root.right, root.data+1, max));
    }
}

class ValidateBST
{
    public static void main(String args[])throws IOException
    {
       BST bst = new BST();
       bst.root = bst.insert(bst.root, 20);
       bst.root = bst.insert(bst.root, 10);
       bst.root = bst.insert(bst.root, 13);
       bst.root = bst.insert(bst.root, 23);
       bst.root = bst.insert(bst.root, 38);
       bst.root.right.right.right = new Node(15);

       bst.inorderTraversal(bst.root);
       System.out.println();

       if (bst.isBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.println("Given tree is a BST");
       else
            System.out.println("Given tree is not a BST");
    }
}


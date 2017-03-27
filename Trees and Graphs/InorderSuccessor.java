import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left, right, parent;

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
            Node t;
            if (root.data > data)
            {
                t = insert(root.left, data);
                t.parent = root;
                root.left = t;
            }
            else
            if (root.data < data)
            {
                t = insert(root.right, data);
                t.parent = root;
                root.right = t;
            }
            return root;
        }
    }

    Node search(Node root, int data)
    {
        if (root == null)
            return null;

        if (root.data == data)
            return root;

        if (root.data > data)
            return search(root.left, data);
        else
        if (root.data < data)
            return search(root.right, data);

        return null;
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

    Node minNode(Node n)
    {
        Node t = n;
        while (t.left != null)
            t = t.left;
        return t;
    }

    Node inorderSuccessor(Node n)
    {
        if (n == null)
            return null;
        if (n.right != null)
            return minNode(n.right);
        else
        {
            Node p = n.parent;
            while (p != null && n == p.right)
            {
                n = p;
                p = p.parent;
            }
            return p;
        }
    }
}

class InorderSuccessor
{
    public static void main(String args[])throws IOException
    {
       BST bst = new BST();
       bst.root = bst.insert(bst.root, 20);
       bst.root = bst.insert(bst.root, 10);
       bst.root = bst.insert(bst.root, 23);
       bst.root = bst.insert(bst.root, 38);
       bst.root = bst.insert(bst.root, 17);
       bst.root = bst.insert(bst.root, 9);
       bst.root = bst.insert(bst.root, 25);
       bst.root = bst.insert(bst.root, 2);

       bst.inorderTraversal(bst.root);
       System.out.println();

       Node t = bst.search(bst.root, 2);

       Node s = bst.inorderSuccessor(t);  
       if (s != null)
           System.out.println("Inorder Successor of " + t.data + " is: " + s.data);
       else
           System.out.println("Inorder Successor of " + t.data + " does not exist");
    }
}


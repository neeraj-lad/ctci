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

    Node arrToBST(int a[], int start, int end)
    {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
    
        Node root = new Node(a[mid]);

        root.left = arrToBST(a, start, mid-1);
        root.right = arrToBST(a, mid+1, end);

        return root;
    }

    void inorderTraversal()
    {
        if (root == null)
        {
            System.out.println("[]");
            return;
        }
        
        Node t = root;
        Stack<Node> st = new Stack<Node>();
        while (true)
        {
            while (t != null)
            {
                st.push(t);
                t = t.left;
            }
            if (st.isEmpty())
                break;
            t = st.pop();
            System.out.print(t.data + " ");
            t = t.right;
        }
        System.out.println();
    }
}

class Test43
{
    public static void main(String args[])throws IOException
    {
       int a[] = {1, 3, 8, 13, 20, 33, 59, 88}; 
       BST bst = new BST();
       bst.root = bst.arrToBST(a, 0, a.length-1);
       bst.inorderTraversal();
    }
}


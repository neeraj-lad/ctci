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
        if (root == null)
        {
            System.out.println("[]");
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty())
        {
            Node n = q.poll();
            System.out.println(n.data);

            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
        }
        
    }

    int height(Node root)
    {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    boolean isBalanced(Node root)
    {
        if (root == null)
            return true;

        return (Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right));
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
//       bt.root.right.right.right = new Node(8);

       bt.levelOrderTraversal();
       
       if (bt.isBalanced(bt.root))
           System.out.println("BT is balanced.");
       else
           System.out.println("BT is not balanced.");

    }
}


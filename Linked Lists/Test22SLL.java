/*
TC: O(n)
SC: -
*/

import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        next = null;
    }
}

class SLL
{
    Node head;

    SLL()
    {
        head = null; 
    }

    void append(int data)
    {
        Node n = new Node(data);
        if (head == null)
            head = n;
        else
        if (head.next == null)
            head.next = n;
        else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = n;
        }
    }

    public String toString()
    {
        String res = "[";
        if (head == null)
            res += "]";
        else
        if (head.next == null)
            res += head.data + "]";
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                res += temp.data + ", ";
                temp = temp.next;
            }
            res += temp.data + "]";
        }

        return res;
    }

    int getLength()
    {
        int len = 0;
        Node temp = head;
        
        while (temp != null)
        {
            len++;
            temp = temp.next;
        }
        return len;
    }

    int getKToLast(int k)
    {
        int len = getLength();
        
        if (k >= len || k < 0)
            return -1;
        int diff = len - k - 1;

        Node temp = head;
        while (diff-- > 0)
            temp = temp.next;

        return temp.data;
    }
}

class Test22SLL
{
    public static void main(String args[])throws IOException
    {
       SLL sll = new SLL();

       sll.append(10);
       sll.append(20);
       sll.append(30);
       sll.append(40);
       sll.append(50);
       sll.append(60);
       sll.append(70);
       sll.append(80);
       sll.append(90);
       sll.append(100);

       System.out.println(sll.getKToLast(3));
    }
}


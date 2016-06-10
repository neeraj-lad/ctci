/*-----------------------
TC:O(n^3)
SC:-
-------------------------*/

import java.io.*;

class Node 
{
    int data;
    Node next;

    Node (int data)
    {
        this.data = data;
        next = null;
    }
}

class SLL 
{
    Node head;

    SLL ()
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
        String res = "";
        res += "[";
        if (head == null)
        {
            res += "]";
        }
        else
        if (head.next == null)
        {
            res += head.data + "]";
        }
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

    void removeDuplicate()
    {
        if (head == null || head.next == null)
            return;

        Node i, j, k;
        i = head;

        while (i != null)
        {
            j = i.next;
            while (j != null)
            {
                if (i != j && i.data == j.data)
                {
                    k = head;
                    while (k.next != j)
                        k = k.next;

                    k.next = j.next;
                }
                    j = j.next;
            }

            i = i.next;
        }
    }
}

class Test11SLLA
{
    public static void main(String args[])throws IOException
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       SLL sll = new SLL();

       sll.append(10);
       sll.append(20);
       sll.append(10);
       sll.append(30);
       sll.append(10);
       sll.append(20);
       sll.append(40);
       sll.append(10);

       System.out.println(sll.toString());

       sll.removeDuplicate();

       System.out.println(sll.toString());
    }
}


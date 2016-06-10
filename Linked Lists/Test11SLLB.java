import java.io.*;
import java.util.*;

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
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        Node temp = head;
        while (temp != null)
        {
            int key = temp.data;
            if (hm.get(key) == null)
                hm.put(key, 1);
            else
                hm.put(key, hm.get(key)+1);

            temp = temp.next;
        }
        
        temp = head;
        while (temp != null)
        {
            int key = temp.data;
            if (hm.get(key) > 1)
            {
                if (head == temp)
                {
                    head = temp.next;
                }
                else
                {
                    Node t = head;
                    while (t.next != temp)
                        t = t.next;
                    t.next = temp.next;
                }
                hm.put(key, hm.get(key)-1);
            }
            
            temp = temp.next; 
        }

    }
}

class Test11SLLB
{
    public static void main(String args[])throws IOException
    {
       SLL sll = new SLL();

       sll.append(10);
       sll.append(20);
       sll.append(30);
       sll.append(10);
       sll.append(40);
       sll.append(10);
       sll.append(20);
       sll.append(10);

      System.out.println(sll.toString());

       sll.removeDuplicate();
       
       System.out.println(sll.toString());
    }
}


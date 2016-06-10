import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    Node prev;

    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}

class DLL
{
    Node head;
    Node tail;

    DLL()
    {
        head = tail = null; 
    }

    void append(int data)
    {
        Node n = new Node(data);

        if (head == null && tail == null)
            head = tail = n;
        else
        if (head == tail)
        {
            head.next = tail = n;
            n.prev = head;
        }
        else
        {
            Node temp = head;
            while (temp != tail)
                temp = temp.next;

            temp.next = tail = n;
            n.prev = temp;
        }
    }

    public String toString()
    {
        String res = "[";
        if (head == null && tail == null)
            res += "]";
        else
        if (head == tail)
            res += head.data + "]";
        else
        {
            Node temp = head;
            while (temp != tail)
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
                if (temp == head)
                {
                    head = head.next;
                    head.prev = null;
                    if (tail == temp)
                        tail = temp.next;
                }
                else
                if (temp == tail)
                {
                    tail = tail.prev;
                    tail.next = null;
                    if (head == temp)
                        head = temp.prev;
                }
                else
                {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                
                hm.put(key, hm.get(key)-1);
            }
            temp = temp.next;
        }
    }
}

class Test11DLLB
{
    public static void main(String args[])throws IOException
    {
       DLL dll = new DLL();

       dll.append(10);
       dll.append(20);
       dll.append(50);
       dll.append(10);
       dll.append(40);
       dll.append(20);
       dll.append(10);

       System.out.println(dll.toString());

       dll.removeDuplicate();

       System.out.println(dll.toString());
    }
}


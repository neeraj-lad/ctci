import java.io.*;

class Node
{
    int data;
    Node next, prev;

    Node(int d)
    {
        data = d; 
    }
}

class DLL
{
    Node head, tail;
    int size;

    DLL()
    {
        size = 0; 
    }

    void add(int data)
    {
        Node n = new Node(data);
        
        if (head == null)
            head = tail = n;
        else
        {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public String toString()
    {
        String res = "[";

        if (head == null)
            res += "]";
        else
        {
            Node t = head;
            while (t.next != null)
            {
                res += t.data + ", ";
                t = t.next;
            }
            res += t.data + "]";
        }
        return res;
    }

    DLL addDLL(DLL dll)
    {
        while(size < dll.size)
            add(0);
        while (dll.size < size)
            dll.add(0);

        DLL res = new DLL();
        Node t1 = tail, t2 = dll.tail;
        int sum, carry = 0;
        
        while (t1 != null && t2 != null)
        {
            sum = t1.data + t2.data;

            res.add((sum + carry) % 10);

            carry = (sum + carry) / 10;

            t1 = t1.prev;
            t2 = t2.prev;
        }

        if (carry > 0)
        {
            res.add(carry % 10);
            carry /= 10;
        }

        return res;
    }
}

class Test25DLL
{
    public static void main(String args[])throws IOException
    {
       DLL dll1 = new DLL();
       dll1.add(7);
       dll1.add(1);
       dll1.add(6);

       DLL dll2 = new DLL();
       dll2.add(5);
       dll2.add(9);
       dll2.add(2);

       DLL dll3 = dll1.addDLL(dll2);

       System.out.println(dll1.toString());
       System.out.println(dll2.toString());
       System.out.println(dll3.toString());
    }
}


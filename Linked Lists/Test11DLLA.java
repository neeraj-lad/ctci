import java.io.*;

class Node 
{
    int data;
    Node next;
    Node prev;

    Node (int data)
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
        Node i, j; 
        i = head;
        while (i != null)
        {
            j = i.next;
            while (j != null)
            {
                if (i != j && i.data == j.data)
                {
                    if (j == head)
                    {
                        head = head.next;
                        head.prev = null;
                    }
                    else
                    if (j == tail)
                    {
                        tail = tail.prev;
                        tail.next = null;
                    }
                    else
                    {
                        j.prev.next = j.next;
                        j.next.prev = j.prev;
                    }
                }
                j = j.next;
            }
            
            i = i.next;
        }
    }
}

class Test11DLLA
{
    public static void main(String args[])throws IOException
    {
       DLL dll = new DLL();

       dll.append(10);
       dll.append(20);
       dll.append(10);
       dll.append(30);
       dll.append(40);
       dll.append(10);
       dll.append(20);

       System.out.println(dll.toString());

       dll.removeDuplicate();

       System.out.println(dll.toString());
    }
}


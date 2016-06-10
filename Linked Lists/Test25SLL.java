import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d; 
    }
}

class SLL
{
    Node head;
    int size;

    SLL()
    {
        size = 0; 
    }

    void append(int data)
    {
        Node n = new Node(data);

        if (head == null)
            head = n;
        else
        {
            Node t = head;
            while (t.next != null)
                t = t.next;
            t.next = n;
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

    SLL addSLL(SLL sll)
    {
        while (size < sll.size)
            append(0);
        while (sll.size < size)
            sll.append(0);

        SLL res = new SLL();
        int carry = 0, sum;
        Node h1 = head, h2 = sll.head;

        while (h1 != null && h2 != null)
        {
            sum = h1.data + h2.data;

            res.append((sum + carry) % 10);

            carry = (sum + carry) / 10;

            h1 = h1.next;
            h2 = h2.next;
        }

        if (carry > 0)
        {
            res.append(carry % 10);
            carry /= 10;
        }

        return res;
    }
}

class Test25SLL
{
    public static void main(String args[])throws IOException
    {
       SLL sll1 = new SLL();
       sll1.append(7);
       sll1.append(1);
       sll1.append(6);

       SLL sll2 = new SLL();
       sll2.append(5);
       sll2.append(9);
       sll2.append(2);

       SLL sll3 = sll1.addSLL(sll2);

       System.out.println(sll1.toString());
       System.out.println(sll2.toString());
       System.out.println(sll3.toString());
    }
}


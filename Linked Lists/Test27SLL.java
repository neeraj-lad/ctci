import java.io.*;

class Node
{
    char c;
    Node next;

    Node(char c)
    {
        this.c = c; 
    }
}

class SLL
{
    Node head;

    void add(char c)
    {
        Node n = new Node(c);

        if (head == null)
            head = n;
        else
        {
            n.next = head;
            head = n;
        }
    }

    public String toString()
    {
        String res = "[";
        if (head != null)
        {
            Node t = head;
            while (t.next != null)
            {
                res += t.c + ", "; 
                t = t.next;
            }
            res += t.c;
        }
        res += "]";
        return res;
    }

    void checkPalindrome()
    {
        StringBuilder sb = new StringBuilder();

        Node t = head;
        while (t != null)
        {
            sb.append(t.c);
            t = t.next;
        }

        StringBuilder rb = new StringBuilder(sb).reverse();

        if (sb.toString().equals(rb.toString()))
            System.out.println(sb + " is a Palindrome");
        else
            System.out.println(sb + " is not a Palindrome");
    }
}

class Test27SLL
{
    public static void main(String args[])throws IOException
    {
       SLL sll = new SLL();
       sll.add('d');
       sll.add('a');
       sll.add('y');
       sll.add('a');
       sll.add('d');

       System.out.println(sll.toString());

       sll.checkPalindrome();
    }
}


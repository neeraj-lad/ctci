import java.io.*;

class Node
{
    char data;
    Node next, prev;

    Node(char c)
    {
        data = c; 
    }
}

class DLL
{
    Node head, tail;

    void add(char c)
    {
        Node n = new Node(c);

        if (head == null)
            head = tail = n;
        else
        {
            n.next = head;
            head.prev = n;
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
                res += t.data + ", ";
                t = t.next; 
            }
            res += t.data;
        }
        res += "]";

        return res;
    }

    void checkPalindrome()
    {
        boolean flag = true;
        if (head != null)
        {
            Node t1 = head, t2 = tail;
            while (t1 != t2)
            {
               if (t1.data != t2.data)
               {
                    flag = false;
                    break;
               }
               else
               {
                    t1 = t1.next;
                    t2 = t2.prev;
               }
            }
        }

        if (flag)
            System.out.println(toString() + " is a palindrome");
        else
            System.out.println(toString() + " is not a palindrome");
    }

    void checkPalindromeRecursive(Node t1, Node t2)
    {
        if ((t1 == null && t2 == null) || (t1 == t2))
        {
            System.out.println(toString() + " is a palindrome[Recursive]");
        }
        else
        {
            t1 = t1.next;
            t2 = t2.prev;
            checkPalindromeRecursive(t1, t2);
        }
    }
}

class Test27DLL
{
    public static void main(String args[])throws IOException
    {
       DLL dll = new DLL();
       dll.add('d');
       dll.add('a');
       dll.add('y');
       dll.add('a');
       dll.add('d');

       System.out.println(dll.toString());
       dll.checkPalindrome();
       dll.checkPalindromeRecursive(dll.head, dll.tail);
//       System.out.println("Is a Palindrome?: " + dll.checkPalindromeRecursive(dll.head, dll.tail));
    }
}


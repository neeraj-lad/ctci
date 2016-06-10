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

    Node getReference(int data)
    {
        Node temp = head;
        
        while (temp != null && temp.data != data)
            temp = temp.next;
        
        return temp;
    }

    void deleteUsingReference(Node ref)
    {
        Node temp = head;

        while (temp != null)
        {
            if (temp.next == ref || temp == ref)
                break;
            temp = temp.next;
        }

        
        if (temp == null)
            return;

        if (temp == ref)
        {
            head = temp = null;
        }
        else
        {
            temp.next = ref.next;
        }
    }
}

class Test23SLL
{
    public static void main(String args[])throws IOException
    {
       SLL sll = new SLL();

       sll.append(10);
       sll.append(20);
       sll.append(30);
       sll.append(40);
       sll.append(50);

       System.out.println(sll.toString());

       Node ref = sll.getReference(30);

       sll.deleteUsingReference(ref);

       System.out.println(sll.toString());
    }
}


/*
 *Write a method to replace all spaces in a string with '%20: You may assume that the string has sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 *EXAMPLE
 *Input: "Mr John Smith " J 13 
 *Output: "Mr%20J ohn%20Smith"
 *
 *i/p:
 *String s
 *
 *o/p:
 *void
 *
 *
 *
 */

import java.io.*;

class URLify
{
    public static void main(String args[])throws IOException
    {
       String s = "Mr John Smith    ";
       char cs[] = s.toCharArray();

       int i = cs.length-1;
       int j = i;

       int c = 0, l = 0;
       while (i >= 0)
       {
           if (j >= 0 && cs[j] == ' ')
                while (j >= 0 && cs[j] == ' ')
                {
                    j--;
                }
           else
               while (j >= 0 && cs[j] == '0' || cs[j] == '2' || cs[j] == '%')
                   j--;

            while (j >= 0 && cs[j] != ' ')
            {
                cs[i--] = cs[j--]; 
            }

            if (j >= 0 && cs[j] == ' ')
            {
                cs[i--] = '0';
                cs[i--] = '2';
                cs[i--] = '%';
            }

       }
            print(cs);
}

    static void print(char c[])
    {
        for (int k = 0; k < c.length; k++)
           System.out.print(c[k]);
        System.out.println();
   
    }
}


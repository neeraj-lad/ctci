import java.io.*;

class Test14
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


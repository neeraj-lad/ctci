import java.io.*;

class Test15
{
    public static void main(String args[])throws IOException
    {
        String s = "aaabccccdeeaabb";
        System.out.println("Original string is:   " + s);
        System.out.println("Compressed string is: " + compressStr(s));
    }

    static String compressStr(String s)
    {
        String res = new String();

        for (int i = 0; i < s.length(); i++)
        {
            int c, j;
            c = 0;
            j = i+1;

            while (j < s.length() && s.charAt(i) == s.charAt(j))
            {
                c++;
                j++;
            }
            c++;

            res += s.charAt(i);
            res += c;
            i = j-1;
        }

        if (res.length() < s.length())
            return res;
        else
            return s;
    }


}


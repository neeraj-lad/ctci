import java.io.*;

class Test17
{
    public static void main(String args[])throws IOException
    {
       int m = 4, n = 3;
       int a[][] = {  {1, 0, 2},
                        {2, 3, 4},
                        {2, 5, 0},
                        {1, 1, 0}
                     };    

       printMatrix(a);

       int zeroRow[] = new int[m];
       int zeroCol[] = new int[n];

       for (int i = 0; i < m; i++)
               for (int j = 0; j < n; j++)
                       if (a[i][j] == 0)
                       {
                           zeroRow[i] = 1;
                           zeroCol[j] = 1;
                       }

       printMatrix(a);

       for (int i = 0; i < m; i++)
           if (zeroRow[i] == 1)
               for (int j = 0; j < n; j++)
                   a[i][j] = 0;

       for (int j = 0; j < n; j++)
           if (zeroCol[j] == 1)
               for (int i = 0; i < m; i++)
                   a[i][j] = 0;
       
       printMatrix(a);
    }

    static void printMatrix(int a[][])
    {
        int m = a.length;
        int n = a[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}


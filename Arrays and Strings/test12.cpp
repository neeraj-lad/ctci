#include <iostream>
#include <cstring>
using namespace std;

char* reverse(char *s, int i, int j)
{
    if (i < j)
    {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
        i++;
        j--;
        cout << s << endl;
        return reverse(s, i, j);
    }
    else
        return s;

}

int main()
{
    char cs[20] = "abcdef";
    int first = 0, last;
    for (int i = 0; i < 20; i++)
        if (cs[i] == '\0')
        {
            last = i;
            break;
        }

    for (int i = first; i < first + (last - first)/2; i++)
    {
        char t = cs[i];
        cs[i] = cs[last-i-1];
        cs[last-i-1] = t;
    }

    char ss[] = "uvwxyz";
    cout << reverse(ss, 0, strlen(ss)-1) << endl;

    cout << cs << endl;

	return 0;
}


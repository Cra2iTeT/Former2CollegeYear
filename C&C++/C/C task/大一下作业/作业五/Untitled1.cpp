#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <cctype>
#include <string>
#include <iostream>
using namespace std;

class Solution
{
	public:
		int count_digits(string str)
    {
        int n = 0;
        const char * p = str.c_str();
        for (int i = 0; p[i]; i++)
        {
            if (p[i] >= '0' && p[i] <= '9') n++;
        }
        return n;
    }
};

int main()
{
    int t;

    cin >> t;
    getchar();
    while (t--)
    {
        string str;
        Solution obj;

        getline(cin,str);
        int digits = obj.count_digits(str);

        cout << digits << endl;
    }

    return 0;
}

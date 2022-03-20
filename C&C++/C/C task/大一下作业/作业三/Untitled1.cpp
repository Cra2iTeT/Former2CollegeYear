#include <iostream>
using namespace std;
void Swap(int &a, int &b)
{
    int x = a;
    a = b;
    b = x;
}
int main()
{
    int a, b;

    cin >> a >> b;

    Swap(a, b);

    cout << a << " " << b << endl;

    return 0;
}

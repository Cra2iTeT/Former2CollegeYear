#include <iostream>
#include <fstream>
using namespace std;
int main()
{
    char ch;
    ifstream fp1("s2.dat",ios_base::binary);
    if (!(fp1.is_open()))
    {
        cout<<"can not open s2.dat\n";
        return 0;
    }
    ofstream fp2("d2.dat",ios_base::binary);
    if (!(fp2.is_open()))
    {
        cout<<"can not open d2.dat\n";
        return 0;
    }
	fp1.get(ch);
    while(!(fp1.eof()))
    {
        if((ch>='A')&&(ch<='Z'))
        {
            ch=ch+32;
        }        
	fp2.put(ch);        
	fp1.get(ch);        
    }
    fp1.close();
    fp2.close();
    return 0;
}

#include <iostream>
#include<fstream>
using namespace std;
int main()
{
    FILE *fp1,*fp2;
    char ch;
    if ((fp1=fopen("s1.txt","r"))==NULL)
    {
        cout<<"can not open s1.txt\n";
        return 0;
    }
    if ((fp2=fopen("d1.txt","w"))==NULL)
    {
        cout<<"can not open d1.txt\n";
        return 0;
    }
    ch=fgetc(fp1);
    while(ch!=EOF)
    {
        if((ch>='a')&&(ch<='z'))
        {
            ch=ch-32;
        }
        cout<<ch;
        fputc(ch,fp2);
        ch=fgetc(fp1);
    }
    fclose(fp1);
    fclose(fp2);
    return 0;
}

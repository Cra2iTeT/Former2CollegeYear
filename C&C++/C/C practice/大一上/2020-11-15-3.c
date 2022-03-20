#include <stdio.h>
void f(char *p);
int main(){
    const int N=80;
    char a[N];
    gets(a);
    {
		f(a);
    }
    printf("%s\n",a);
}

//µ¹Ðò

void f( char *p )
{
    int i=0,q=0,h,huan;
    while(p[i]!='\0')
        i++;
    h=i-1;
    while(q<=h)
    {
        huan=p[q];
        p[q]=p[h];
        p[h]=huan;
        q++;
        h--;
    }
    return ;
}

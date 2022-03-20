#include <stdio.h>
#define N 100
void f(char a[])
{
	int i,j,k,l;
	int t,T;
	char b[100];
	for(i=0;i<N&&a[i]!=' ';i++){		//k和l记录单词的起始位置，t和T记录单词的结束位置 
		k=0;
		t=i;
		j=i+2;
	}
	for(i=j;i<N&&a[j]!='\0';i++,j++){
		for(l=j;j<N&&a[j]!=' '&&a[j]!='\0'&&((a[j]>='A'&&a[j]<='Z')||(a[j]>='a'&&a[j]<='z'));j++){
			T=j;
		}
		if(t-k+1>=T-l+1);
		else{
			k=l;
			t=T;
		}
	}
	for(i=k;i<=t;i++){
		printf("%c",a[i]);
	}
}
int main(){
    char c[N];
    gets(c);
    f(c);
    return 0;
}

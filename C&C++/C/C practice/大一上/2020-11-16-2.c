#include <stdio.h>
int main(){
    const int N=80;
    char a[N];
    gets(a);
    {
		int i,j,k;
		char b[80];
		for(i=0;a[i]!=0;i++) k=i+1;
		printf("%d,%d\n",i,k);
		for(j=0,i=i-1;j<k+1;j++,i--) b[j]=a[i];
		printf("%s\n",b);
		for(i=0;i<k;i++) a[i]=b[i];
    }
    printf("%s\n",a);
}

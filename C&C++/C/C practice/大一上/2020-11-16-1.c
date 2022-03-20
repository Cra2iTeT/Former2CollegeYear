#include<stdio.h>
#include<string.h>
int main()
{
	char a[99],b[99];
	int i,j,k;
	gets(a);
	setbuf(stdin,NULL);
	gets(b);
	i=strlen(a);
	j=strlen(b);
	for(k=0;b[k]!=0;k++,i++){
		a[i]=b[k];
	}
	printf("%s\n",a);
	return 0;
}

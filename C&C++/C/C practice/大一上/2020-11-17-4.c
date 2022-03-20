#include<stdio.h>
int main()
{
	int i,n,j;
	char a[100];
	gets(a);
	scanf("%d%d",&i,&n);
	//		printf("%d,%d",i,n);		≤‚ ‘ π”√ 
	if(i<1) i=1;
	for(j=0,i--;j<n;j++,i++) printf("%c",a[i]);
} 

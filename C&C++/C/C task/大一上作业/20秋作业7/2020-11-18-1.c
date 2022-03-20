#include<stdio.h>
void f(int n);
int main()
{
	int n;
	scanf("%d",&n);
	if(n<=0) printf("Wrong number!\n");
	else f(n);
	return 0;
}

void f(int n)
{
	if(n%2==0) printf("%d is a even number.\n",n);
	else printf("%d is a odd number.\n",n);
	return 0;	
}

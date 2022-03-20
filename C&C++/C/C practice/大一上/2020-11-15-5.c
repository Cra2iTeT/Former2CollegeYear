#include<stdio.h>
int main()
{
	int n,a[40]={1,1},i;
	scanf("%d",&n);
	if(n>40||n<=0)	printf("error data");
	else{
		for(i=0;i<n&&i>1;i++){
			a[i]=a[i-1]+a[i-2];
		}
	}
}

#include<stdio.h>
int main(){
	int a[6]={0,1,2,3,4,5};
	int *p=a;
	printf("%d\n",*p);
	int b=10;
	b=*p++;
	//b=*(p++);
	//b=*++p;
	//b=*(++p);
	printf("%d\t%d\t%d",*a,b,*p);
}

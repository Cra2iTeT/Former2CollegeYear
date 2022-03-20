#include<stdio.h>
int main(){
	int a,b;
	scanf("%d,%d",&a,&b);
	int c;
	c=max(a,b);
	printf("%d",c);
	return 0;
}
int max(int a,int b){
	int z;
	if(a>b) z=a;
	else z=b;
	return z;
}

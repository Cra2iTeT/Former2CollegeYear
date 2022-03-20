#include <stdio.h>
double p(int n,int x)
{
	int a;
	if(n==0) a=0;
	if(n==1) a=x;
	if(n>1) a=((2*n-1)*x-p(n-1,x)-(n-1)*p(n-2,x))/n;
	return a;
}
int main(){
    int x,n;
    scanf("%d%d",&n,&x);
    printf("P%d(%d)=%.1f\n",n,x,p(n,x));
    return 0;
}

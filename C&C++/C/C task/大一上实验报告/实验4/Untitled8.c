#include<stdio.h>
int main()
{
	int a[1000]={0},T=1,i,j,k,n,count=0;
	scanf("%d",&n);
	if(n>=1000||n<=1){
		printf("error data\n");
	}
	else{
	if(n==2){
		a[count]=2;
		count++;
	}
	else{
		for(i=2;i<=n;i++){
			for(j=2;j<i;j++){
				if(i%j==0){
					T=0;
					break;		//是素数直接跳出循环 
				}
			}
			if(T){
				a[count]=i;
				count++;
			}
			T=1;
		}
	}
	k=count%10;
	if(k>0){
		k=count/10+1;
	}
	count=0;
	for(i=0;i<k;i++){
		for(j=0;j<10&&a[count]!=0;j++,count++){
			printf("%5d",a[count]);
		}
		printf("\n");
	}
}
	return 0;
}

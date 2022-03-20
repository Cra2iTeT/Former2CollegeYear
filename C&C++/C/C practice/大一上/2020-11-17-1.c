#include<stdio.h>
int main()
{
	int n,i,j=2,a[40]={1,1},count,t;
	scanf("%d",&n);
	t=(n/5+n%5);
	if(n<=0||n>40) printf("error data\n");
	else{
		printf("%10d",a[0]);
		if(n>=2){
			printf("%10d",a[1]);
			count=2;
			for(i=0;i<t&&j<n-1;i++){
				for(;count<5&&j<n;count++,j++){
					a[j]=a[j-1]+a[j-2];
					printf("%10d",a[j]);
				}
				printf("\n");
				count=0;
		}
		}
	}
}

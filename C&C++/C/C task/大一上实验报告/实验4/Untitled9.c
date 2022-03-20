#include<stdio.h>
int main()
{
	int n,i,j;
	int a[21][22]={1,1};
	scanf("%d",&n);
	if(n>=21||n<=0) printf("error data\n");
	else{
		for(i=0;i<n;i++){
			if(i>=1){
			for(j=0;j<i+2;j++){
				if(j==0||j==i+1){
					a[i][j]=1;
				}
				else{
					a[i][j]=a[i-1][j-1]+a[i-1][j];
				}
				printf("%6d",a[i][j]);
			}
			}
			else{
				for(j=0;j<i+2;j++){
					printf("%6d",a[i][j]);
				}
			}
			printf("\n");
		}
	}
	return 0;
}

#include<stdio.h>
int f(int A[],int N,int B);
int main()
{
	int a[10];
    int b,t=0,i,n=10,T;
	for(i=0;i<10;i++) scanf("%d",&a[i]);
	{
	int j,k,temp;
	for(j=0;j<i;j++){
		for(k=j+1;k<i;k++){
			if(a[j]>a[k]){
				temp=a[k];
				a[k]=a[j];
				a[j]=temp;
				}
			}
		}
	}
	scanf("%d",&b);
	for(i=0;i<10;i++){
		printf("%5d",a[i]);
	}
	printf("\n");
	t=f(a,n,b);
	printf("\n");
 	if(t!=0) printf("Success\n");
 	else printf("Fail\n");
 	return 0;
}
int f(int A[],int N,int B)
{
	int low=0,high=N-1,mid;
	while(low<=high){
		mid=(low+high)/2;
		if(A[mid]==B){
			printf("%5d",mid);
			return 1;
		}
		if(A[mid]<B){
			printf("%5d",mid);
			low=mid+1;
		}
		else{
			printf("%5d",mid);
			high=mid-1;
		}
	}
	return 0;
}


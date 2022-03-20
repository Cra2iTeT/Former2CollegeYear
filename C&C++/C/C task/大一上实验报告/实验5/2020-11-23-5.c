#include <stdio.h>
#define N 20
void sort(int a[],int n)
{
	int i,j,t;
	
	for(i=0;i<n;i++){
		for(j=i+1;j<n;j++){
			if(a[i]>a[j]);
			else{
				t=a[i];
				a[i]=a[j];
				a[j]=t;
			}
		}
	}
}
int main(){
    int a[N],i,n;
    scanf("%d",&n);
    if(n>20)  printf("error data");
    else{
        for(i=0; i<n; i++)
            scanf("%d",&a[i]);
        sort(a,n);
        for(i=0; i<n; i++)
            printf("%5d",a[i]);
        printf("\n");
    }
    return 0;
}

#include <stdio.h>
#include <string.h>
#define N 20
void f(int *a,int n,int m){
	int i,j,k,count=0;
	int b[N];
	for(j=0,i=n-m;i<n;j++,i++)
		b[j]=a[i];		/*¸´ÖÆÊý¾Ý*/
	k=n-j;
	for(i=n-m-1,j=n-1;count<k;i--,j--,count++)
		a[j]=a[i];
	for(i=0;i<m;i++){
		a[i]=b[i];
	}
}
int main(void){
    int i,n,m;
    int a[N];
    scanf("%d",&n);
    for(i=0;i<n;i++)
        scanf("%d",&a[i]);
    scanf("%d",&m);
    f(a,n,m);
    for(i=0;i<n;i++)
        printf("%5d",a[i]);
    return 0;
}

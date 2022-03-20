#include <stdio.h>
#define N 10
void f(int a[][N],int n)
{
	int b[n][n];
	int i,j,temp;
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			b[i][j]=a[i][j];		//用新数组记录a数组按列排序 
		}
	}
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			a[i][j]=b[j][i];
		}
	}
}
int main(){
    int a[N][N],n,i,j;
    scanf("%d",&n);
    if(n<1||n>10)  printf("error data");
    else{
        for(i=0; i<n; i++)
            for(j=0; j<n; j++)
                scanf("%d",&a[i][j]);
        f(a,n);
        for(i=0; i<n; i++){
            for(j=0; j<n; j++)
                printf("%5d",a[i][j]);
            printf("\n");
        }
    }
    return 0;
}

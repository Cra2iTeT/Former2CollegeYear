#include <stdio.h>
void f(int a[],int b[],int c[],int m,int n,int t)
{
	int i,j,k=0,q,Q;
	int a1[m][n],b1[n][t];
	for(i=0,k=0;i<m;i++){
		for(j=0;j<n;j++){
			a1[i][j]=a[k];
			k++;
		}
	}
	for(i=0,k=0;i<n;i++){
		for(j=0;j<t;j++){
			b1[i][j]=b[k];
			k++;
		}
	}
	for(i=0,k=0,Q=0;i<3;i++){
		for(q=0;q<3;q++){
			for(j=0,Q=0;j<4;m++,j++){
				Q=Q+(a1[i][j]*b1[j][q]);
			}
			c[k]=Q;
			k++;
		}
	}
	return c;
}
int main(){
    int i,j,a[3][4],b[4][3],c[3][3];
    for(i=0; i<3; i++)
        for(j=0; j<4; j++)
            scanf("%d",&a[i][j]);
    for(i=0; i<4; i++)
        for(j=0; j<3; j++)
            scanf("%d",&b[i][j]);
    f(a[0],b[0],c[0],3,4,3);
    for(i=0; i<3; i++){
        for(j=0; j<3; j++)
            printf("%5d",c[i][j]);
        printf("\n");
    }
}

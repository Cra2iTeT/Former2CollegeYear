#include<stdio.h>
int main(){
	int iN;
	int i,j;
	scanf("%d",&iN);
	for(i=1;i<=iN;i++){
		for(j=1;j<=i;j++){
			printf("%d*%d=%-4d",j,i,i*j);
		}
        if(i!=n){
		    printf("\n");
        }
	}
	return 0;
}

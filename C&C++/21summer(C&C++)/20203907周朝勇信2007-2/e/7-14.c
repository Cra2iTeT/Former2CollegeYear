#include<stdio.h>
int main(){
	int iA,iB,i,j=0,iSum=0;
	scanf("%d%d",&iA,&iB);
	for(i=iA;i<=iB;i++){
		printf("%5d",i);
		iSum+=i;
		j++;
		if(j%5==0&&i<iB){
			printf("\n");
		}
	}
	if(j%5!=5){
		printf("\n");
	}
	printf("Sum = %d",iSum);
	return 0;
}

#include<stdio.h>
int main(void)
{
	int iA,iB,iC;
	scanf("%d %d %d",&iA,&iB,&iC);
	if(iA==iB){
		printf("C");
	}
	else if(iB==iC){
		printf("A");	
	}
	else if(iA==iC){
		printf("B");
	}
	return 0;
}

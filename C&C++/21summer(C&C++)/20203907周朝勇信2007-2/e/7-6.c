#include<stdio.h>
int main(){
	float fA,fB;
	int iC;
	char cD;
	scanf("%f %d %c %f",&fA,&iC,&cD,&fB);
	printf("%c %d %.2f %.2f",cD,iC,fA,fB);
	return 0;
}

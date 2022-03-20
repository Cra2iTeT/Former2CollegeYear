#include<stdio.h>
int main(){
	int iA,iB;
	scanf("%d:%d",&iA,&iB);
	if(iA<12){
		printf("%d:%d AM",iA,iB);
	}
	if(iA==12){
		printf("12:%d PM",iB);
	}
	if(iA>12&&iA!=24){
		printf("%d:%d PM",iA-12,iB);
	}
	if(iA==24){
		printf("0:%d AM",iB);
	}
	return 0;
}

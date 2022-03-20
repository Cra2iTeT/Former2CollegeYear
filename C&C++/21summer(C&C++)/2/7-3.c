#include<stdio.h>
int main(){
	int iS;
	scanf("%d",&iS);
	int i=iS%10*100+iS/10%10*10+iS/100;
	printf("%d",i);
	return 0;
}

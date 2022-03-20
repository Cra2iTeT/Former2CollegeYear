#include <stdio.h>
int main ()
{
	int hor,min;
	scanf("%d:%d",&hor,&min);
	if(hor==24){
		hor=0;
		printf("%d:%d AM\n",hor,min);
	}
	if(hor==12){
		printf("%d:%d PM\n",hor,min);
	}
	if(hor<12)
		printf("%d:%d AM\n",hor,min);
	if(hor>12){
		hor-=12;
		printf("%d:%d PM\n",hor,min);
	}
	return 0;
}

#include<stdio.h>
int main()
{
	int iN1,iN2;
	char a;	//¼ÇÂ¼ÊäÈëµÄ·ûºÅ 
	scanf("%d %c %d",&iN1,&a,&iN2);
    if(a=='+') 
		printf("%d",iN1+iN2);
	else if(a=='-')
		printf("%d",iN1-iN2);
	else if(a=='*') 
		printf("%d",iN1*iN2);
	else if(a=='/') 
		printf("%d",iN1/iN2);
	else if(a=='%') 
		printf("%d",iN1%iN2);
    else 
		printf("ERROR");
	return 0;
}

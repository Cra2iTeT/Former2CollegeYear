#include<stdio.h>
int main(){
	double dX,dY;
	scanf("%lf",&dX);
	if(dX>15){
		dY=2.5*dX-17.5;
	}
	else{
		dY=(dX*4)/3;
	}
	printf("%.2f",dY);
	return 0;
}

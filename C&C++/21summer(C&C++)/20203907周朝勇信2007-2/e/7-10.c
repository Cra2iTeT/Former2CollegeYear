#include<stdio.h>
int main(){
	int iY,iH;	//工作时长和工龄 
	int iM;	//基础工资 
	double dMm;	//总工资 
	scanf("%d%d",&iY,&iH);
	if(iY>=5){
		iM=50;
	}
	else{
		iM=30;
	}
	
	if(iH>40){
		dMm=40*iM+(iH-40)*1.5*iM;
		printf("%.2f",dMm);
	}
	else{
		dMm=iM*iH;
		printf("%.2f",dMm);
	}
	return 0;
}

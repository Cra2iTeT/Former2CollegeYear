#include<stdio.h>
int main(){
	int iY,iH;	//����ʱ���͹��� 
	int iM;	//�������� 
	double dMm;	//�ܹ��� 
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

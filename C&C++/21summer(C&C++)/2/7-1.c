#include<stdio.h>
int main(){
	int iFt,iIc;
	double dCm;
	scanf("%lf",&dCm);
	dCm/=100;//��λ����
	dCm=dCm/0.3048;
	iFt=dCm;
	iIc=(dCm-iFt)*12;
	printf("%d %d",iFt,iIc);
	return 0;
}

#include<stdio.h>
int main(){
	double dS,dM,dSum;
	scanf("%lf",&dM);
	dSum=1.0;
	dS=1.0;
	int i=1;
	while(dS>dM){
		dS=dS*i/(i*2+1);
		dSum+=dS;
		i++;
	}
	printf("%.6f",dSum*2);
	return 0;
}

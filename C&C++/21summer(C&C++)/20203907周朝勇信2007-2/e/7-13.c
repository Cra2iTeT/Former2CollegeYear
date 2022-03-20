#include<stdio.h>
int main(){
	double dOpen,dHigh,dLow,dClose;
	double dH;
	scanf("%lf%lf%lf%lf",&dOpen,&dHigh,&dLow,&dClose);
	dH=dClose-dOpen;
	int index=0;
	if(dH==0){
		printf("R-Cross");
		if(dLow<dOpen){
			printf(" with Lower Shadow");
			index++;
		}
		if(index==1){
			if(dHigh>dOpen){
				printf(" and Upper Shadow");
			}
		}
		else {
			if(dHigh>dOpen){
				printf(" with Upper Shadow");
			}
		}
	}
	else if(dH>0){
		printf("R-Hollow");
		if(dLow<dOpen){
			printf(" with Lower Shadow");
			index++;
		}
		if(index==1){
			if(dHigh>dClose){
				printf(" and Upper Shadow");
			}
		}
		else {
			if(dHigh>dClose){
				printf(" with Upper Shadow");
			}
		}
	}
	else if(dH<0){
		printf("BW-Solid");
		if(dLow<dClose){
			printf(" with Lower Shadow");
			index++;
		}
		if(index==1){
			if(dHigh>dOpen){
				printf(" and Upper Shadow");
			}
		}
		else {
			if(dHigh>dOpen){
				printf(" with Upper Shadow");
			}
		}
	}
	return 0;
}

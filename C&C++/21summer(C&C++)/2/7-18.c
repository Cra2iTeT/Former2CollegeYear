#include<stdio.h>
float fA3,fA2,fA1,fA0;
float F(float x){	//计算方程左值 
	return fA3*x*x*x+fA2*x*x+fA1*x+fA0;
}
int main(){
	float fA,fB;
	scanf("%f%f%f%f",&fA3,&fA2,&fA1,&fA0);
	scanf("%f%f",&fA,&fB);
	float mid;
	while((fB-fA>=0.001)&&(F(fA)*F(fB)<=0)){
		mid=(fA+fB)/2;
		if(F(mid)==0){
			printf("%.2f",(fA+fB)/2);
			return 0;
		}
		if(F(mid)*F(fA)>0){
			fA=mid;
		}
		if(F(mid)*F(fB)>0){
			fB=mid;
		}
	}
	printf("%.2f",(fA+fB)/2);
	return 0;
}

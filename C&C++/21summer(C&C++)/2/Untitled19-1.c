#include<stdio.h>
float a3,a2,a1,a0;
float F(float x){
	return a3*x*x*x+a2*x*x+a1*x+a0;
}
int main(){
	float a,b;
	scanf("%f%f%f%f",&a3,&a2,&a1,&a0);
	scanf("%f%f",&a,&b);
	float mid;
	while((b-a>=0.001)&&(F(a)*F(b)<0)){
		mid=(a+b)/2;
		if(F(mid)==0){
			printf("%.2f",(a+b)/2);
			return 0;
		}
		if(F(mid)*F(a)>0){
			a=mid;
		}
		if(F(mid)*F(b)>0){
			b=mid;
		}
	}
	printf("%.2f",(a+b)/2);
	return 0;
}

#include<stdio.h>
float F2(double a,double b,double a3,double a2,double a1,double a0);
float F3(double x,double a3,double a2,double a1,double a0);
float F1(double a,double b,double a3,double a2,double a1,double a0){
	a=(a+b)/2.0;
	double h=(a+b)/2.0;
	double f0=F3(h,a3,a2,a1,a0);
	double f1=F3(a,a3,a2,a1,a0);
	double f2=F3(b,a3,a2,a1,a0);
	if(f0==0){
		printf("%.2f",h);
		return 0;
	}else if((f1>0&&f0>0)||(f1<0&&f0<0)){
		F1(a,b,a3,a2,a1,a0);
	}else if((f2>0&&f0>0)||(f2<0&&f0<0)){
		F2(a,b,a3,a2,a1,a0);
	}
}
float F2(double a,double b,double a3,double a2,double a1,double a0){
	b=(a+b)/2.0;
	double h=(a+b)/2.0;
	double f0=F3(h,a3,a2,a1,a0);
	double f1=F3(a,a3,a2,a1,a0);
	double f2=F3(b,a3,a2,a1,a0);
	if(f0==0){
		printf("%.2f",h);
		return 0;
	}else if((f1>0&&f0>0)||(f1<0&&f0<0)){
		F1(a,b,a3,a2,a1,a0);
	}else if((f2>0&&f0>0)||(f2<0&&f0<0)){
		F2(a,b,a3,a2,a1,a0);
	}
}
float F3(double x,double a3,double a2,double a1,double a0){
	return a3*x*x*x+a2*x*x+a1*x+a0;
}
int main(){
	double a0,a1,a2,a3;
	scanf("%lf%lf%lf%lf",&a3,&a2,&a1,&a0);
	double a,b;
	scanf("%lf%lf",&a,&b);
	double h=(a+b)/2.0;
	if(b-a<0.01){
		printf("%.2f",h);
		return 0;
	}
	double f0=F3(h,a3,a2,a1,a0);
	double f1=F3(a,a3,a2,a1,a0);
	double f2=F3(b,a3,a2,a1,a0);
	if(f0==0){
		printf("%.2f",h);
		return 0;
	}else if((f1>0&&f0>0)||(f1<0&&f0<0)){
		F1(a,b,a3,a2,a1,a0);
	}else if((f2>0&&f0>0)||(f2<0&&f0<0)){
		F2(a,b,a3,a2,a1,a0);
	}
}

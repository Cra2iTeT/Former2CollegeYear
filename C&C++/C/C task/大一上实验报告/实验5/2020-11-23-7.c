#include <stdio.h>
#include <math.h>
void f(double a,double b,double c)
{
	double x1,x2,x3,x4;
	if(a==0&&b!=0&&c!=0) printf("%f\n",-c/b);		//非二次方程的情况 
	if(a==0&&b==0&&c!=0) printf("error data\n");
    if(a==0&&b!=0&&c==0) printf("%lf",a);
    if(a==0&&b==0&&c==0) printf("error data\n");
	if(a!=0&&(b*b-4*a*c)<0){		//求非实数根 
		x1=-b/2*a;
		x2=-b/2*a;
		x3=sqrt(-(b*b-4*a*c))/(2*a);
		x4=-sqrt(-(b*b-4*a*c))/(2*a);
		printf("%lf+%lfi,%lf%lfi\n",x1,x3,x2,x4);
	}
	if(a!=0&&(b*b-4*a*c)==0) printf("%lf\n",(-b+sqrt(b*b-4*a*c))/(2*a));
	if(a!=0&&(b*b-4*a*c)>0){ 
		x1=(-b+sqrt(b*b-4*a*c))/(2*a);
        if(x1==0) x1=0;
		x2=(-b-sqrt(b*b-4*a*c))/(2*a);
		printf("%lf,%lf",x1,x2);
        if(x2==0) x2=0;
	}
}
int main(){
    double a,b,c;
    scanf("%lf%lf%lf",&a,&b,&c);
    f(a,b,c);
    return 0;
}

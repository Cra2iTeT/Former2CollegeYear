#include <stdio.h>
#include <math.h>
double f(double a,double b,double c,double d,double x)
{
	double x0,y0,y,k;
	y0=a*x*x*x+b*x*x+c*x+d;
	x0=x;
	if(y0<1e-6&&y0>-1e-6) return x;		//给个极小的范围，避免死循环 
	else{
		k=3*a*x*x+2*b*x+c;
		x=-y0/k+x0;
		f(a,b,c,d,x);
	}
}
int main(){
    double a,b,c,d,x;
    scanf("%lf%lf%lf%lf%lf",&a,&b,&c,&d,&x);
    printf("%lf\n",f(a,b,c,d,x));
    return 0;
}

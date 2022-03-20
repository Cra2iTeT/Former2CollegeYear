#include <stdio.h>

#define MAXN 10

double f( int n, double a[], double x );

int main()
{
    int n, i;
    double a[MAXN], x;

    scanf("%d %lf", &n, &x);
    for ( i=0; i<=n; i++ )
        scanf("%lf", &a[i]);
    printf("%.1f\n", f(n, a, x));
    return 0;
}

/* ��Ĵ��뽫��Ƕ������ */
double f( int iN, double dA[], double dX ){
	double dSum=dA[iN];
	int iI;
	for(iI=iN;iI>0;iI--){
		dSum=dA[iI-1]+dX*dSum;
	}
	return dSum;	//�׳˺�
}

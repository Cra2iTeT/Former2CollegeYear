#include <stdio.h>

#define MAXN 10
typedef float ElementType;

ElementType Average( ElementType S[], int N );

int main ()
{
    ElementType S[MAXN];
    int N, i;

    scanf("%d", &N);
    for ( i=0; i<N; i++ )
        scanf("%f", &S[i]);
    printf("%.2f\n", Average(S, N));

    return 0;
}

/* 你的代码将被嵌在这里 */
ElementType Average( ElementType S[], int N ){
	ElementType avg=0;
	int iI=0;
	for(;iI<N;i++){
		avg += S[iI];
	}
	return (avg/N); //返回平均值
}

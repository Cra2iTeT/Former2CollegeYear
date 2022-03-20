#include <stdio.h>

#define MAXN 10
typedef float ElementType;

ElementType Max( ElementType S[], int N );

int main ()
{
    ElementType S[MAXN];
    int N, i;

    scanf("%d", &N);
    for ( i=0; i<N; i++ )
        scanf("%f", &S[i]);
    printf("%.2f\n", Max(S, N));

    return 0;
}

/* ��Ĵ��뽫��Ƕ������ */
ElementType Max( ElementType S[], int N ){
	int iI;
	ElementType max=S[0];
	for(iI=1;iI<N;iI++){
		if(S[iI]>max){
			max=S[iI];
		}
	}
	return (ElementType)max;	//ǿ������ת��
}

#include <stdio.h>

#define MAXN 10
typedef float ElementType;

ElementType Median( ElementType A[], int N );

int main ()
{
    ElementType A[MAXN];
    int N, i;

    scanf("%d", &N);
    for ( i=0; i<N; i++ )
        scanf("%f", &A[i]);
    printf("%.2f\n", Median(A, N));

    return 0;
}

ElementType Median( ElementType A[], int N)
{
    int i, j,k;
    ElementType Temp;
 
    for ( k = N / 2; k > 0; k /= 2){
        for ( i = k; i < N; i++){
            Temp = A[ i ];
            for (j = i;j >= k;j -= k ){
                if ( Temp < A[ j - k ])
                    A[ j ] = A[ j - k ];
                else
                    break;
            }
            A[ j ] = Temp;
        }
    }
 
    return A[ N / 2 ];
}


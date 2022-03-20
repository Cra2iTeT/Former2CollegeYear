#include <stdio.h>

void PrintN ( int N );

int main ()
{
    int N;

    scanf("%d", &N);
    PrintN( N );

    return 0;
}

/* 你的代码将被嵌在这里 */
void PrintN(int N){
	int iI; //待输出的整数
	for(iI=1;iI<N;iI++){
		printf("%d\n",iI);
	}
	printf("%d",iI);
}

#include <stdio.h>

void PrintN ( int N );

int main ()
{
    int N;

    scanf("%d", &N);
    PrintN( N );

    return 0;
}

/* ��Ĵ��뽫��Ƕ������ */
void PrintN(int N){
	int iI; //�����������
	for(iI=1;iI<N;iI++){
		printf("%d\n",iI);
	}
	printf("%d",iI);
}

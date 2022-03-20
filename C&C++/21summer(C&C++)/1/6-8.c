#include <stdio.h>

int Factorial( const int N );

int main()
{
    int N, NF;

    scanf("%d", &N);
    NF = Factorial(N);
    if (NF)  printf("%d! = %d\n", N, NF);
    else printf("Invalid input\n");

    return 0;
}

/* 你的代码将被嵌在这里 */
int Factorial( const int N ){
	if(N>=0){
		int i;
		int iSum=1;
		for(i=N;i>1;i--){
			iSum*=i;
		}
		return iSum;
	}
	else{
		return 0;
	}
}

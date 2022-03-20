#include <stdio.h>

void Print_Factorial ( const int N );

int main()
{
    int N;

    scanf("%d", &N);
    Print_Factorial(N);
    return 0;
}

/* ��Ĵ��뽫��Ƕ������ */
void Print_Factorial ( const int N ){
	if(N<0){
		printf("Invalid input");
	}
	else{
		int i;
		double sum=1.0;
		for(i=N;i>1;i--){
			sum*=i;
		}
		printf("%.0lf",sum);
	}
}

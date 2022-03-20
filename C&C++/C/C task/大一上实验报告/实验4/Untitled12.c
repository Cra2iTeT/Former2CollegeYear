#include<stdio.h>
int main()
{
	double a[10];
	double Min,Max;
	int i;
	for(i=0;i<10;i++){
		scanf("%lf",&a[i]);
	}
	for(Min=a[0],Max=a[1],i=0;i<10;i++){		//·ÖÇé¿ö
		if(a[i]>Max){
			Max=a[i];
		}
		if(a[i]<Min){
			Min=a[i];
		}
	}
	printf("Min=%lf\nMax=%lf\n",Min,Max);
	return 0;
}

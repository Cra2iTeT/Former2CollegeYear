#include<stdio.h>
int main(){
	int f,y,n;
	scanf("%d",&n);
	//y�ķ�Χ0-49
	for(f=0;f<100;f++){
		for(y=0;y<49;y++){
			if((98*f-199*y)==n){
				printf("%d.%d",y,f);
				return 0;
			}
		}
	}
	printf("No Solution");
	return 0;
}

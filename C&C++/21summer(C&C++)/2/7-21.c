#include<stdio.h>
#include<math.h>
int main(){
	int n,a,b,flag=0;
	scanf("%d",&n);
	for(a=1;a<=(sqrt(n/2));a++){
		for(b=1;b<=n;b++){
			if((a*a+b*b)==n){
				printf("%d %d\n",a,b);
				flag=1;
			}
		}
	}
	if(!flag){
		printf("No Solution");
	}
	return 0;
}

#include<stdio.h>
int main(){
	char c;
	int i;
	while(1){
		scanf("%c",&c);
		if(c==' '){
			if(i!=0){
				printf("%d ",i);
				i=0;
			}
		}else if(c=='.'){
			if(i!=0){
				printf("%d",i);
			}
			return 0;
		}
		i++;
	}
	return 0;
}

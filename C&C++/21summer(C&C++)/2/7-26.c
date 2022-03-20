#include<stdio.h>
int main(){
	char cC;
	int i;
	int iFlag=0;	//是否要结束标志 
	while(1){
		scanf("%c",&cC);
		if(cC==32){
			if(i!=0){
				if(iFlag!=0){
					printf(" ");
				}
				printf("%d",i);
				i=0;
				iFlag=1;
			}
		}else if(cC=='.'){
			if(i!=0){
				printf("%d",i);
			}
			return 0;
		}
		else
			i++;
	}
	return 0;
}

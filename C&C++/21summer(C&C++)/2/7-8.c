#include<stdio.h>
int main(){
	int iS;
	scanf("%d",&iS);
    if(iS>500||iS<0){
		return 0;
	} 
	if(iS>60){
		printf("Speed: %d - Speeding",iS);
	}
	else{
		printf("Speed: %d - OK",iS);
	}
	return 0;
} 

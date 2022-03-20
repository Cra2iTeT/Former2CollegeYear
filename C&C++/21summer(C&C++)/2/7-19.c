#include<stdio.h>
int main(){
	int iF,iY,iN;
	scanf("%d",&iN);
	//yµÄ·¶Î§0-49
	int index=0;
	for(iF=0;iF<100;iF++){
		for(iY=0;iY<49;iY++){
			if((98*iF-199*iY)==iN){
				printf("%d.%d",iY,iF);
				index=1;
				return 0;
			}
		}
	}
	if(!index){
		printf("No Solution");
		return 0;
	}
}

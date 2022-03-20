#include<stdio.h>
int main(){
	int iM;
	scanf("%d",&iM);
	int iS1=0,iS2=0;
	int index=0;
	int i;
	for(i=1;i<=iM;i++){
		iS1+=3;
		iS2+=9;
		if(i%10==0){
			if(iS2>iS1){
				for(index=0;index<30&&i<iM;index++,i++){
					iS1+=3;
				}
			}
		}
	}
	if(iS2>iS1){
		printf("^_^ %d",iS2);
	}
	if(iS2<iS1){
		printf("@_@ %d",iS1);
	}
	if(iS2==iS1){
		printf("-_- %d",iS2);
	}
	return 0;
}

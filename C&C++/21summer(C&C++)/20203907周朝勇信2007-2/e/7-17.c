#include<stdio.h>
int main(){
	int iN,iU,iD;	//��¼��������� 
	scanf("%d%d%d",&iN,&iU,&iD);
	int iS,iM;
	iM=0;
	iS=iU*iM;
	while(iS<iN){
		iM++;
		iS+=iU;
		if(iS>=iN){
			printf("%d",iM);
			return 0;
		}
		iS-=iD;
		iM++;
	}
}

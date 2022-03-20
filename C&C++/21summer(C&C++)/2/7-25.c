#include<stdio.h>
int main(){
	int iS;
	scanf("%d",&iS);
	if(iS<0){
		iS*=-1;	//求绝对值 
		printf("fu ");
	}
	int i,j=iS;
	int iK;
	int iLen;
	for(iLen=1,i=iS,iK=1;(i/=10)!=0;iLen++,iK*=10);//先求长
	for(i=0;i<iLen;i++){
		j=iS/iK%10;
		iK/=10;
		switch(j){
			case 0:
				printf("ling");
				break;
			case 1:
				printf("yi");
				break;
			case 2:
				printf("er");
				break;
			case 3:
				printf("san");
				break;	
			case 4:
				printf("si");
				break;
			case 5:
				printf("wu");
				break;
			case 6:
				printf("liu");
				break;
			case 7:
				printf("qi");
				break;
			case 8:
				printf("ba");
				break;
			case 9:
				printf("jiu");
				break;
		}
		if(i==iLen-1){
			return 0;
		}
		printf(" ");
	}
}

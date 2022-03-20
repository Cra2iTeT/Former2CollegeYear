#include<stdio.h>
int main(){
	int iS;
	scanf("%d",&iS);
	int index=0;
	int i=iS,j,k;
	for(;i<=iS+3;i++){
		for(j=iS;j<=iS+3;j++){
			for(k=iS;k<=iS+3;k++){
				if((i!=j)&&(i!=k)&&(j!=k)){
					printf("%d%d%d",i,j,k);
					index++;
					if(index==6){
						index=0;
						printf("\n");
					}else{
						printf(" ");
					}
				}
			}
		}
	}
	return 0;
}

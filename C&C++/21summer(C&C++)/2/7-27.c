#include<stdio.h>
int main(){
	int iN,iK;
	scanf("%d%d",&iN,&iK);
	int iA[100];//最大只有100，如果更多或者未知就用动态 
	int i;
	//getchar();
	for(i=0;i<iN;i++){
		scanf("%d",&iA[i]);
		//getchar();
		//printf("%d------\n",a[i]);
	}
	int j,temp;
	for(i=0;i<iK;i++){
		for(j=0;j<iN-1-i;j++){
			if(iA[j]>iA[j+1]){
				temp=iA[j];
				iA[j]=iA[j+1];
				iA[j+1]=temp;
			}
			/*int l;
			for(l=0;l<n;l++)
				printf("%d ",a[l]);
			printf("------\n");*/
		}
		
	}
	for(i=0;i<iN;i++){
		printf("%d",iA[i]);
		if(i!=iN-1)
			printf(" ");
	}
	return 0;
}

#include<stdio.h>
int main(){
	int i=3;
	int n,j;
	n=(i-1)/2;
	int flag=0;
	for(j=2;flag==0;j++){
		float index1,index2;
		index1=(j+2)*(j-1)/2.0;
		index2=(j+3)*(j)/2.0;
		if(n>=index1&&n<=index2){
			flag=1;
		}
	}
	printf("%d",j);
	return 0;
} 

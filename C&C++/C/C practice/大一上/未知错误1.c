#include <stdio.h>
#define N 20
int main(){
    int i=0,a[N];
    do{
        scanf("%d",a+i);
    }while(a[i++]>0);
    {
    	int j,k,temp;
		for(j=0;j<i-1;j++){
			for(k=j+1;k<i-1;k++){
				if(a[j]<a[k]){
					temp=a[k];
					a[k]=a[j];
					a[j]=temp;
				}
			}
		}
    }
    for(i=0; a[i]>0; i++)
        printf("%5d",a[i]);
    return 0;
}

#include <stdio.h>
#define N 20
int main(){
    int i=0,a[N];
    do{
        scanf("%d",a+i);
    }while(a[i++]>0);
    {
   	int j,temp;
	for(j=0;j<i-2;j++,i--){
    temp=a[i-2];
    a[i-2]=a[j];
    a[j]=temp;
}
    }
    for(i=0; a[i]>0; i++)
        printf("%5d",a[i]);
    return 0;
}

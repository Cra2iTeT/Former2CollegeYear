#include <stdio.h>
#include <string.h>
#define N 20
void f(char (*c)[N],int n){
	int i,j,k,l;
	char a[N];
	for(i=0;i<n;i++){
		for(j=i+1;j<n;j++){
			if(strcmp(c[i],c[j])>=0);		//�Ƚϳ��� 
			if((strcmp(c[i],c[j]))<0){		//�������� 
				strcpy(a,c[i]);
				strcpy(c[i],c[j]);
				strcpy(c[j],a);
			}
		}
	}
}
int main(void){
    int i;
    char c[5][N];
    for(i=0;i<5;i++)
        gets(c[i]);
    f(c,5);
    for(i=0;i<5;i++)
        puts(c[i]);
    return 0;
}

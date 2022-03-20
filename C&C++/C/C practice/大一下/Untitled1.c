#include<stdio.h>
int main(){
	int a[10];
	int *p=a;
	void fun1(p);
	int i;
	for(i=0;i<10;i++){
		printf("%d\t",*(p+i));
	}
}
void fun1(int *p){
	int i;
	for(i=0;i<10;i++){
		scanf("%d",p+i);
	}
}

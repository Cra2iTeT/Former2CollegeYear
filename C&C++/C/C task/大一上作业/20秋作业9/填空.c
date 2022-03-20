#include<stdio.h>
int  
max(int a,int b);
int main(){
    int x,y,(*p)() ;
    scanf("%d%d",&x,&y) ; 
	p=max;   
	printf("%d\n",(*p)(x,y));
    return 0;
}
int  max(int a ,int b){ 
    return (a>b?a:b);
}

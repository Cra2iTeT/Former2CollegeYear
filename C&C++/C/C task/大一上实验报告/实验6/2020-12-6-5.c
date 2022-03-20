#include <stdio.h>
#define N 80

void f(char *c,char d){
	int i,j;
	for(j=0;j<N&&c[j]!='\0';j++);
	for(i=0;i<j;i++){
		if(c[i]>='0'&&c[i]<='9') c[i]=d;
	}
}

int main(void){
    char c[N],a;
    gets(c);
    scanf("%c",&a);
    int i;
    f(c,a);
    printf("%s",c);
    return 0;
}

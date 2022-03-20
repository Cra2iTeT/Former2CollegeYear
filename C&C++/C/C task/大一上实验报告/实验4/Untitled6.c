#include <stdio.h>
int main(){
    char c[100];
    gets(c);
    {
   	int i,j,count;
	char k;
	for(i=0;i<100&&c[i]!=0;i++);
		for(k=' ';k<'z';k++){		//符合情况进入循环 
			for(j=0,count=0;j<i;j++){
				if(c[j]==k) count++;
			}
			if(count>=1) printf("%c-->%d\n",k,count);
		}
    }
    return 0;
}

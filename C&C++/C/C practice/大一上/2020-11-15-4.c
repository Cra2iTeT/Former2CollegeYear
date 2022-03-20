#include<stdio.h>
void mycat(int a[],int b[]);
int main()
{
	int i,a[999],b[999];
	for(i=0;i<999||a[i]!='\0';i++){
		scanf("%c",&a[i]);
	}
	for(i=0;i<999||b[i]!='\0';i++){
		scanf("%c",&b[i]);
	}
	mycat(a,b);
	return 0;
}

//连接并输出两个字符串数组

void mycat(int a[],int b[])
{
	int i,j;
	for(i=0;a[i]!='\0';i++);
	for(;b[i]!='\0';i++){
		a[i]=b[i];
	}
	for(j=0;j<i;j++){
		printf("%c",a[i]);
	}
}  

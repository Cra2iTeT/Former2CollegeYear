#include<stdio.h>
int main()
{
	int a[11];
	int i,t;
	for(i=0;i<10;i++) scanf("%d",&a[i]);
	{
	int j,k;
	int temp;
	for(j=0;j<i;j++){					//排序
		for(k=j+1;k<i;k++){
			if(a[j]>a[k]){
				temp=a[k];
				a[k]=a[j];
				a[j]=temp;
				}
			}
		}
	}
	scanf("%d",&a[10]);
	for(i=0;i<10;i++){
		printf("%3d",a[i]);
	}
	printf("\n");
	int j,k,temp;
	for(j=0;j<11;j++){				//比较后插入
		for(k=j+1;k<11;k++){
			if(a[j]>a[k]){
				temp=a[k];
				a[k]=a[j];
				a[j]=temp;
			}
		}
	}
	for(i=0;i<11;i++){
		printf("%3d",a[i]);
	}
	printf("\n");
	return 0;
}

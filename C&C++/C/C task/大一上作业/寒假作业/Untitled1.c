#include <stdio.h>
#include <stdlib.h>
int main()
{
	int a,n;
	int count=0;
	int index=0;
	int b[1000000]={0};
	int temp;
	int t=1;
	scanf("%d %d",&a,&n);
	for(int i=0;i<n;i++)
	{
		temp=a*(n-i);
		index=count;
		while(temp){
			b[index]+=temp%10;
			temp/=10;
			if(b[index]>=10)
			{
				b[index]-=10;
				b[index+1]+=1;
			}
			index++;
		}
		count++;
	}
	for(int j=count;j>=0;j--)
	{
		if(flag&&b[count]==0){
			flag = 0;
			continue;
		}
		printf("%d",b[j]);
	}
    if(n==0) printf("0\n");
    return 0;
}

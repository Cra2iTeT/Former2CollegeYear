#include <stdio.h>
#define N 20

int f(int *p,int n,int k,int m){
	int i,j,count=n,b[N],amount=0;
	for(i=0;i<n;i++)b[i]=1;
    i=k-1;
	while(count>1){
		for(;i<n;i++)
			if(b[i]){
				amount++;
				if(amount==m){		//ÌôÈË 
					b[i]=0;
					amount=0;
					count--;
				}
			}
        if(i==n){		//Ñ­»· 
        	if(b[i]!=0)	amount++;
			i=0;
		}
	}
	for(i=0;i<n;i++)
		if(b[i]) return i+1;
}

int main(){
    int i,n,m,k,a[N];
    scanf("%d%d%d",&n,&k,&m);
    for(i=0;i<n;i++)
        a[i]=1;
    printf("%d",f(a,n,k,m));
    return 0;
}

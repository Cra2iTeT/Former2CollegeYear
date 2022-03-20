#include <stdio.h>
#define N 12
int itoa(long int i,char a[])
{
    int n,j=i,k=i;
    char A;
    if(i>0){
    	for(n=0;n<N&&j!=0;n++) j=j/10;
    	for(j=0;j<n;j++){
    		a[j]=k%10+'0';
			k=k/10;
		}
		for(i=0;i<n;i++){
			for(j=i+1;j<n;j++){
				A=a[j];
				a[j]=a[i];
				a[i]=A;
			}
		}
	}
    if(i==0) a[0]='0';
	else if(i<0){
		j=-j;
		k=-k;
    	for(n=0;n<N&&j!=0;n++) j=j/10;
    	a[n]='-';
        a[n+1]=0;
    	for(j=0;j<n;j++){
    		a[j]=k%10+'0';
			k=k/10;
		}
		for(i=0;i<n;i++){
			for(j=i+1;j<=n;j++){
				A=a[j];
				a[j]=a[i];
				a[i]=A;
			}
		}
	}
	return (a);
}
int main(){
    long int n;
    char a[N];
    scanf("%ld",&n);
    itoa(n,a);
    printf("%s",a);
    return 0;
}

#include <stdio.h>
void solve(int x)
{
	int i=2,t=x;
	for(i=2;i<=t&&t!=1;){
		while(t%i==0&&t!=1){
			t=t/i;
			if(t!=1) printf("%d*",i);
			else if(t==1) printf("%d\n",i);
		}
		while(t%i!=0&&t!=1){
			i++;
		}
	}
}
int main(){
    void solve(int);
    int x;
    scanf("%d",&x);
    if(x<2)  printf("error data");
    else{
        printf("%d=",x);
        solve(x);
    }
    return 0;
}

#include<stdio.h>
int gcd(int a,int b)
{
	int min;
	if(a==b) return a;
	if(a>b){		//Õ·×ªÏà³ı 
		int t,T;
		min=b;
		T=a;
		t=T%min;
		while(t!=0){
			T=min;
			min=t;
			t=T%min;
		}
		return min;
	}
	if(a<b){
		int t,T;
		min=a;
		T=b;
		t=T%min;
		while(t!=0){
			T=min;
			min=t;
			t=T%min;
		}
		return min;
	} 
}
int main(){
    int a,b;
    scanf("%d%d",&a,&b);
    printf("%d",gcd(a,b));
    return 0;
}

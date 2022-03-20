#include<stdio.h>
int main(){
	int m;
	scanf("%d",&m);
	int s1=0,s2=0;
	int i;
	for(i=1;i<m;i++){
		s1+=3;
		s2+=9;
		if(i%10==0){
			if(s2>s1){
				i+=30;
				s1+=3*30;
			}
		}
	}
	if(s2>s1){
		printf("^_^ %d",s2);
	}
	if(s2<s1){
		printf("@_@ %d",s1);
	}
	if(s2==s1){
		printf("-_- %d",s2);
	}
	return 0;
}

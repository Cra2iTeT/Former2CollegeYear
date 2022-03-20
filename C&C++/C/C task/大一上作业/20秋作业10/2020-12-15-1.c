#include<stdio.h>
int main( ){

struct Node{
	char no[9];
	char name[21];
	float score1;
	float score2;
	float average;
}s[3];

int i,max=0;
for(i=0;i<3;i++){
	scanf("%s %s %f %f",&s[i].no,&s[i].name,&s[i].score1,&s[i].score2);
    s[i].average=(s[i].score1+s[i].score2)/2;
}
for(i=1;i<3;i++){
    if((s[max].average)<(s[i].average)) max=i;
}
printf("%10.1f%10.1f%10.1f",s[0].average,s[1].average,s[2].average);
printf("\nNo=%s,Name=%s,Score1=%.1f,Score2=%.1f,Average=%.1f",s[max].no,s[max].name,s[max].score1,s[max].score2,s[max].average);
    return 0 ;
}

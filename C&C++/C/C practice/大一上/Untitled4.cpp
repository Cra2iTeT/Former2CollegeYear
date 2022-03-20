#include<stdio.h>
int main( ){
	int i,j;
	struct stu{
		char no[8];
		char name[20];
		double score1;
		double score2;
	}stu[4];
	for(j=0;j<3;j++){		/*ÊäÈë*/ 
		for(i=0;i<8;i++)
			scanf("%c",&stu[j].no[i]);
			getchar();
		for(i=0;i<20&&stu[j].name[i]!='\0';i++);
			scanf("%c",&stu[j].name[i]);
			getchar();
		scanf("%lf",&stu[i].score1);
		getchar;
		scanf("%lf",&stu[i].score2);
		getchar;
	}
	double sum[3]={0.0},ave[3]={0.0};
	for(i=0;i<3;i++){
		sum[i]=stu[i].score1+stu[i].score2;
		ave[i]=sum[i]/2;
		printf("%10.1lf",ave[i]);
	}
	double m=sum[0];
	for(i=1,j=0;i<3;i++)
		if(m<sum[i]){
			m=sum[i];
			j=i;
		}
	int max=4;
	struct stu s[max]
    printf("\nNo=%s,Name=%s,Score1=%.1f,Score2=%.1f,Average=%.1f",s[max].no,s[max].name,s[max].score1,s[max].score2,s[max].average);
    return 0;
}

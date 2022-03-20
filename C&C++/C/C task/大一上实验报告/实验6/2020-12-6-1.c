#include <stdio.h>
#define N 5
struct Student
{
	char num[8];
	char name[20];
	int score[3];
};

void couAver(struct Student stu[],int n)
{
	int i,j;
	double sum=0.0;
	for(i=0;i<3;i++){				/*计算单科平均分*/ 
		for(sum=0,j=0;j<n;j++){
			sum+=stu[j].score[i];
		}
		printf("%5.1lf",sum/n);
	}printf("\n");
}

void max(struct Student stu[],int n)
{
	int i,max1,max2;
	max1=stu[0].score[0]+stu[0].score[1]+stu[0].score[2];
	for(i=1;i<n;i++){
		max2=stu[i].score[0]+stu[i].score[1]+stu[i].score[2];
		if(max1>=max2);
		else max1=max2;
	}
	for(i=0;i<n;i++){
		max2=stu[i].score[0]+stu[i].score[1]+stu[i].score[2];
		if(max2==max1){
			printf("%s,%s,%d,%d,%d,%d\n",stu[i].num,stu[i].name,stu[i].score[0],stu[i].score[1],stu[i].score[2],max1);
		}
	}
}

int main(){
    struct Student stu[N];
    int i,j;
    char ch;
    for(i=0; i<N; i++){
        gets(stu[i].num);
        gets(stu[i].name);
        for(j=0; j<3; j++)
            scanf("%d",&(stu[i].score[j]));
        while((ch = getchar()) != '\n' && ch != EOF);//清空输入缓冲区
    }
    couAver(stu,N);//输出各科平均成绩
    max(stu,N);//输出总分最高的学生的数据
    return 0;
}

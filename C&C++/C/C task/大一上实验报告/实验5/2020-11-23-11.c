#include <stdio.h>
#include <math.h>
#define N 10
void aver(int a[][5],double ave[],int n)/*功能为计算每位学生的平均分*/
{
	int i,j;
	double sum;
	for(j=0;j<n;j++){
        sum=0.0;
		for(i=0;i<5;i++){
			sum+=a[j][i]+0.0;
		}
		ave[j]=sum/5;
	}
}
void couAver(int a[][5],double couAve[5],int n)/*功能为计算每门课程的平均分*/
{
	int i,j;
	double sum;
	for(i=0;i<5;i++){
        sum=0.0;
		for(j=0;j<n;j++){
			sum+=a[j][i]+0.0;
		}
		couAve[i]=sum/n;
	}
}

	void max(int a[][5],char courName[][10],int n)
{
	int i,j,k;
    printf("Max:\n");
    int max=a[0][0];
    for(i=0;i<n;i++)
        for(j=1;j<5;j++)
        if(max<a[i][j])
        max=a[i][j];
    for(i=0;i<n;i++)
        for(j=0;j<5;j++)
        if(a[i][j]==max)
    {
        printf("No.%d",i+1);
        printf("[");
        for(k=0;courName[j][k]!='\0';k++)
        printf("%c",courName[j][k]);
        printf("]");
        printf("=%d\n",max);
    }
}
double averVari(double ave[],int n)/*功能为计算n名同学的平均分方差*/
{
	int i;
	double p;		//p表示总平均分 
	double sum=0.0;
	for(i=0;i<n;i++){
		sum+=ave[i];
	}
	p=sum/n;
	sum=0.0;
	for(i=0;i<n;i++){
		sum+=(ave[i]-p)*(ave[i]-p);
	}
	p=sum;
	p=p/n;
	return p;
}
int main(){
    char courName[5][10];/*课程名称*/
    int n,i,j,a[N][5];/*n学生人数，a学生成绩*/
    double ave[N],couAve[5];/*ave学生平均成绩，couAve课程平均成绩*/
    for(i=0; i<5; i++)
        gets(courName[i]);
    scanf("%d",&n);
    for(i=0; i<n; i++)
        for(j=0; j<5; j++)
            scanf("%d",&a[i][j]);
    aver(a,ave,n);
    printf("Average:\n");
    for(i=0; i<n; i++){
        printf("[No.%d]Average=%f\n",i+1,ave[i]);
    }
    couAver(a,couAve,n);
    printf("CourseAverage:\n");
    for(i=0; i<5; i++){
        printf("[%s]CourseAverage=%f\n",courName[i],couAve[i]);
    }
    max(a,courName,n);
    printf("Averagevariance=%f",averVari(ave,n));
    return 0;
}

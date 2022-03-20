#include <stdio.h>
#include <string.h>
#define N 30

struct Worker{
	char id[8];
	char name[20];
	char sex;
	int workAge;
	double wage;
};

void input(struct Worker a[],int n){		/*输入n名职工的数据并存储在a数组中*/
	int i;
	for(i=0;i<n;i++){
		getchar();
		gets(a[i].id);
		gets(a[i].name);
		scanf("%1c",&a[i].sex);
		scanf("%d",&a[i].workAge);
		scanf("%lf",&a[i].wage);
	}
}

void output(struct Worker a[],int n){		/*输出a数组中存储的n名职工的数据*/
	int i;
	for(i=0;i<n;i++){
		printf("ID=%s,Name=%s,Sex=%c,WorkAge=%d,wage=%.2f\n",a[i].id,a[i].name,a[i].sex,a[i].workAge,a[i].wage);
	}
}

double wageSummary(struct Worker a[],int n){		/*是汇总输出a数组中存储的n名职工的总薪金*/
	int i;
	double sum=0.0;
	for(i=0;i<n;i++){
		sum+=a[i].wage;
	}
	return sum; 
}

double averWorkAge(struct Worker a[],int n){		/*计算a数组中存储的n名职工的平均工龄*/
	int i;
	double aveAge=0.0;
	for(i=0;i<n;i++){
		aveAge+=a[i].workAge;
	}
	aveAge=aveAge/n;
	return aveAge;
}

double averWage(struct Worker a[],int n){		/*计算a数组中存储的n名职工的平均薪金*/
	int i;
	double aveWage=0.0;
	for(i=0;i<n;i++){
		aveWage+=a[i].wage;
	}
	aveWage=aveWage/n;
	return aveWage;
}

int maleCount(struct Worker a[],int n){		/*是统计a数组存储的n名职工中男性职工的数量*/
	int i,count;
	for(i=0,count=0;i<n;i++){
		if((a[i].sex)=='M'||(a[i].sex)=='m')
			count++;
	}
	return count;
}

int femaleCount(struct Worker a[],int n){		/*统计a数组存储的n名职工中女性职工的数量*/
	int amount;
	amount=maleCount(a,n);
	amount=n-amount;
	return amount;
}

int searchID(struct Worker a[],char id[],int n){		/*在a数组中查找工号等于id的职工的下标，若找不到则返回-1*/
	int i,j;
	int c=-1;
	for(i=0;i<n;i++){
		for(j=0;j<8&&id[j]!='\0'&&a[i].id[j]!='\0';j++){
			if(a[i].id[j]==id[j]) c=1;
			else c=-1;
		}
        if((id[j]=='\0')&&(a[i].id[j]=='\0')&&c==1) return c;
        else c=-1;
	}
	return c;
}

int searchName(struct Worker a[],char name[],int n){		/*在a数组中查找姓名等于name的职工的下标，若找不到则返回-1*/
	int i,j;
	int c=-1;
	for(i=0;i<n;i++){
		for(j=0;j<20&&name[j]!='\0'&&a[i].name[j]!='\0';j++){
			if(a[i].name[j]==name[j]) c=1;
			else c=-1;
		}
        if((name[j]=='\0')&&(a[i].name[j]=='\0')&&c==1) return c;
        else c=-1;
	}
	return c;
}

void sortWorkAge(struct Worker a[],int n){		/*将a数组存储的n名职工按照工龄从小到大的顺序重新存储*/
	int i,j;
	struct Worker b;
	for(i=0;i<n;i++){
		for(j=i+1;j<n;j++){
			if(a[i].workAge>a[j].workAge){
				b=a[i];
				a[i]=a[j];
				a[j]=b;
			}
		}
	}
}

int main(void){
    struct Worker work[N];
    int n,t;
    char ch,id[10],name[20];
    scanf("%d",&n);
    input(work,n);
    printf("WageSummary=%.2lf,averWage=%.2lf\n",wageSummary(work,n),averWage(work,n));
    printf("averWorkAge=%.1lf\n",averWorkAge(work,n));
    printf("maleCount=%d,femaleCount=%d\n",maleCount(work,n),femaleCount(work,n));
    while((ch = getchar()) != '\n' && ch != EOF);
    gets(id);
    if((t=searchID(work,id,n))>=0)
        printf("ID=%s,Name=%s,Sex=%c,WorkAge=%d,wage=%.2f\n",work[t].id,work[t].name,work[t].sex,work[t].workAge,work[t].wage);
    else printf("ID=%s not found\n",id);
    gets(name);
    if((t=searchName(work,name,n))>=0)
        printf("ID=%s,Name=%s,Sex=%c,WorkAge=%d,wage=%.2f\n",work[t].id,work[t].name,work[t].sex,work[t].workAge,work[t].wage);
    else printf("Name=%s not found\n",name);
    sortWorkAge(work,n);
    output(work,n);
    return 0;
}

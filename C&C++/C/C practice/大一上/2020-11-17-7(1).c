#include<stdio.h>
int main()
{
	int n,i=0,j,count;
	int max,min;
	int a[5][5]={0};
	int b[10][3]={0};		//记录行列最值的坐标 
	for(i=0;i<5;i++){
		for(j=0;j<5;j++){
			scanf("%d",&a[i][j]);
		}
		setbuf(stdin,NULL);
	}
	
	//排各行最大
	
	n=0,j=0,count=0,min=0,max=0;
	for(i=0,count=0;i<5;i++){
		max=a[i][j];
		b[count][0]=i;
		b[count][1]=j;
		b[count][2]=a[i][j];
		for(j=0;j<4;j++){
			if(max>=a[i][j+1]);
			else{
				b[count][0]=i;
				b[count][1]=j+1;
				b[count][2]=a[i][j+1];
				max=a[i][j+1];
			}
		}
		printf("%3d%3d%3d\n",b[count][0],b[count][1],b[count][2]);
		j=0;
		count++;
	//printf("%5d\n",max);
	}
	i=0;
	
	//排各列最小
	
	n=0,j=0,count=0,min=0,max=0;
	for(j=0;j<5;j++){
		min=a[i][j];
		b[count][0]=i;
		b[count][1]=j;
		b[count][2]=a[i][j];
		for(i=0;i<4;i++){
			if(min<=a[i+1][j]);
			else{
				b[count][0]=i+1;
				b[count][1]=j;
				b[count][2]=a[i+1][j];
				min=a[i+1][j];
			}
		}
		printf("%3d%3d%3d\n",b[count][0],b[count][1],b[count][2]);
		i=0;
		count++;
	//printf("%5d\n",min);
	}
	for(count=0;count<5;count++){
		i=b[count][1];
		j=i+5;
		//printf("%d",i);
		if((b[count][0]==b[i][0])&&(b[count][1]==b[i][1])&&(b[count][2]==b[i][2])){
			printf("[%d,%d,%d]",b[count][0],b[count][1],b[count][2]);
		}
	}
/*	for(;count<10;count++){
		i=b[count][1];
		j=i+5;
		//printf("%d",i);
		if((b[count][0]==b[i][0])&&(b[count][1]==b[i][1])&&(b[count][2]==b[i][2])){
			printf("[%d,%d,%d]",b[count][0],b[count][1],b[count][2]);
		}
	}*/
}

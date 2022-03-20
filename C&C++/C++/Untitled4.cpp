#include<iostream>
using namespace std;

int main(){
    int len=0;
    
    int *A=new int[999];
    
    int d;
    cin>>d;
    int i=0;
    int flag=1;
    while(d!=-1){//导入第一行数据 
    	flag=1;
    	for(i=0;i<len&&flag==1;i++){
    		if(d==A[i]){
    			flag=0;
			}
		}
		if(flag){
			A[len++]=d;
		}
		cin>>d;
	}
	
	cin>>d;
	while(d!=-1){//导入第二行数据 
		flag=1;
		for(i=0;i<len&&flag==1;i++){
			if(d==A[i]){
				flag=0;
			}
		}
		if(flag){
			A[len++]=d;
		}
		cin>>d;
	}
	
	int j=0;
	for(i=0;i<len-1;i++){
		for(j=i+1;j<len;j++){
			if(A[i]>A[j]){
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
	}
	
	for(i=0;i<len-1;i++){
		cout<<A[i]<<",";
	}
	cout<<A[i];
}

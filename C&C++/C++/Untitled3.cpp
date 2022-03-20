#include<iostream>
using namespace std;

int main(){
    int lenA=0;
    int lenB=0;
    
    int *A=new int[100];
    int *B=new int[100];
    
    int d;
    cin>>d;
    int i=0;
    while(d!=-1){
        A[i]=d;
        cin>>d;
        lenA++;
        i++;
    }
	
    i=0;
    cin>>d;
    while(d!=-1){
        B[i]=d;
        cin>>d;
        lenB++;
        i++;
    }
    int j;
    
    for(i=0;i<lenA;i++){
        for(j=i+1;j<lenA;j++){
            if(A[i]<A[j]){
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
    }
    
    for(i=0;i<lenB;i++){
        for(j=i+1;j<lenB;j++){
            if(B[i]<B[j]){
                int temp=B[i];
                B[i]=B[j];
                B[j]=temp;
            }
        }
    }
    
    int *C=new int[lenA+lenB+1];
    C[0]=-1111;
    j=lenA-1;
    int k=lenB-1;
	
	int flag=0;
    
    for(i=1;i<lenA+lenB+1&&flag==0;){
    	cout<<i<<"---"<<A[j]<<"---"<<B[k]<<endl;
    	if(C[i-1]==A[j]&&j>=0){
    		j--;
		}
		if(C[i-1]==B[k]&&k>=0){
			k--;
		}
		cout<<i<<"---"<<A[j]<<"---"<<B[k]<<endl;
        
        if(A[j]<B[k]){
            C[i]=A[j];
            j--;
        }else if(A[j]>B[k]){
            C[i]=B[k];
            k--;
        }else if(A[j]==B[k]){
            C[i]=B[k];
            j--;
            k--;
		}
		cout<<i<<"---"<<A[j]<<"---"<<B[k]<<"---"<<C[i]<<endl<<endl;
		if(j<0)
			flag=1;
		if(k<0)
			flag=2;
			
		i++;
    }
    
    if(flag==1){
		for(;k>=0;){
			if(C[i-1]==B[k]){
				k--;
				continue;
			}
			else
				C[i]=B[k];
			i++,k--;
		}
	}
	
	if(flag==2){
		for(;j>=0;){
			if(C[i-1]==A[j]){
				k--;
				continue;
			}
			else
				C[i]=A[j];
			i++,j--; 
		}
	}
    for(j=1;j<i-1;j++){
        cout<<C[j]<<",";
    }
    cout<<C[j];
}

#include <iostream>
using namespace std;

#define MAXSIZE 50
typedef int KeyType;

typedef  struct                     
{ KeyType  key;                                             
} ElemType;  

typedef  struct
{ ElemType  *R; 
  int  length;
} SSTable;                      

void  Create(SSTable &T)
{ int i;
  T.R=new ElemType[MAXSIZE+1];
  cin>>T.length;
  for(i=1;i<=T.length;i++)
     cin>>T.R[i].key;   
}

int  Search_Bin(SSTable T, KeyType k);

int main () 
{  SSTable T;  KeyType k;
   Create(T);
   cin>>k;
   int pos=Search_Bin(T,k);
   if(pos==0) cout<<"NOT FOUND"<<endl;
   else cout<<pos<<endl;
   return 0;
}

/* 请在这里填写答案 */
int  Search_Bin(SSTable T, KeyType k)
{
	int iLeft=1;	//记录左值
	int iRight=T.length;
	int iMid=1;	//记录中值
	bool bFlag=false;
	while(iLeft<iRight)
	{
		iMid=(iLeft+iRight)/2;
		if(T.R[iMid].key==k)
		{
			bFlag=true;
			break;
		}
		if(T.R[iMid].key>k)
		{
			iRight=iMid-1;
		}
		else{
			iLeft=iMid+1;
		}
	 } 
    if(bFlag)
	{
		return iMid;
	}	
	else{
		return 0;
		}
}

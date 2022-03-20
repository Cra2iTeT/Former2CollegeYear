/*
* �ļ�����main.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/28
* �ļ����ݣ��˻�������Ϸ 
* ��ǰ�汾��1.0
*/

#include<iostream>
#include<ctime>
#include<conio.h>
#include<cstdlib>
#include<string>
using namespace std;


/*
* ������ã�CPanel������������
* ���ʹ�ã�CPanel cp;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/28
*/
class CPanel{
	public:
		string cC,cB,cK;
		int iScoreB;
		int iScoreC;
		int iCWin,iBWin;	//��¼ʤ����� 
		int iIndex;	//��¼���Ӳ���
		
		CPanel(){
			int iI=0,iJ;
			for(;iI<3;iI++){
				for(iJ=0;iJ<3;iJ++){
					iA[iI][iJ]=0;
				}
			}
			iScoreB=0;
			iScoreC=0;
			iBWin=0;
			iCWin=0;
			cK="*";
			iIndex=0;
		}
		~CPanel(){
		}
		
		int iA[3][3];	//���� 
		void setC(int i,int j){	//�����������ֵ 
			iA[i][j]=1;
		}
		void setB(int i,int j){	//������������ֵ 
			iA[i][j]=-1;
		}
		
		int get(int i,int j){	//��������ֵ 
			return iA[i][j];
		}
		
		
		void Menu();	//�����˵�
		
		void startGame();	//��Ϸ����
		
		void print();	//��ӡ��ǰ����
		void logic();	//��Ϸ�߼� 
		
		void count();	//�����ʤ��
		void init(){
			int iI=0,iJ;
			for(;iI<3;iI++){
				for(iJ=0;iJ<3;iJ++){
					iA[iI][iJ]=0;
				}
			}
			iBWin=0;
			iCWin=0;
			iIndex=0;
		}
};

/*
*��ʾ�˵�
*�޲�
*�޷���ֵ 
*/
void CPanel::Menu(){
	cout<<"1.��ʼ��Ϸ"<<endl;
	cout<<"2.��ѯ�÷�"<<endl;
	cout<<"3.�˳���Ϸ"<<endl;
	cout<<"�����룺";
}

/*
*��Ϸ��ʼ���� 
*�޲�
*�޷���ֵ 
*/
void CPanel::startGame(){
	cout<<"��ѡ��������ӣ�����1ѡ��X ��,����2ѡ��O ��";
	cout<<"��������:";
	int iIndex=0;
	cin>>iIndex;
	 if(iIndex==1){
	 	cC="X";
	 	cB="O";
	 }
	 else{
	 	cC="O";
	 	cB="X";
	 }
}

/*
*��ӡ���� 
*�޲�
*�޷���ֵ 
*/
void CPanel::print(){
	int iI=0,iJ;
	for(iI=0;iI<3;iI++){
		cout<<"-----------"<<endl;
		for(iJ=0;iJ<3;iJ++){
			if(iA[iI][iJ]==0){
			cout<<"  "<<cK;
			}
			else if(iA[iI][iJ]==1){
				cout<<"  "<<cC;
			}
			else if(iA[iI][iJ]==-1){
				cout<<"  "<<cB;
			}
		}
		cout<<endl;
	}
	cout<<"-----------"<<endl;
} 

/*
*��Ϸ�߼�
*�޲�
*�޷���ֵ 
*/
void CPanel::logic(){
	while(iIndex<9&&iCWin==0&&iBWin==0){
		while(1){
			cout<<"��������Ҫ�µ�������";
			int iRow;
			cin>>iRow;
			cout<<"��������Ҫ�µ�������";
			int iCol;
			cin>>iCol;
			if(iA[iRow-1][iCol-1]!=0){
			cout<<"���Ӵ��������λ���Ƿ��Ѿ������Ӳ���������"<<endl;
			}
			else if(iA[iRow-1][iCol-1]==0){
				setC(iRow-1,iCol-1);
				//iA[iRow-1][iCol-1]=1;
				cout<<"���ӳɹ�"<<endl<<endl;
				break;
			}
		}
		if(iCWin==0){
			if((get(0,0)+get(1,1)+get(2,2)==3)){//159
				iCWin=1;
				iScoreC+=100;
			}
			else if((get(0,0)+get(0,1)+get(0,2)==3)){//123
				cout<<"123";
				iCWin=1;
				iScoreC+=100;
			}
			else if((get(0,0)+get(1,0)+get(2,0))==3){//147
				iCWin=1;
				iScoreC+=100;
			}
			else if(get(0,1)+get(1,1)+get(2,1)==3){//258
				iCWin=1;
				iScoreC+=100;
			}
			else if(get(0,2)+get(1,1)+get(2,0)==3){//357
				iCWin=1;
				iScoreC+=100;
			}
			else if(get(0,2)+get(1,2)+get(2,2)==3){//369
				iCWin=1;
				iScoreC+=100;
			}
			else if(get(1,0)+get(1,1)+get(1,2)==3){//456
				iCWin=1;
				iScoreC+=100;
			}
			else if(get(2,0)+get(2,1)+get(2,2)==3){//789
				iCWin=1;
				iScoreC+=100;
			}
		}
		if(iCWin==0){
			srand((unsigned)time(0));
			int iNum=(rand() % (10 - 1)) + 1;
			if(iNum<10&&iNum>2){
				count();
				//cout<<"������1"<<endl; 
			}else{
				//cout<<"������3"<<endl; 
				int iEmpty=1;
				while(iEmpty==1){		
				//cout<<"������4"<<endl; 	
				//srand((unsigned)time(0));	//����������������ظ� 				
				int i_Row=(rand() % (3 - 0)) + 0;	//�����
				//cout<<"---"<<i_Row<<endl;
				int i_Col=(rand() % (3 - 0)) + 0;
				//cout<<"---"<<i_Col<<endl;
					if(iA[i_Row][i_Col]==0){
						iEmpty=0;
						//iA[i_Row][i_Col]==-1;
						setB(i_Row,i_Col);
						//cout<<iA[i_Row][i_Col]<<endl;
						//cout<<"������5"<<endl;
						//cout<<iEmpty<<endl;
					}
				}
			//cout<<"������2"<<endl;
			}
		}
		if(iBWin==0){
       		if(get(0,0)+get(0,1)+get(0,2)==-3){//123
				iBWin=1;
				iScoreB+=100;
			}
			else if(get(0,0)+get(1,0)+get(2,0)==-3){//147
				iBWin=1;
				iScoreB+=100;
			}
			else if(get(0,1)+get(1,1)+get(2,1)==-3){//258
				iBWin=1;
				iScoreB+=100;
			}
			else if(get(0,2)+get(1,1)+get(2,0)==-3){//357
				iBWin=1;
				iScoreB+=100;
			}
			else if(get(0,2)+get(1,2)+get(2,2)==-3){//369
				iBWin=1;
				iScoreB+=100;
			}
			else if(get(1,0)+get(1,1)+get(1,2)==-3){//456
				iBWin=1;
				iScoreB+=100;
			}
			else if(get(2,0)+get(2,1)+get(2,2)==-3){//789
				iBWin=1;
				iScoreB+=100;
			}
			iIndex++;
			print();
			}
		}
		//cout<<"������"<<endl; 
	
	
	if(iIndex==9&&iCWin==0&&iBWin==0){
		cout<<"����ƽ��"<<endl<<endl;
	}
	if(iBWin!=0){
		cout<<"���ֵ��Ի�ʤ"<<endl<<endl;
	}
	if(iCWin!=0){
		cout<<"������һ�ʤ"<<endl<<endl;
	}
}

/*
*�������Ӯ�İ취 
*�޲�
*�޷���ֵ 
*/
void CPanel::count(){
	if(iA[0][0]+iA[1][1]+iA[2][2]<-1){//159
		if(iA[0][0]==0){
			//iA[0][0]=-1;
			setB(0,0);
		}
		else if(iA[1][1]==0){
			//iA[1][1]=-1;
			setB(1,1);
		}
		else if(iA[2][2]==0){
			//iA[2][2]=-1;
			setB(2,2);
		}
		//cout<<"159"<<endl;
		return;
	}
	else if(iA[0][0]+iA[0][1]+iA[0][2]<-1){//123
		if(iA[0][0]==0){
			//iA[0][0]=-1;
			setB(0,0);
		}
		else if(iA[0][1]==0){
			//iA[0][1]=-1;
			setB(0,1);
		}
		else if(iA[0][2]==0){
			//iA[0][2]=-1;
			setB(0,2);
		}
		//cout<<"123"<<endl;
		return;
	}
	else if(iA[0][0]+iA[1][0]+iA[2][0]<-1){//147
		if(iA[0][0]==0){
			//iA[0][0]=-1;
			setB(0,0);
		}
		else if(iA[1][0]==0){
			//iA[1][0]=-1;
			setB(1,0);
		}
		else if(iA[2][0]==0){
			//iA[2][0]=-1;
			setB(2,0);
		}
		//cout<<"147"<<endl;
		return;
	}
	else if(iA[0][1]+iA[1][1]+iA[2][1]<-1){//258
		if(iA[0][1]==0){
			//iA[0][1]=-1;
			setB(0,1);
		}
		else if(iA[1][1]==0){
			//iA[1][1]=-1;
			setB(1,1);
		}
		else if(iA[2][1]==0){
			//iA[2][1]=-1;
			setB(2,1);
		}
		//cout<<"258"<<endl;
		return;
	}
	else if(iA[0][2]+iA[1][1]+iA[2][0]<-1){//357
		if(iA[0][2]==0){
			//iA[0][2]=-1;
			setB(0,2);
		}
		else if(iA[1][1]==0){
			//iA[1][1]=-1;
			setB(1,1);
		}
		else if(iA[2][0]==0){
			//iA[2][0]=-1;
			setB(2,0);
		}
		//cout<<"357"<<endl;
		return;
	}
	else if(iA[0][2]+iA[1][2]+iA[3][2]<-1){//369
		if(iA[0][2]==0){
			//iA[0][2]=-1;
			setB(0,2);
		}
		else if(iA[1][2]==0){
			//iA[1][2]=-1;
			setB(1,2);
		}
		else if(iA[3][2]==0){
			//iA[3][2]=-1;
			setB(3,2);
		}
		//cout<<"369"<<endl;
		return;
	}
	else if(iA[1][0]+iA[1][1]+iA[1][2]<-1){//456
		if(iA[1][0]==0){
			//iA[1][0]=-1;
			setB(1,0);
		}
		else if(iA[1][1]==0){
			//iA[1][1]=-1;
			setB(1,1);
		}
		else if(iA[1][2]==0){
			//iA[1][2]=-1;
			setB(1,2);
		}
		//cout<<"456"<<endl;
		return;
	}
	else if(iA[2][0]+iA[2][1]+iA[2][2]<-1){//789
		if(iA[2][0]==0){
			//iA[2][0]=-1;
			setB(2,0);
		}
		else if(iA[2][1]==0){
			//iA[2][1]=-1;
			setB(2,1);
		}
		else if(iA[2][2]==0){
			//iA[2][2]=-1;
			setB(2,2);
		}
		//cout<<"789"<<endl;
		return;
	}
	int iEmpty=1;
	//srand((unsigned)time(0));
	while(iEmpty==1){
		//cout<<"������555"<<endl; 
		int i_Row=(rand() % (3 - 0)) + 0;	//�����
		int i_Col=(rand() % (3 - 0)) + 0;
		//cout<<i_Row<<endl;
		//cout<<i_Col<<endl;
		if(iA[i_Row][i_Col]==0){
			iEmpty=0;
			//cout<<"�ҵ�����555"<<endl;
			//iA[i_Row][i_Col]==-1;
			setB(i_Row,i_Col);
			//cout<<iA[i_Row][i_Col]<<endl;
		}
	}
} 
int main(){
	
	CPanel cp;
	//cp.show();
	//cp.startGame();
	//cp.print();
	while(1){
		cp.Menu();
		int iChoice;
		cin>>iChoice;
		switch(iChoice){
			case 1:{
				cp.startGame();
				cp.print();
				cp.logic();
				cp.init();
				break;
			}
			case 2:
				cout<<"��ĵ÷�Ϊ��"<<cp.iScoreC<<endl;
				cout<<"���Եĵ÷�Ϊ��"<<cp.iScoreB<<endl<<endl;
				break;
			case 3:
				cout<<"��Ϸ���˳�"<<endl<<endl;
				exit(0);
		}
	}
}

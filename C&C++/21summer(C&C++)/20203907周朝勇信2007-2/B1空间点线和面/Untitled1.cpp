/*
* �ļ�����main.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/27
* �ļ����ݣ��������Ϸ 
* ��ǰ�汾��1.0
*/
#include<iostream>

using namespace std;


/*
*��ʾ�˵�
*�޲�
*�޷���ֵ 
*/
void show(){
	cout<<"1.��ʼ��Ϸ"<<endl;
	cout<<"2.��ѯ�÷�"<<endl;
	cout<<"3.�˳���Ϸ"<<endl;
	cout<<"�����룺";
}


void print(int iA[]){
	int iI;
	cout<<"---------"<<endl;
	for(iI=0;iI<3;iI++){
		if(iA[iI]==0){
			cout<<" X O";
		}
	}
	cout<<"---------"<<endl;
	
	cout<<"---------"<<endl;
	
	cout<<"---------"<<endl;
	
}


/*
*��Ϸ����
*���������ɵ���������û���Ҫ���޶�ʱ��
*����ֵ���¶ԵĻ��������ɵ��������û�¶����������
*/
int game(int *iA[]){
	/*cout<<"��ѡ��������ӣ�����1ѡ��X ��,����2ѡ��O ��";
	 int iIndex=0;
	 cint>>iIndex;
	 if(iIndex==1){
	 	cC="X";
	 	cB="O";
	 }
	 else{
	 	cC="O";
	 	cB="X";
	 }
	 int iIl
	 for(iI=0;iI<9;iI++){
	 	iA[iI]=0;
	 }*/
	 print(&iA);
	 return 0;

}




int main(){
	int iScoreB=0;	//���Է���
	int iScoreC=0;	//�û�����
	int iA[9];	//���� 
	char cC[1],cB[1];	//�ֱ��ʾ�û�ѡ������ӡ�����ѡ��������Լ��հ�����
	char cK="*";
	game(iA);
	/*while(1){
		show();
		int iChoice;
		cin>>iChoice;
		
		switch(iChoice){
			case 1:{
				cout<<"��ʤ����10���֣��ܷ���2����" 
				
				�����С�XX������50�� 
				�����С�OO������25��
				�����С�X*������10��
				�����С�O*������8��
				�����С�**������4��
				
				break;
			}
			case 2:
				cout<<"��ĵ÷�Ϊ��"<<iScore<<endl<<endl;
				break;
			case 3:
				cout<<"��Ϸ���˳�"<<endl<<endl;
				exit(0);
		}
	}*/
}

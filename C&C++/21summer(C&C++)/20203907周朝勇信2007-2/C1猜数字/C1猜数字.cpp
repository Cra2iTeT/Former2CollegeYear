/*
* �ļ�����main.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/27
* �ļ����ݣ��������Ϸ 
* ��ǰ�汾��1.0
*/
#include<iostream>
#include<ctime>
#include<conio.h>
#include<cstdlib>
#include<cstdio>
using namespace std;

/*
*��ʾ�˵�
*�޲�
*�޷���ֵ 
*/
void show(){
	cout<<"1.��ʼ��Ϸ"<<endl;
	cout<<"2.��ѯ�÷�"<<endl;
	cout<<"2.�˳���Ϸ"<<endl;
	cout<<"�����룺";
}

/*
*��Ϸ����
*���������ɵ���������û���Ҫ���޶�ʱ��
*����ֵ���¶ԵĻ��������ɵ��������û�¶���������� 
*/
int game(int iNum,int iTime) {
int iIndex=0;
time_t tTimeBegin = time(0);
int iN=0;	//ʱ���� 
    while(true)  {
        if(kbhit()){       //detect the keyboard  ||  kbhit�������䣬�������������
            cin>>iIndex;
            
            if(iIndex==iNum){
            	cout<<"��ϲ����ȷ�³�����"<<iNum<<endl<<endl;
            	return iNum;
			}
			else if(iIndex>iNum){
				cout<<"����"<<endl;
			}
			else if(iIndex<iNum){
				cout<<"����"<<endl;
			}
			cout<<"��������룺";
        } else if(time(0)-tTimeBegin==iTime-5 && iN==0) {
            cout <<endl<< "��ʣ�£�"<<5<<"��"<<endl;	//�������ʱ
            iN=1;
        }
        else if(time(0)-tTimeBegin==iTime-4 && iN==1) {
            cout <<  "��ʣ�£�"<<4<<"��"<<endl;
            iN=2;
        }
        else if(time(0)-tTimeBegin==iTime-3 && iN==2) {
            cout << "��ʣ�£�"<<3<<"��"<<endl;
            iN=3;
        }
        else if(time(0)-tTimeBegin==iTime-2 && iN==3) {
            cout << "��ʣ�£�"<<2<<"��"<<endl;
            iN=4;
        }
        else if(time(0)-tTimeBegin==iTime-1 && iN==4) {
            cout << "��ʣ�£�"<<1<<"��"<<endl;
            iN=5;
        }
        else if(time(0)-tTimeBegin>=iTime){
            tTimeBegin = time(0);
            iN=0;
            cout<<"���ź���δ���ڹ涨ʱ���ڲ³���ȷ���֣�������Ϊ"<<iNum<<endl<<endl;
            return iN;
        }
    }
}

int main(){
	int iScore=0;	//��¼�÷�
	while(1){
		show();
		int iChoice;
		cin>>iChoice;
		switch(iChoice){
			case 1:{
				srand((unsigned)time(0));	//����������������ظ� 
				int iNum=(rand() % (10000 - 1)) + 1;	//�����
				cout<<"�����������"<<endl;
				//cout<<iNum<<endl;
				cout<<"�������ΧΪ1-10000��������10000"<<endl<<endl;
				cout<<"�������޶�ʱ�䣺";
				int iTime;
				cin>>iTime; 
				int iIndex;	//��ʱ���
				cout<<"��������Ĵ𰸣�";
				iIndex=game(iNum,iTime);
				if(iIndex==1){
					cout<<iNum<<endl<<endl;
				}
				if(iIndex==iNum){
					iScore++;
				}
				break;
			}
			case 2:
				cout<<"��ĵ÷�Ϊ��"<<iScore<<endl<<endl;
				break;
			case 3:
				cout<<"��Ϸ���˳�"<<endl<<endl;
				exit(0);
		}
	}
}



#include <windows.h> 
#include <iostream> 
  
int main() 
{
	showMenu();
	while(1){
		int iChoice;	//��¼ѡ��
		switch(iChoice){
			case 1:
				{
					srand((int)time(0));	//���������
					int iRandom=rand()%(10000-2)+2;
					cout<<"��������Ĵ𰸣�";
					int iAnswer;	//��¼��
					DWORD start, stop;
					unsigned int t = 0;
					if(iAnswer==iRandom){
						cout<<""
					}
				}
				break;
			case 2:
				cout<<"��Ϸ���˳�"<<endl;
				exit(0);
		}
	}
	DWORD start, stop;
	unsigned int t = 0;
	start = GetTickCount();
	while (t++ < 10e+7);
	stop = GetTickCount();
	printf("time: %lld ms\n", stop - start);
	return 0; 
}

/*
*��ʾ�˵�
*�޲�
*�޷���ֵ 
*/
void showMenu(){
	cout<<"1.��ʼ��Ϸ"<<endl;
	cout<<"2.�˳���Ϸ"<<endl;
	cout<<"�����룺"<<endl;
}

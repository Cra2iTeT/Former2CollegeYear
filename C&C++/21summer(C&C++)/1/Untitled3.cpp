#include <windows.h> 
#include <iostream> 
  
int main() 
{
	showMenu();
	while(1){
		int iChoice;	//记录选择
		switch(iChoice){
			case 1:
				{
					srand((int)time(0));	//产生随机数
					int iRandom=rand()%(10000-2)+2;
					cout<<"请输入你的答案：";
					int iAnswer;	//记录答案
					DWORD start, stop;
					unsigned int t = 0;
					if(iAnswer==iRandom){
						cout<<""
					}
				}
				break;
			case 2:
				cout<<"游戏已退出"<<endl;
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
*显示菜单
*无参
*无返回值 
*/
void showMenu(){
	cout<<"1.开始游戏"<<endl;
	cout<<"2.退出游戏"<<endl;
	cout<<"请输入："<<endl;
}

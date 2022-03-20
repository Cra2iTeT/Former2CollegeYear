/*
* 文件名：main.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/27
* 文件内容：随机数游戏 
* 当前版本：1.0
*/
#include<iostream>
#include<ctime>
#include<conio.h>
#include<cstdlib>
#include<cstdio>
using namespace std;

/*
*显示菜单
*无参
*无返回值 
*/
void show(){
	cout<<"1.开始游戏"<<endl;
	cout<<"2.查询得分"<<endl;
	cout<<"2.退出游戏"<<endl;
	cout<<"请输入：";
}

/*
*游戏主体
*参数：生成的随机数，用户想要的限定时间
*返回值：猜对的话返回生成的随机数，没猜对视情况而定 
*/
int game(int iNum,int iTime) {
int iIndex=0;
time_t tTimeBegin = time(0);
int iN=0;	//时间标记 
    while(true)  {
        if(kbhit()){       //detect the keyboard  ||  kbhit检测键盘输，如果发现了输入
            cin>>iIndex;
            
            if(iIndex==iNum){
            	cout<<"恭喜！正确猜出数字"<<iNum<<endl<<endl;
            	return iNum;
			}
			else if(iIndex>iNum){
				cout<<"高了"<<endl;
			}
			else if(iIndex<iNum){
				cout<<"低了"<<endl;
			}
			cout<<"请继续输入：";
        } else if(time(0)-tTimeBegin==iTime-5 && iN==0) {
            cout <<endl<< "还剩下："<<5<<"秒"<<endl;	//输出倒计时
            iN=1;
        }
        else if(time(0)-tTimeBegin==iTime-4 && iN==1) {
            cout <<  "还剩下："<<4<<"秒"<<endl;
            iN=2;
        }
        else if(time(0)-tTimeBegin==iTime-3 && iN==2) {
            cout << "还剩下："<<3<<"秒"<<endl;
            iN=3;
        }
        else if(time(0)-tTimeBegin==iTime-2 && iN==3) {
            cout << "还剩下："<<2<<"秒"<<endl;
            iN=4;
        }
        else if(time(0)-tTimeBegin==iTime-1 && iN==4) {
            cout << "还剩下："<<1<<"秒"<<endl;
            iN=5;
        }
        else if(time(0)-tTimeBegin>=iTime){
            tTimeBegin = time(0);
            iN=0;
            cout<<"很遗憾，未能在规定时间内猜出正确数字，该数字为"<<iNum<<endl<<endl;
            return iN;
        }
    }
}

int main(){
	int iScore=0;	//记录得分
	while(1){
		show();
		int iChoice;
		cin>>iChoice;
		switch(iChoice){
			case 1:{
				srand((unsigned)time(0));	//重置随机数，避免重复 
				int iNum=(rand() % (10000 - 1)) + 1;	//随机数
				cout<<"随机数已生成"<<endl;
				//cout<<iNum<<endl;
				cout<<"随机数范围为1-10000，不包含10000"<<endl<<endl;
				cout<<"请输入限定时间：";
				int iTime;
				cin>>iTime; 
				int iIndex;	//临时标记
				cout<<"请输入你的答案：";
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
				cout<<"你的得分为："<<iScore<<endl<<endl;
				break;
			case 3:
				cout<<"游戏已退出"<<endl<<endl;
				exit(0);
		}
	}
}



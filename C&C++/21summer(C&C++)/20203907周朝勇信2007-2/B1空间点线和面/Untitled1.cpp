/*
* 文件名：main.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/27
* 文件内容：随机数游戏 
* 当前版本：1.0
*/
#include<iostream>

using namespace std;


/*
*显示菜单
*无参
*无返回值 
*/
void show(){
	cout<<"1.开始游戏"<<endl;
	cout<<"2.查询得分"<<endl;
	cout<<"3.退出游戏"<<endl;
	cout<<"请输入：";
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
*游戏主体
*参数：生成的随机数，用户想要的限定时间
*返回值：猜对的话返回生成的随机数，没猜对视情况而定
*/
int game(int *iA[]){
	/*cout<<"请选择你的棋子，输入1选择“X ”,输入2选择“O ”";
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
	int iScoreB=0;	//电脑分数
	int iScoreC=0;	//用户分数
	int iA[9];	//棋盘 
	char cC[1],cB[1];	//分别表示用户选择的棋子、电脑选择的棋子以及空白棋子
	char cK="*";
	game(iA);
	/*while(1){
		show();
		int iChoice;
		cin>>iChoice;
		
		switch(iChoice){
			case 1:{
				cout<<"获胜方加10积分，败方加2积分" 
				
				若已有“XX”，计50分 
				若已有“OO”，计25分
				若已有“X*”，计10分
				若已有“O*”，计8分
				如已有“**”，计4分
				
				break;
			}
			case 2:
				cout<<"你的得分为："<<iScore<<endl<<endl;
				break;
			case 3:
				cout<<"游戏已退出"<<endl<<endl;
				exit(0);
		}
	}*/
}

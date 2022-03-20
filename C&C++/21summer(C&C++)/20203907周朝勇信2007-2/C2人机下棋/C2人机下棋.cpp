/*
* 文件名：main.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/28
* 文件内容：人机下棋游戏 
* 当前版本：1.0
*/

#include<iostream>
#include<ctime>
#include<conio.h>
#include<cstdlib>
#include<string>
using namespace std;


/*
* 类的作用：CPanel创建了棋盘类
* 类的使用：CPanel cp;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/28
*/
class CPanel{
	public:
		string cC,cB,cK;
		int iScoreB;
		int iScoreC;
		int iCWin,iBWin;	//记录胜利情况 
		int iIndex;	//记录下子步数
		
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
		
		int iA[3][3];	//棋盘 
		void setC(int i,int j){	//玩家设置棋盘值 
			iA[i][j]=1;
		}
		void setB(int i,int j){	//电脑设置棋盘值 
			iA[i][j]=-1;
		}
		
		int get(int i,int j){	//返回棋盘值 
			return iA[i][j];
		}
		
		
		void Menu();	//基础菜单
		
		void startGame();	//游戏基础
		
		void print();	//打印当前棋盘
		void logic();	//游戏逻辑 
		
		void count();	//计算获胜解
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
*显示菜单
*无参
*无返回值 
*/
void CPanel::Menu(){
	cout<<"1.开始游戏"<<endl;
	cout<<"2.查询得分"<<endl;
	cout<<"3.退出游戏"<<endl;
	cout<<"请输入：";
}

/*
*游戏开始设置 
*无参
*无返回值 
*/
void CPanel::startGame(){
	cout<<"请选择你的棋子，输入1选择“X ”,输入2选择“O ”";
	cout<<"，请输入:";
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
*打印棋盘 
*无参
*无返回值 
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
*游戏逻辑
*无参
*无返回值 
*/
void CPanel::logic(){
	while(iIndex<9&&iCWin==0&&iBWin==0){
		while(1){
			cout<<"请输入你要下的行数：";
			int iRow;
			cin>>iRow;
			cout<<"请输入你要下的列数：";
			int iCol;
			cin>>iCol;
			if(iA[iRow-1][iCol-1]!=0){
			cout<<"下子错误，请检查该位置是否已经有棋子并重新输入"<<endl;
			}
			else if(iA[iRow-1][iCol-1]==0){
				setC(iRow-1,iCol-1);
				//iA[iRow-1][iCol-1]=1;
				cout<<"下子成功"<<endl<<endl;
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
				//cout<<"到这里1"<<endl; 
			}else{
				//cout<<"到这里3"<<endl; 
				int iEmpty=1;
				while(iEmpty==1){		
				//cout<<"到这里4"<<endl; 	
				//srand((unsigned)time(0));	//重置随机数，避免重复 				
				int i_Row=(rand() % (3 - 0)) + 0;	//随机数
				//cout<<"---"<<i_Row<<endl;
				int i_Col=(rand() % (3 - 0)) + 0;
				//cout<<"---"<<i_Col<<endl;
					if(iA[i_Row][i_Col]==0){
						iEmpty=0;
						//iA[i_Row][i_Col]==-1;
						setB(i_Row,i_Col);
						//cout<<iA[i_Row][i_Col]<<endl;
						//cout<<"到这里5"<<endl;
						//cout<<iEmpty<<endl;
					}
				}
			//cout<<"到这里2"<<endl;
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
		//cout<<"到这里"<<endl; 
	
	
	if(iIndex==9&&iCWin==0&&iBWin==0){
		cout<<"本轮平局"<<endl<<endl;
	}
	if(iBWin!=0){
		cout<<"本轮电脑获胜"<<endl<<endl;
	}
	if(iCWin!=0){
		cout<<"本轮玩家获胜"<<endl<<endl;
	}
}

/*
*计算电脑赢的办法 
*无参
*无返回值 
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
		//cout<<"在这里555"<<endl; 
		int i_Row=(rand() % (3 - 0)) + 0;	//随机数
		int i_Col=(rand() % (3 - 0)) + 0;
		//cout<<i_Row<<endl;
		//cout<<i_Col<<endl;
		if(iA[i_Row][i_Col]==0){
			iEmpty=0;
			//cout<<"我到这里555"<<endl;
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
				cout<<"你的得分为："<<cp.iScoreC<<endl;
				cout<<"电脑的得分为："<<cp.iScoreB<<endl<<endl;
				break;
			case 3:
				cout<<"游戏已退出"<<endl<<endl;
				exit(0);
		}
	}
}

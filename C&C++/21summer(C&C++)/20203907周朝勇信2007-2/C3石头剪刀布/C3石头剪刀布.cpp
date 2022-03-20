/*
* 文件名：main.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/28
* 文件内容：猜拳游戏
* 当前版本：1.0
*/

#include<iostream>
#include<ctime>
#include<conio.h>
#include<cstdlib>
#include<cstring>
#include<fstream>
#include<sstream>
using namespace std;

/*
* 链表用来记录
*/
typedef struct Node { 
	int iLast;
	int iNow;
	int iWin;
	Node* next;
	Node* last; 
}node;
/*struct node {
	int iLast;
	int iNow;
	int iWin;
	struct node* next;
	struct node* last;
};*/

/*
* 类的作用：CGame创建了猜拳类
* 类的使用：CGame cg;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/28
*/
class CGame {
public:
	int iA[3][3];
	int iScore;
	node* head;
	CGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				iA[i][j] = 0;
			}
		}
		head = (node*)malloc(sizeof(node));
		head->last = NULL;
		head->next = NULL;
		head->iLast = 0;
		head->iNow = 0;
		head->iWin = 0;

		iScore = 0;
	}
	void Menu();
	void logic();
	void win(int i1, int i2);
	void show(int iChoice);
	
};

/*
*显示菜单
*无参
*无返回值
*/
void CGame::Menu() {
	cout << "1.开始游戏" << endl;
	cout << "2.查询得分" << endl;
	cout << "3.退出游戏" << endl;
	cout << "请输入：";
}

/*
*游戏主体
*无参
*无返回
*/
void CGame::logic() {
	int iChoice=0;
	cout << "1代表石头，2代表剪刀，3代表布，请输入：";
	node* p;
	p = head;
	int iNum = 0;
	node* q = (node*)malloc(sizeof(node));
	q->next = NULL;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
		//cout << "进" << endl;
	}
	//cout << "ddddd";
	cin >> iChoice;
	q->iNow = iChoice;
	q->iLast = p->iNow;
	p->next = q;
	q->last = p;
	p = head->next;
	int iI = 0;
	//cout << iNum;
	while (iI<iNum) {//计算
		if (p->iLast==1) {//先出石头
			cout << "1" << endl;
			if (p->iNow == 1) {
				if (p->iWin == 1) {//赢了 
					iA[0][1]++;
				}
				else {
					iA[0][0]++;
				}
			}
			else if (p->iNow == 2) {
				if (p->iWin == 1) {//赢了 
					iA[0][3]++;
				}
				else {
					iA[0][2]++;
				}
			}
			else if (p->iNow == 3) {
				if (p->iWin == 1) {//赢了 
					iA[0][5]++;
				}
				else {
					iA[0][4]++;
				}
			}
		}
		else if (p->iLast == 2) {//先出剪刀 
			cout << "2" << endl;
			if (p->iNow == 1) {
				if (p->iWin == 1) {//赢了 
					iA[1][1]++;
				}
				else {
					iA[1][0]++;
				}
			}
			else if (p->iNow == 2) {
				if (p->iWin == 1) {//赢了 
					iA[1][3]++;
				}
				else {
					iA[1][2]++;
				}
			}
			else if (p->iNow == 3) {
				if (p->iWin == 1) {//赢了 
					iA[1][5]++;
				}
				else {
					iA[1][4]++;
				}
			}
		}
		else if (p->iLast == 3) {//先出布
			cout << "3" << endl;
			if (p->iNow == 1) {
				if (p->iWin == 1) {//赢了 
					iA[2][1]++;
				}
				else {
					iA[2][0]++;
				}
			}
			else if (p->iNow == 2) {
				if (p->iWin == 1) {//赢了 
					iA[2][3]++;
				}
				else {
					iA[2][2]++;
				}
			}
			else if (p->iNow == 3) {
				if (p->iWin == 1) {//赢了 
					iA[2][5]++;
				}
				else {
					iA[2][4]++;
				}
			}
		}
		iI++;
	}
	if (p->last->iLast == 1) {
		if (iA[0][0] > iA[0][1] && iA[0][0] > iA[0][2]) {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：拳头" << endl;
			win(iChoice, 1);
			cout << endl;
		}
		else if (iA[0][1] > iA[0][0] && iA[0][1] > iA[0][2]) {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：剪刀" << endl;
			win(iChoice, 2);
			cout << endl;
		}
		else {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：布" << endl;
			win(iChoice, 3);
			cout << endl;
		}
	}
	else if (p->last->iLast == 2) {
		if (iA[1][0] > iA[1][1] && iA[1][0] > iA[1][2]) {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：拳头" << endl;
			win(iChoice, 1);
			cout << endl;
		}
		else if (iA[1][1] > iA[0][0] && iA[1][1] > iA[1][2]) {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：剪刀" << endl;
			win(iChoice, 2);
			cout << endl;
		}
		else {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：布" << endl;
			win(iChoice, 3);
			cout << endl;
		}
	}
	else if (p->last->iLast == 3) {
		if (iA[2][0] > iA[2][1] && iA[2][0] > iA[2][2]) {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：拳头" << endl;
			win(iChoice, 1);
			cout << endl;
		}
		else if (iA[2][1] > iA[2][0] && iA[2][1] > iA[2][2]) {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：剪刀" << endl;
			win(iChoice, 2);
			cout << endl;
		}
		else {
			cout << "你出的是：";
			show(iChoice);
			cout << "\t电脑出的是：布" << endl;
			win(iChoice, 3);
			cout << endl;
		}
	}
	else {
		cout << "你出的是：";
		show(iChoice);
		srand((unsigned)time(0));
		cout << "\t电脑出的是：";
		int iN = (rand() % (4 - 1)) + 1;
		show(iN);
		cout << endl;
		win(iChoice, iN);
		cout << endl;
	}
}

/*
* 判断游戏胜利者
* 参数：用户和电脑出拳代表的数字
* 无返回值
*/
void CGame::win(int i1, int i2){
	node* t=head;
	while (t->next != NULL) {
		t = t->next;
	}
	if (i1 == 1) {
		if (i2 == 1) {
			cout << "双方平局";
			t->iWin = 0;
		}
		else if (i2 == 2) {
			cout << "你赢了";
			t->iWin = 1;
			iScore += 8;
		}
		else {
			cout << "你输了";
			t->iWin = 0;
			iScore -= 5;
		}
	}
	else if (i1 == 2) {
		if (i2 == 2) {
			cout << "双方平局";
			t->iWin = 0;
		}
		else if (i2 == 3) {
			cout << "你赢了";
			t->iWin = 1;
			iScore += 8;
		}
		else {
			cout << "你输了";
			t->iWin = 0;
			iScore -= 5;
		}
	}
	else if (i1 == 3) {
		if (i2 == 3) {
			cout << "双方平局";
			t->iWin = 0;
		}
		else if (i2 == 1) {
			cout << "你赢了";
			t->iWin = 1;
			iScore += 8;
		}
		else {
			cout << "你输了";
			t->iWin = 0;
			iScore -= 5;
		}
	}
	cout << endl;
}

/*
* 显示出的拳具体是什么
* 参数：出拳代表的数字
* 无返回值
*/
void CGame::show(int iChoice){
	if (iChoice == 1) {
		cout << "石头";
	}
	else if (iChoice == 2) {
		cout << "剪刀";
	}
	else {
		cout << "布";
	}
}

int main() {
	CGame cg;
	while (1) {
		cg.Menu();
		int iChoice;
		cin >> iChoice;
		switch (iChoice) {
		case 1: {
			cg.logic();
			break;
		}
		case 2:
			cout << "你的得分为：" << cg.iScore << endl << endl;
			break;
		case 3:
			cout << "游戏已退出" << endl << endl;
			exit(0);
		}
	}
}

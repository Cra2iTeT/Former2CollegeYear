/*
* 文件名：C3石头剪刀布.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/28
* 文件内容：整数链表
* 当前版本：1.0
*/
#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;

/*
* 链表结构
*/
typedef struct Node { 
	int data;
	Node* next;
}node;
/*struct node {
	int data;
	struct node* next;
};*/

/*
* 类的作用：CLink创建了链表类
* 类的使用：CLink cl;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/28
*/
class CLink {
public:
	node* head;
	CLink() {
		head = (node*)malloc(sizeof(node));
		head->next = NULL;
		head->data = 0;
	}

	void menu();
	void creat();
	void add();
	void del();
	void show();
	void search();
};

/*
* 菜单显示
* 无参
* 无返回值
*/
void CLink::menu() {
	cout << "-----1.创建空链表-----" << endl;
	cout << "-----2.插入结点  -----" << endl;
	cout << "-----3.删除结点  -----" << endl;
	cout << "-----4.遍历输出  -----" << endl;
	cout << "-----5.结点查询  -----" << endl;
	cout << "-----6.退出系统  -----" << endl << endl;
}


/*
* 空链表创建
* 无参
* 无返回值
*/
void CLink::creat() {
	node* p = (node*)malloc(sizeof(node));
	node* ph = head;
	while (ph->next != NULL) {
		ph = ph->next;
	}
	ph->next = p;
	p->next = NULL;
	cout << "空链表创建完成" << endl << endl;
}


/*
* 链表添加
* 无参
* 无返回值
*/
void CLink::add() {
	int iNum = 0;
	node* p = head;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
	}
	cout << "总共有" << iNum << "个结点" << endl << endl;
	cout << "请输入你想要插入到的结点位置：";
	int iIndex;
	cin >> iIndex;
	if (iNum != 0) {
		while (iIndex > iNum + 1) {
			cout << "输入有误，超过当前结点上限，请重新输入" << endl << endl;
			cout << "请输入：";
			cin >> iIndex;
		}
		int iI = 1;
		p = head;
		while (iI < iIndex) {
			p = p->next;
			iI++;
		}
	}
	node* temp = (node*)malloc(sizeof(node));
	cout << "请输入需要插入的数据：";
	int iData;
	cin >> iData;
	temp->data = iData;
	
	if (iIndex == iNum) {
		temp->next = p->next;
		p->next = temp;
		temp->next->next = NULL;
	}
	else if (iIndex == iNum + 1) {
		p->next = temp;
		temp->next = NULL;
	}
	else
	{
		temp->next = p->next;
		p->next = temp;
	}
	cout << "数据插入完成" << endl << endl;
}


/*
* 链表删除
* 无参
* 无返回值
*/
void CLink::del() {
	int iNum = 0;
	node* p = head;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
	}
	if (iNum != 0) {
		cout << "总共有" << iNum << "个结点" << endl << endl;
		cout << "请输入你想要删除掉的结点位置：";
		int iIndex;
		cin >> iIndex;
	
		while (iIndex > iNum) {
			cout << "输入有误，超过当前结点上限，请重新输入" << endl << endl;
			cout << "请输入：";
			cin >> iIndex;
		}
		int iI = 1;
		p = head;
		while (iI < iIndex) {
			p = p->next;
			iI++;
		}
		node* temp = p->next;
		p->next = p->next->next;
		delete temp;
	}
	else
	{
		cout << "当前无结点，请先添加或创建" << endl << endl;
		return;
	}

	cout << "结点删除完毕" << endl << endl;
}

/*
* 链表遍历
* 无参
* 无返回值
*/
void CLink::show() {
	node* p = head;
	if (head->next != NULL) {
		while (p->next != NULL) {
			cout << p->next->data << "\t";
			p = p->next;
		}
		cout << endl;
		cout << "所有结点数据输出完毕" << endl << endl;
	}
	else {
		cout << "当前无结点，请先创建或添加" << endl << endl;
	}
}


/*
* 结点查询
* 无参
* 无返回值
*/
void CLink::search() {
	int iNum = 0;
	node* p = head;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
	}
	if (iNum != 0) {
		cout << "总共有" << iNum << "个结点" << endl << endl;
		cout << "请输入你想要查询的结点位置：";
		int iIndex;
		cin >> iIndex;
		while (iIndex > iNum) {
			cout << "输入有误，超过当前结点上限，请重新输入" << endl << endl;
			cout << "请输入：";
			cin >> iIndex;
		}
		int iI = 0;
		p = head;
		while (iI < iIndex) {
			p = p->next;
			iI++;
		}
		cout << endl << "你所要查找的结点数据如下：" << p->data << endl << endl;
	}
	else
	{
		cout << "当前无结点，清先创建或添加" << endl << endl;
		return;
	}
}

int main() {
	CLink cl;
	while (1) {
		cl.menu();
		int iChoice;
		cin >> iChoice;
		switch (iChoice) {
		case 1:
			cl.creat();
			break;
		case 2:
			cl.add();
			break;
		case 3:
			cl.del();
			break;
		case 4:
			cl.show();
			break;
		case 5:
			cl.search();
			break;
		case 6:
			cout << "系统已退出" << endl << endl;
			exit(0);
		}
	}
}

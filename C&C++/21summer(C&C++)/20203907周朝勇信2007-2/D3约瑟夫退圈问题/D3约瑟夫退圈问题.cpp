/*
* 文件名：D3约瑟夫退圈问题.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/29
* 文件内容：D3约瑟夫退圈问题
* 当前版本：1.0
*/
#include<cstdlib>
#include<iostream>
using namespace std;

/*
* 链表结构
*/
typedef struct Node {
	int iId;
	Node* next;
}node;

/*
* 类的作用：CNode创建了链表类
* 类的使用：CNode cn;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/29
*/
class CNode {
public:
	int m_iM, m_iN,m_iStartId;
	node* head;
	node* Nhead;//新队列的头
	

	CNode() {
		head = (node*)malloc(sizeof(node));
		Nhead = (node*)malloc(sizeof(node));
		Nhead->next = NULL;
		head->next=NULL;
		m_iM = 0;
		m_iN = 0;
		m_iStartId = 0;
	}

	~CNode() {
		delete head;
		delete Nhead;
	}

	void logic();
};


/*
* 退圈的逻辑方法，以及对退圈的人的后续处理
* 无参
* 无返回值
*/
void CNode::logic() {
	cout << "请输入总人数：";
	cin >> m_iN;
	cout << "请输入报数上限：";
	cin >> m_iM;
	cout << "请输入起始位置：";
	cin >> m_iStartId;

	//建立循环链表
	int iI = 0;
	node* p = head;
	while (iI < m_iN) {
		iI++;
		node* q = (node*)malloc(sizeof(node));
		q->iId = iI;
		q->next = NULL;
		p->next = q;
		p = p->next;
	}
	p->next = head;//首尾连接完成
	/*iI = 0;
	p = head->next;
	while (iI<m_iN)
	{
		iI++;
		cout << "---" << p->iId << endl;
		p = p->next;
	}*/
	//退圈
	iI = 0;
	p = head;
	node* q = p->next;
	//cout<<m_iM;
	node* Np = Nhead;
	int iIndex = 0;//计数器
	while (iI<m_iN-1)
	{
		//cout << "ttt" << endl;
		iIndex++;
		//cout << "------" << iIndex << endl;
		if(iIndex == m_iM)
		{
			//cout << "------iIndex";
			cout << "下标为：" << q->iId << "的人出圈" << endl;
			Np->next = q;
			q = q->next;
			Np->next->next = Nhead;
			Np = Np->next;
			p->next = q;
			iI++;
			iIndex = 0;
		}
		else if(iIndex!=m_iM) {
			q = q->next;
			p = p->next;
		}
		if (q == head) {
			p = p->next;
			q = q->next;
		}
	}
	if (p == head) {
		p = p->next;
	}
	cout << "最后剩下的人下标为：" << p->iId << endl;
}

int main() {
	CNode cn;
	cn.logic();
}
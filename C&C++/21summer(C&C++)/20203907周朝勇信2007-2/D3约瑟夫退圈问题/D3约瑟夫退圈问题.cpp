/*
* �ļ�����D3Լɪ����Ȧ����.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/29
* �ļ����ݣ�D3Լɪ����Ȧ����
* ��ǰ�汾��1.0
*/
#include<cstdlib>
#include<iostream>
using namespace std;

/*
* ����ṹ
*/
typedef struct Node {
	int iId;
	Node* next;
}node;

/*
* ������ã�CNode������������
* ���ʹ�ã�CNode cn;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/29
*/
class CNode {
public:
	int m_iM, m_iN,m_iStartId;
	node* head;
	node* Nhead;//�¶��е�ͷ
	

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
* ��Ȧ���߼��������Լ�����Ȧ���˵ĺ�������
* �޲�
* �޷���ֵ
*/
void CNode::logic() {
	cout << "��������������";
	cin >> m_iN;
	cout << "�����뱨�����ޣ�";
	cin >> m_iM;
	cout << "��������ʼλ�ã�";
	cin >> m_iStartId;

	//����ѭ������
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
	p->next = head;//��β�������
	/*iI = 0;
	p = head->next;
	while (iI<m_iN)
	{
		iI++;
		cout << "---" << p->iId << endl;
		p = p->next;
	}*/
	//��Ȧ
	iI = 0;
	p = head;
	node* q = p->next;
	//cout<<m_iM;
	node* Np = Nhead;
	int iIndex = 0;//������
	while (iI<m_iN-1)
	{
		//cout << "ttt" << endl;
		iIndex++;
		//cout << "------" << iIndex << endl;
		if(iIndex == m_iM)
		{
			//cout << "------iIndex";
			cout << "�±�Ϊ��" << q->iId << "���˳�Ȧ" << endl;
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
	cout << "���ʣ�µ����±�Ϊ��" << p->iId << endl;
}

int main() {
	CNode cn;
	cn.logic();
}
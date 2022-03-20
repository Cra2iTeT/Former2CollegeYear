/*
* �ļ�����C3ʯͷ������.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/28
* �ļ����ݣ���������
* ��ǰ�汾��1.0
*/
#include<iostream>
#include<cstdio>
#include<cstdlib>
using namespace std;

/*
* ����ṹ
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
* ������ã�CLink������������
* ���ʹ�ã�CLink cl;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/28
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
* �˵���ʾ
* �޲�
* �޷���ֵ
*/
void CLink::menu() {
	cout << "-----1.����������-----" << endl;
	cout << "-----2.������  -----" << endl;
	cout << "-----3.ɾ�����  -----" << endl;
	cout << "-----4.�������  -----" << endl;
	cout << "-----5.����ѯ  -----" << endl;
	cout << "-----6.�˳�ϵͳ  -----" << endl << endl;
}


/*
* ��������
* �޲�
* �޷���ֵ
*/
void CLink::creat() {
	node* p = (node*)malloc(sizeof(node));
	node* ph = head;
	while (ph->next != NULL) {
		ph = ph->next;
	}
	ph->next = p;
	p->next = NULL;
	cout << "�����������" << endl << endl;
}


/*
* �������
* �޲�
* �޷���ֵ
*/
void CLink::add() {
	int iNum = 0;
	node* p = head;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
	}
	cout << "�ܹ���" << iNum << "�����" << endl << endl;
	cout << "����������Ҫ���뵽�Ľ��λ�ã�";
	int iIndex;
	cin >> iIndex;
	if (iNum != 0) {
		while (iIndex > iNum + 1) {
			cout << "�������󣬳�����ǰ������ޣ�����������" << endl << endl;
			cout << "�����룺";
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
	cout << "��������Ҫ��������ݣ�";
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
	cout << "���ݲ������" << endl << endl;
}


/*
* ����ɾ��
* �޲�
* �޷���ֵ
*/
void CLink::del() {
	int iNum = 0;
	node* p = head;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
	}
	if (iNum != 0) {
		cout << "�ܹ���" << iNum << "�����" << endl << endl;
		cout << "����������Ҫɾ�����Ľ��λ�ã�";
		int iIndex;
		cin >> iIndex;
	
		while (iIndex > iNum) {
			cout << "�������󣬳�����ǰ������ޣ�����������" << endl << endl;
			cout << "�����룺";
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
		cout << "��ǰ�޽�㣬������ӻ򴴽�" << endl << endl;
		return;
	}

	cout << "���ɾ�����" << endl << endl;
}

/*
* �������
* �޲�
* �޷���ֵ
*/
void CLink::show() {
	node* p = head;
	if (head->next != NULL) {
		while (p->next != NULL) {
			cout << p->next->data << "\t";
			p = p->next;
		}
		cout << endl;
		cout << "���н������������" << endl << endl;
	}
	else {
		cout << "��ǰ�޽�㣬���ȴ��������" << endl << endl;
	}
}


/*
* ����ѯ
* �޲�
* �޷���ֵ
*/
void CLink::search() {
	int iNum = 0;
	node* p = head;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
	}
	if (iNum != 0) {
		cout << "�ܹ���" << iNum << "�����" << endl << endl;
		cout << "����������Ҫ��ѯ�Ľ��λ�ã�";
		int iIndex;
		cin >> iIndex;
		while (iIndex > iNum) {
			cout << "�������󣬳�����ǰ������ޣ�����������" << endl << endl;
			cout << "�����룺";
			cin >> iIndex;
		}
		int iI = 0;
		p = head;
		while (iI < iIndex) {
			p = p->next;
			iI++;
		}
		cout << endl << "����Ҫ���ҵĽ���������£�" << p->data << endl << endl;
	}
	else
	{
		cout << "��ǰ�޽�㣬���ȴ��������" << endl << endl;
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
			cout << "ϵͳ���˳�" << endl << endl;
			exit(0);
		}
	}
}

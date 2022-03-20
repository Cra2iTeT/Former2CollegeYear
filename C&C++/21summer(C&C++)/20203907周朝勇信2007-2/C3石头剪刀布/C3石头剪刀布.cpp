/*
* �ļ�����main.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/28
* �ļ����ݣ���ȭ��Ϸ
* ��ǰ�汾��1.0
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
* ����������¼
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
* ������ã�CGame�����˲�ȭ��
* ���ʹ�ã�CGame cg;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/28
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
*��ʾ�˵�
*�޲�
*�޷���ֵ
*/
void CGame::Menu() {
	cout << "1.��ʼ��Ϸ" << endl;
	cout << "2.��ѯ�÷�" << endl;
	cout << "3.�˳���Ϸ" << endl;
	cout << "�����룺";
}

/*
*��Ϸ����
*�޲�
*�޷���
*/
void CGame::logic() {
	int iChoice=0;
	cout << "1����ʯͷ��2���������3�����������룺";
	node* p;
	p = head;
	int iNum = 0;
	node* q = (node*)malloc(sizeof(node));
	q->next = NULL;
	while (p->next != NULL) {
		p = p->next;
		iNum++;
		//cout << "��" << endl;
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
	while (iI<iNum) {//����
		if (p->iLast==1) {//�ȳ�ʯͷ
			cout << "1" << endl;
			if (p->iNow == 1) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[0][1]++;
				}
				else {
					iA[0][0]++;
				}
			}
			else if (p->iNow == 2) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[0][3]++;
				}
				else {
					iA[0][2]++;
				}
			}
			else if (p->iNow == 3) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[0][5]++;
				}
				else {
					iA[0][4]++;
				}
			}
		}
		else if (p->iLast == 2) {//�ȳ����� 
			cout << "2" << endl;
			if (p->iNow == 1) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[1][1]++;
				}
				else {
					iA[1][0]++;
				}
			}
			else if (p->iNow == 2) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[1][3]++;
				}
				else {
					iA[1][2]++;
				}
			}
			else if (p->iNow == 3) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[1][5]++;
				}
				else {
					iA[1][4]++;
				}
			}
		}
		else if (p->iLast == 3) {//�ȳ���
			cout << "3" << endl;
			if (p->iNow == 1) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[2][1]++;
				}
				else {
					iA[2][0]++;
				}
			}
			else if (p->iNow == 2) {
				if (p->iWin == 1) {//Ӯ�� 
					iA[2][3]++;
				}
				else {
					iA[2][2]++;
				}
			}
			else if (p->iNow == 3) {
				if (p->iWin == 1) {//Ӯ�� 
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
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ�ȭͷ" << endl;
			win(iChoice, 1);
			cout << endl;
		}
		else if (iA[0][1] > iA[0][0] && iA[0][1] > iA[0][2]) {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ�����" << endl;
			win(iChoice, 2);
			cout << endl;
		}
		else {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ���" << endl;
			win(iChoice, 3);
			cout << endl;
		}
	}
	else if (p->last->iLast == 2) {
		if (iA[1][0] > iA[1][1] && iA[1][0] > iA[1][2]) {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ�ȭͷ" << endl;
			win(iChoice, 1);
			cout << endl;
		}
		else if (iA[1][1] > iA[0][0] && iA[1][1] > iA[1][2]) {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ�����" << endl;
			win(iChoice, 2);
			cout << endl;
		}
		else {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ���" << endl;
			win(iChoice, 3);
			cout << endl;
		}
	}
	else if (p->last->iLast == 3) {
		if (iA[2][0] > iA[2][1] && iA[2][0] > iA[2][2]) {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ�ȭͷ" << endl;
			win(iChoice, 1);
			cout << endl;
		}
		else if (iA[2][1] > iA[2][0] && iA[2][1] > iA[2][2]) {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ�����" << endl;
			win(iChoice, 2);
			cout << endl;
		}
		else {
			cout << "������ǣ�";
			show(iChoice);
			cout << "\t���Գ����ǣ���" << endl;
			win(iChoice, 3);
			cout << endl;
		}
	}
	else {
		cout << "������ǣ�";
		show(iChoice);
		srand((unsigned)time(0));
		cout << "\t���Գ����ǣ�";
		int iN = (rand() % (4 - 1)) + 1;
		show(iN);
		cout << endl;
		win(iChoice, iN);
		cout << endl;
	}
}

/*
* �ж���Ϸʤ����
* �������û��͵��Գ�ȭ���������
* �޷���ֵ
*/
void CGame::win(int i1, int i2){
	node* t=head;
	while (t->next != NULL) {
		t = t->next;
	}
	if (i1 == 1) {
		if (i2 == 1) {
			cout << "˫��ƽ��";
			t->iWin = 0;
		}
		else if (i2 == 2) {
			cout << "��Ӯ��";
			t->iWin = 1;
			iScore += 8;
		}
		else {
			cout << "������";
			t->iWin = 0;
			iScore -= 5;
		}
	}
	else if (i1 == 2) {
		if (i2 == 2) {
			cout << "˫��ƽ��";
			t->iWin = 0;
		}
		else if (i2 == 3) {
			cout << "��Ӯ��";
			t->iWin = 1;
			iScore += 8;
		}
		else {
			cout << "������";
			t->iWin = 0;
			iScore -= 5;
		}
	}
	else if (i1 == 3) {
		if (i2 == 3) {
			cout << "˫��ƽ��";
			t->iWin = 0;
		}
		else if (i2 == 1) {
			cout << "��Ӯ��";
			t->iWin = 1;
			iScore += 8;
		}
		else {
			cout << "������";
			t->iWin = 0;
			iScore -= 5;
		}
	}
	cout << endl;
}

/*
* ��ʾ����ȭ������ʲô
* ��������ȭ���������
* �޷���ֵ
*/
void CGame::show(int iChoice){
	if (iChoice == 1) {
		cout << "ʯͷ";
	}
	else if (iChoice == 2) {
		cout << "����";
	}
	else {
		cout << "��";
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
			cout << "��ĵ÷�Ϊ��" << cg.iScore << endl << endl;
			break;
		case 3:
			cout << "��Ϸ���˳�" << endl << endl;
			exit(0);
		}
	}
}

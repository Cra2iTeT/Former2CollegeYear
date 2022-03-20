/*
* �ļ�����D2��ͨѶ¼����.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/28
* �ļ����ݣ���������
* ��ǰ�汾��1.0
*/
#include<iostream>
#include<cstdlib>
#include<fstream>
#include<cstring>
#include<sstream>
using namespace std;


/*
* ����ṹ
*/
typedef struct Node {
	int iSex;
	string strName;
	int iId;
	string iHPhone;
	string iTPhone;
	int iAge;
	Node* next;
}node;


/*
* ������ã�CNode�ඨ���������ࡣ
* ���ʹ�ã�CNode cn;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/29
*/
class CNode {
public:
	node* head;

	CNode()
	{
		//head = (node*)malloc(sizeof(node));
		head = new node;
		head->next = NULL;
		head->iAge = 0;
		head->iHPhone = "";
		head->iId = 0;
		head->iSex = 0;
		head->iTPhone = "";
		head->strName = "";
	}
	~CNode()
	{
		delete head;
	}

	void creat();
	void add();
	void search();
	void mod();
	void del();
	void in();
	void out();
	void menu();
	void show();
};


/*
* ���ã�����
* �޲�
* �޷���ֵ
*/
void CNode::creat() {
	node* p = head;
	while (p->next!=NULL)
	{
		p = p->next;
	}
	//node* q = (node*)malloc(sizeof(node));
	node* q = new node;
	p->next = q;
	q->iId = p->iId + 1;
	q->next = NULL;

	cout << endl << "�����ɹ�" << endl << endl;
}


/*
* �������ã������ϵ��
* �޲�
* �޷���ֵ
*/
void CNode::add() {
	node* p = head;
	while (p->next!=NULL)
	{
		p = p->next;
	}

	//q = (node*)malloc(sizeof(node));
	node* q = new node;
	int iSex;
	string strName;
	string iHPhone;
	string iTPhone;
	int iAge;
	cout << "��������Ҫ��ӵ���������";
	cin >> strName;
	q->strName = strName;
	q->iId = p->iId + 1;
	cout << "��������Ҫ��ӵ����Ա�1�����У�2����Ů��";
	cin >> iSex;
	while (iSex != 1 && iSex != 2)
	{
		cout << "�Ա������������������룺";
		cin >> iSex;
	}
	q->iSex = iSex;
	cout << "��������Ҫ��ӵ������䣺";
	cin >> iAge;
	q->iAge = iAge;
	cout << "��������Ҫ��ӵ���լ�磺";
	cin >> iHPhone;
	q->iHPhone = iHPhone;
	cout << "��������Ҫ��ӵ����ֻ��绰��";
	cin >> iTPhone;
	q->iTPhone = iTPhone;
	p->next = q;
	q->next = NULL;

	cout << endl << "��ӳɹ�" << endl << endl;
}


/*
* ���ã���ѯ��ϵ����Ϣ
* �޲�
* �޷���ֵ
*/
void CNode::search() {
	node* p = head;
	if (p->next == NULL) {
		cout << "����Ϊ�գ����ȵ�������" << endl << endl;
		return;
	}
	cout << endl << "��ѡ���ѯ��ʽ��1.��������ѯ��2.���ֻ��Ų�ѯ��";
	int iChoice;
	cin >> iChoice;
	if (iChoice == 1) {
		cout << "��������Ҫ��ѯ����������";
		string strName;
		cin >> strName;
		int iFlag=1;
		while (p->next!=NULL)
		{
			if (p->next->strName._Equal(strName)) {
				iFlag=0;
				cout << "���ҳɹ����������Ϣ���£�";
				cout << endl << endl;
				cout << "��ţ�" << p->next->iId << "\t"
					<< "������" << p->next->strName << "\t"
					<< "�Ա�";
				if (p->next->iSex == 1) {
					cout << "��" << "\t";
				}
				else if(p->next->iSex==2) {
					cout << "Ů" << "\t";
				}
				else {
					cout << "��" << "\t";
				}
				cout << "���䣺" << p->next->iAge << "\t";
				cout << "լ�磺" << p->next->iHPhone << "\t";
				cout << "�ֻ��绰��" << p->next->iTPhone << endl << endl;
			}
			p = p->next;
		}
		if(iFlag) {
			cout << "δ���ҵ�����Ϊ��" << strName << "����ϵ��" << endl << endl;
		}
		system("pause");
		return;
	}
	else {
		cout << "��������Ҫ��ѯ�����ֻ��ţ�";
		string iTPhone;
		cin >> iTPhone;
		while (p->next!=NULL)
		{
			if (p->iTPhone == iTPhone) {
				cout << "���ҳɹ����������Ϣ���£�";
				cout << endl << endl;
				cout << "��ţ�" << p->next->iId << "\t"
					<< "������" << p->next->strName << "\t"
					<< "�Ա�";
				if (p->next->iSex == 1) {
					cout << "��" << "\t";
				}
				else if (p->iSex == 2) {
					cout << "Ů" << "\t";
				}
				else {
					cout << "��" << "\t";
				}
				cout << "���䣺" << p->next->iAge << "\t";
				cout << "լ�磺" << p->next->iHPhone << "\t";
				cout << "�ֻ��绰��" << p->next->iTPhone << endl << endl;
				system("pause");
				return;
			}
			p = p->next;
		}
		cout << "δ���ҵ��ֻ���Ϊ��"<<iTPhone<<"����ϵ��" << endl << endl;
		return;
	}
}


/*
* �������ã��޸��ض���ϵ����Ϣ
* �޲�
* �޷���ֵ
*/
void CNode::mod() {
	cout << "��������Ҫ�޸ĵ��˱�ţ�";
	int iId;
	cin >> iId;
	node* p = head;

	int iFlag = 1;//���
	while (p->next!=NULL&&iFlag==1) {
		if (p->next->iId == iId) {
			iFlag = 0;
			cout << "�Ѳ��ҵ����Ϊ��" << iId << "����ϵ�ˣ��������Ϣ���£�";
			cout << endl << endl;
			cout<< "������" << p->next->strName << "\t"
				<< "�Ա�";
			if (p->next->iSex == 1) {
				cout << "��" << "\t";
			}
			else if (p->iSex == 2) {
				cout << "Ů" << "\t";
			}
			else {
				cout << "��" << "\t";
			}
			cout << "���䣺" << p->next->iAge << "\t";
			cout << "լ�磺" << p->next->iHPhone << "\t";
			cout << "�ֻ��绰��" << p->next->iTPhone << endl << endl;
		}
		p = p->next;
	}
	if (iFlag == 1) {
		cout << "δ���ҵ����Ϊ��" << iId << "����ϵ�ˣ�����Ϊ�㷵�ص�������" << endl;
		system("pause");
		return;
	}
	cout << "�������޸ĺ����Ϣ" << endl;
	int iSex;
	string strName;
	string iHPhone;
	string iTPhone;
	int iAge;

	cout << "������";
	cin >> strName;
	p->strName = strName;
	cout << "�Ա�1�����У�2����Ů��";
	cin >> iSex;
	while (iSex != 1 && iSex != 2)
	{
		cout << "�Ա������������������룺";
		cin >> iSex;
	}
	p->iSex = iSex;
	cout << "���䣺";
	cin >> iAge;
	p->iAge = iAge;
	cout << "լ�磺";
	cin >> iHPhone;
	p->iHPhone = iHPhone;
	cout << "�ֻ��绰��";
	cin >> iTPhone;
	p->iTPhone=iTPhone;
}


/*
* ���ã���ʾ������ϵ��
* �޲�
* �޷���ֵ
*/
void CNode::show() {
	node* p = head;
	if (p->next == NULL) {
		cout << "����Ϊ�գ����ȵ��룬�������ص�������" << endl;
		system("pause");
		return;
	}
	while (p->next!=NULL) {
		cout << endl << endl;
		cout << "��ţ�" << p->next->iId << "\t"
			<< "������" << p->next->strName << "\t"
			<< "�Ա�";
		if (p->next->iSex == 1) {
			cout << "��" << "\t";
		}
		else if (p->next->iSex == 2) {
			cout << "Ů" << "\t";
		}
		else {
			cout << "��" << "\t";
		}
		cout << "���䣺" << p->next->iAge << "\t";
		cout << "լ�磺" << p->next->iHPhone << "\t";
		cout << "�ֻ��绰��" << p->next->iTPhone << endl << endl;
		p = p->next;
	}
	cout << endl;
}


/*
* �������ã�ɾ���ض���ϵ����Ϣ
* �޲�
* �޷���ֵ
*/
void CNode::del() {
	cout << "����������Ҫɾ���Ķ����ţ�";
	int iId;
	cin >> iId;
	node* p = head;
	int iFlag = 1;
	while (p->next != NULL&&iFlag) {
		if (p->next->iId == iId) {
			iFlag = 0;
			cout << "�Ѳ��ҵ����Ϊ��" << iId << "����ϵ�ˣ��������Ϣ���£�";
			cout << endl << endl;
			cout << "������" << p->next->strName << "\t"
				<< "�Ա�" << p->next->iSex << "\t";
				cout << "���䣺" << p->next->iAge << "\t";
			cout << "լ�磺" << p->next->iHPhone << "\t";
			cout << "�ֻ��绰��" << p->next->iTPhone << endl << endl;
			int iChoice=0;
			cout << "�Ƿ�ȷ��ɾ����ȷ��ɾ��������1����������2��" << endl;
			cin >> iChoice;
			if (iChoice == 1) {
				if (p->next->next != NULL) {
					p->next = p->next->next;
				}
				else
				{
					p->next = NULL;
				}
				cout << "ɾ���ɹ�" << endl << endl;
			}
			system("pause");
			return;
		}
		p = p->next;
	}
	cout << "δ���ҵ����Ϊ��" << iId << "����ϵ�ˣ�����Ϊ����ת��������" << endl;
	system("pause");
	return;
}


/*
* �������ã���������
* �޲�
* �޷���ֵ
*/
void CNode::in() {
	node* p = head;
	cout << endl;
	cout << "�����ļ��ᵼ��δ��������ݶ�ʧ����������1����������������2��";
	int iChoice = 2;
	cin >> iChoice;
	if (iChoice == 2) {
		system("pause");
		return;
	}
	//string strFile = "test.txt";
	ifstream ifs;
	ifs.open("test.txt", ios::in);

	if (!ifs.is_open()) {	//�ж��ļ��Ƿ����
		cout << endl;
		cout << "�ļ������ڣ��������ص�������" << endl;
		ifs.close();
		system("pause");
		return;
	}

	char cC;
	ifs >> cC;
	if (ifs.eof()) {
		cout << endl;
		cout << "�ļ�����Ϊ��" << endl;
		ifs.close();
		head->next = NULL;
		head->iAge = 0;
		head->iHPhone ="";
		head->iId = 0;
		head->iSex = 0;
		head->iTPhone = "";
		head->strName = "";
		cout << "��������������" << endl;
		ifs.close();
		system("pause");
		return;
	}

	ifs.close();
	ifs.open("test.txt", ios::in);
	int iSex;
	string strName;
	int iId;
	string iHPhone;
	string iTPhone;
	int iAge;
	while (ifs >> iId && ifs >> strName && ifs >> iSex && ifs >> iAge && ifs >> iHPhone && ifs >> iTPhone) {
		/*ifs >> iId;
		ifs >> strName;
		ifs >> iSex;
		ifs >> iAge;
		ifs >> iHPhone;
		ifs >> iTPhone;*/
		node* q = new node;
		//cout << iTPhone <<"t" << endl;
		q->iId = iId;
		q->strName = strName;
		q->iSex = iSex;
		q->iAge = iAge;
		q->iHPhone = iHPhone;
		q->iTPhone=iTPhone;

		p->next = q;
		q->next = NULL;
		p = p->next;
	}

	cout << "�ļ��������" << endl << endl;
	ifs.close();
	system("pause");
	return;
}


/*
* �������ã������ļ�
* �޲�
* �޷���ֵ
*/
void CNode::out() {
	ofstream ofs;
	ofs.open("test.txt", ios::out);
	node* p = head;

	if (p->next == NULL) {
		cout << "�ļ�Ϊ�գ����ȵ��룬�������ص�������" << endl;
		system("pause");
		return;
	}
	while (p->next!=NULL) {	//д������
		p = p->next;
		ofs << p->iId << "\t"
			<< p->strName << "\t"
			<< p->iSex << "\t"
			<< p->iAge << "\t"
			<< p->iHPhone << "\t"
			<< p->iTPhone <<"\t" << endl;
	}

	ofs.close();
	cout << "�ļ������ɹ����������ص�������" << endl;
	system("pause");
	return;
}


/*
* �������ã�����Ļ����ʾ�����˵�
* �޲�
* �޷���ֵ
*/
void CNode::menu() {
	cout << "��ѡ�������һ����Ŀ:" << endl;
	cout << "	1 ����" << endl;
	cout << "	2 ���" << endl;
	cout << "	3 ��ѯ" << endl;
	cout << "	4 �޸�" << endl;
	cout << "	5 ɾ��" << endl;
	cout << "	6 ��ʾ" << endl;
	cout << "	7 �ļ�����" << endl;
	cout << "	8 �ļ�����" << endl;
	cout << "	9 �˳�" << endl;
	cout << "        ��ѡ��";
}

int main() {
	CNode cn;
	while (1)
	{
		cn.menu();
		int iChoice;
		cin >> iChoice;
		switch (iChoice) {
		case 1:
			cn.creat();
			break;
		case 2:
			cn.add();
			break;
		case 3:
			cn.search();
			break;
		case 4:
			cn.mod();
			break;
		case 5:
			cn.del();
			break;
		case 6:
			cn.show();
			break;
		case 7:
			cn.in();
			break;
		case 8:
			cn.out();
			break;
		case 9:
			cout << "���˳�ϵͳ" << endl;
			exit(0);
		}
	}
	
}

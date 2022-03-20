/*
* 文件名：D2简单通讯录程序.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/28
* 文件内容：整数链表
* 当前版本：1.0
*/
#include<iostream>
#include<cstdlib>
#include<fstream>
#include<cstring>
#include<sstream>
using namespace std;


/*
* 链表结构
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
* 类的作用：CNode类定义了链表类。
* 类的使用：CNode cn;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/29
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
* 作用：创建
* 无参
* 无返回值
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

	cout << endl << "创建成功" << endl << endl;
}


/*
* 方法作用：添加联系人
* 无参
* 无返回值
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
	cout << "请输入需要添加的人姓名：";
	cin >> strName;
	q->strName = strName;
	q->iId = p->iId + 1;
	cout << "请输入需要添加的人性别，1代表男，2代表女：";
	cin >> iSex;
	while (iSex != 1 && iSex != 2)
	{
		cout << "性别输入有误，请重新输入：";
		cin >> iSex;
	}
	q->iSex = iSex;
	cout << "请输入需要添加的人年龄：";
	cin >> iAge;
	q->iAge = iAge;
	cout << "请输入需要添加的人宅电：";
	cin >> iHPhone;
	q->iHPhone = iHPhone;
	cout << "请输入需要添加的人手机电话：";
	cin >> iTPhone;
	q->iTPhone = iTPhone;
	p->next = q;
	q->next = NULL;

	cout << endl << "添加成功" << endl << endl;
}


/*
* 作用：查询联系人信息
* 无参
* 无返回值
*/
void CNode::search() {
	node* p = head;
	if (p->next == NULL) {
		cout << "数据为空，请先导入数据" << endl << endl;
		return;
	}
	cout << endl << "请选择查询方式，1.按姓名查询，2.按手机号查询：";
	int iChoice;
	cin >> iChoice;
	if (iChoice == 1) {
		cout << "请输入需要查询的人姓名：";
		string strName;
		cin >> strName;
		int iFlag=1;
		while (p->next!=NULL)
		{
			if (p->next->strName._Equal(strName)) {
				iFlag=0;
				cout << "查找成功，其具体信息如下：";
				cout << endl << endl;
				cout << "编号：" << p->next->iId << "\t"
					<< "姓名：" << p->next->strName << "\t"
					<< "性别：";
				if (p->next->iSex == 1) {
					cout << "男" << "\t";
				}
				else if(p->next->iSex==2) {
					cout << "女" << "\t";
				}
				else {
					cout << "空" << "\t";
				}
				cout << "年龄：" << p->next->iAge << "\t";
				cout << "宅电：" << p->next->iHPhone << "\t";
				cout << "手机电话：" << p->next->iTPhone << endl << endl;
			}
			p = p->next;
		}
		if(iFlag) {
			cout << "未查找到姓名为：" << strName << "的联系人" << endl << endl;
		}
		system("pause");
		return;
	}
	else {
		cout << "请输入需要查询的人手机号：";
		string iTPhone;
		cin >> iTPhone;
		while (p->next!=NULL)
		{
			if (p->iTPhone == iTPhone) {
				cout << "查找成功，其具体信息如下：";
				cout << endl << endl;
				cout << "编号：" << p->next->iId << "\t"
					<< "姓名：" << p->next->strName << "\t"
					<< "性别：";
				if (p->next->iSex == 1) {
					cout << "男" << "\t";
				}
				else if (p->iSex == 2) {
					cout << "女" << "\t";
				}
				else {
					cout << "空" << "\t";
				}
				cout << "年龄：" << p->next->iAge << "\t";
				cout << "宅电：" << p->next->iHPhone << "\t";
				cout << "手机电话：" << p->next->iTPhone << endl << endl;
				system("pause");
				return;
			}
			p = p->next;
		}
		cout << "未查找到手机号为："<<iTPhone<<"的联系人" << endl << endl;
		return;
	}
}


/*
* 方法作用：修改特定联系人信息
* 无参
* 无返回值
*/
void CNode::mod() {
	cout << "请输入你要修改的人编号：";
	int iId;
	cin >> iId;
	node* p = head;

	int iFlag = 1;//标记
	while (p->next!=NULL&&iFlag==1) {
		if (p->next->iId == iId) {
			iFlag = 0;
			cout << "已查找到编号为：" << iId << "的联系人，其具体信息如下：";
			cout << endl << endl;
			cout<< "姓名：" << p->next->strName << "\t"
				<< "性别：";
			if (p->next->iSex == 1) {
				cout << "男" << "\t";
			}
			else if (p->iSex == 2) {
				cout << "女" << "\t";
			}
			else {
				cout << "空" << "\t";
			}
			cout << "年龄：" << p->next->iAge << "\t";
			cout << "宅电：" << p->next->iHPhone << "\t";
			cout << "手机电话：" << p->next->iTPhone << endl << endl;
		}
		p = p->next;
	}
	if (iFlag == 1) {
		cout << "未查找到编号为：" << iId << "的联系人，即将为你返回到主界面" << endl;
		system("pause");
		return;
	}
	cout << "请输入修改后的信息" << endl;
	int iSex;
	string strName;
	string iHPhone;
	string iTPhone;
	int iAge;

	cout << "姓名：";
	cin >> strName;
	p->strName = strName;
	cout << "性别，1代表男，2代表女：";
	cin >> iSex;
	while (iSex != 1 && iSex != 2)
	{
		cout << "性别输入有误，请重新输入：";
		cin >> iSex;
	}
	p->iSex = iSex;
	cout << "年龄：";
	cin >> iAge;
	p->iAge = iAge;
	cout << "宅电：";
	cin >> iHPhone;
	p->iHPhone = iHPhone;
	cout << "手机电话：";
	cin >> iTPhone;
	p->iTPhone=iTPhone;
}


/*
* 作用：显示所有联系人
* 无参
* 无返回值
*/
void CNode::show() {
	node* p = head;
	if (p->next == NULL) {
		cout << "内容为空，请先导入，即将返回到主界面" << endl;
		system("pause");
		return;
	}
	while (p->next!=NULL) {
		cout << endl << endl;
		cout << "编号：" << p->next->iId << "\t"
			<< "姓名：" << p->next->strName << "\t"
			<< "性别：";
		if (p->next->iSex == 1) {
			cout << "男" << "\t";
		}
		else if (p->next->iSex == 2) {
			cout << "女" << "\t";
		}
		else {
			cout << "空" << "\t";
		}
		cout << "年龄：" << p->next->iAge << "\t";
		cout << "宅电：" << p->next->iHPhone << "\t";
		cout << "手机电话：" << p->next->iTPhone << endl << endl;
		p = p->next;
	}
	cout << endl;
}


/*
* 方法作用：删除特定联系人信息
* 无参
* 无返回值
*/
void CNode::del() {
	cout << "请输入你需要删除的对象编号：";
	int iId;
	cin >> iId;
	node* p = head;
	int iFlag = 1;
	while (p->next != NULL&&iFlag) {
		if (p->next->iId == iId) {
			iFlag = 0;
			cout << "已查找到编号为：" << iId << "的联系人，其具体信息如下：";
			cout << endl << endl;
			cout << "姓名：" << p->next->strName << "\t"
				<< "性别：" << p->next->iSex << "\t";
				cout << "年龄：" << p->next->iAge << "\t";
			cout << "宅电：" << p->next->iHPhone << "\t";
			cout << "手机电话：" << p->next->iTPhone << endl << endl;
			int iChoice=0;
			cout << "是否确定删除，确认删除请输入1，返回输入2：" << endl;
			cin >> iChoice;
			if (iChoice == 1) {
				if (p->next->next != NULL) {
					p->next = p->next->next;
				}
				else
				{
					p->next = NULL;
				}
				cout << "删除成功" << endl << endl;
			}
			system("pause");
			return;
		}
		p = p->next;
	}
	cout << "未查找到编号为：" << iId << "的联系人，即将为你跳转到主界面" << endl;
	system("pause");
	return;
}


/*
* 方法作用：导入数据
* 无参
* 无返回值
*/
void CNode::in() {
	node* p = head;
	cout << endl;
	cout << "导入文件会导致未保存的数据丢失，继续输入1，返回主界面输入2：";
	int iChoice = 2;
	cin >> iChoice;
	if (iChoice == 2) {
		system("pause");
		return;
	}
	//string strFile = "test.txt";
	ifstream ifs;
	ifs.open("test.txt", ios::in);

	if (!ifs.is_open()) {	//判断文件是否存在
		cout << endl;
		cout << "文件不存在，即将返回到主界面" << endl;
		ifs.close();
		system("pause");
		return;
	}

	char cC;
	ifs >> cC;
	if (ifs.eof()) {
		cout << endl;
		cout << "文件内容为空" << endl;
		ifs.close();
		head->next = NULL;
		head->iAge = 0;
		head->iHPhone ="";
		head->iId = 0;
		head->iSex = 0;
		head->iTPhone = "";
		head->strName = "";
		cout << "即将返回主界面" << endl;
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

	cout << "文件导入完成" << endl << endl;
	ifs.close();
	system("pause");
	return;
}


/*
* 方法作用：导出文件
* 无参
* 无返回值
*/
void CNode::out() {
	ofstream ofs;
	ofs.open("test.txt", ios::out);
	node* p = head;

	if (p->next == NULL) {
		cout << "文件为空，请先导入，即将返回到主界面" << endl;
		system("pause");
		return;
	}
	while (p->next!=NULL) {	//写入数据
		p = p->next;
		ofs << p->iId << "\t"
			<< p->strName << "\t"
			<< p->iSex << "\t"
			<< p->iAge << "\t"
			<< p->iHPhone << "\t"
			<< p->iTPhone <<"\t" << endl;
	}

	ofs.close();
	cout << "文件导出成功，即将返回到主界面" << endl;
	system("pause");
	return;
}


/*
* 方法作用：在屏幕上显示出主菜单
* 无参
* 无返回值
*/
void CNode::menu() {
	cout << "请选择下面的一个项目:" << endl;
	cout << "	1 创建" << endl;
	cout << "	2 添加" << endl;
	cout << "	3 查询" << endl;
	cout << "	4 修改" << endl;
	cout << "	5 删除" << endl;
	cout << "	6 显示" << endl;
	cout << "	7 文件导入" << endl;
	cout << "	8 文件导出" << endl;
	cout << "	9 退出" << endl;
	cout << "        请选择：";
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
			cout << "已退出系统" << endl;
			exit(0);
		}
	}
	
}

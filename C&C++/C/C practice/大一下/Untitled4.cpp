#include<iostream>
#include<fstream>

using namespace std;

class person{
	public:
		char m_Name[64];
		int m_Age;
};

void test01(){
//	ofstream ofs;
//	ofs.open("person.txt",ios::out|ios::binary);
//	person p = {"уехЩ",18};
//	ofs.write((const char *)&p,sizeof(person));

	ifstream ifs;
	ifs.open("person.txt",ios::in|ios::binary);
	person p;
	ifs.read((char *)&p,sizeof(person));
	cout << p.m_Name << p.m_Age << endl;
	ifs.close();
	
//	ofs.close();
}

int main(){
	test01();
	return 0;
}

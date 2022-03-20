#include<fstream>
#include<iostream>
#include<string>
using namespace std;

void test01(){
//	ofstream ofs;
//	ofs.open("test.txt",ios::out);
//	ofs << "ÕÅÈý" << endl << "19" << endl;
//	ofs.close();

	ifstream ifs;
	ifs.open("test.txt",ios::in);
//	char buf[1024] = {0};
//	while ( ifs >> buf ){
//		cout << buf << endl;
//	}

//	while ( ifs.getline(buf,sizeof(buf))){
//		cout << buf << endl;
//	}
	
//	string buf;
//	while( getline(ifs,buf)){
//		cout << buf << endl;
//	}
	
//	char c;
//	while( (c = ifs.get()) != EOF ){
//		cout << c;
//	}
	ifs.close();
}

int main(){
	test01();
	return 0;
}

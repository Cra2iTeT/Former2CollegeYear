#include <iostream>
#include <string>
using namespace std;

void reverse_string(string &str)
{
	int i=0,j=str.size()-1;
	while(i<j){
		std::swap(str[i++],str[j--]);
	}
}

int main(int argc, char const *argv[])
{
    string str;
    getline(cin, str);        //�����ַ���
    reverse_string(str);     //�����ַ���str
    cout << str << endl;    //����������ַ���
    return 0;
}

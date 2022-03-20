#include<iostream>
#include<string>
using namespace std;
int main(){
	int j;
	string i;
	getline(cin,i);
	j=i.size();
	j--;
	unsigned int k,l;
	for(l=0,k=1;j>=0;j--){
		l+=k*(i[j]-'0');
		k*=2;
	}
	cout<<l;
	return 0;
}

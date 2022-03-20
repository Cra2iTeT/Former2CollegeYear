#include<iostream>
#include<stdlib.h>
using namespace std;
int main(){
	int i=0;
	for(;i<15;i++)
		cout<<(rand()%(5-2))+2<<endl;
}

#include<iostream>
#include<string.h>
using namespace std;
int main()
{
	char a[1001];
	int n,m,i;
	gets(a);
	m=strlen(a);
	cin>>n;
	n=n%m;
	for(i=n;a[i];i++) cout<<a[i];
	for(i=0;i<n;i++) cout<<a[i];
	return 0;
}

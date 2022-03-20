#include<iostream>
#include<list>
#include<algorithm>
#include<stdio.h>
using namespace std;
int main(){
    int i,a[10],b;
    for(i=0; i<10; i++){
        scanf("%d",&a[i]);
    }
    scanf("%d",&b);//插入的数
    {

/*请在这里填写答案*/
std::list<int> z;
z.insert(z.begin(),a,a+10);
z.insert(z.begin(),b);
list<int>::iterator c;
c=z.begin();
while(c!=z.end()){
	cout<<"["<<*c<<"]";
	c++;
}
cout<<endl;
std::list<int> z1;
z.sort();
z.reverse();
z.pop_back();
c=z.begin();
while(c!=z.end()){
    cout<<"["<<*c<<"]";
    c++;
}
cout<<endl;
z.clear();
    }
    return 0;
}

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(void)
{
    int i,a[10],b;
    for(i=0; i<10; i++){
        scanf("%d",&a[i]);
    }
    scanf("%d",&b);//插入的数
    {

/*请在这里填写答案*/
std::vector<int> z;
z.insert(z.begin(),a,a+10);
z.insert(z.begin(),b);
vector<int>::iterator p;
p=z.begin();
while(p!=z.end()){
    cout<<"["<<*p<<"]";
    p++;
}
cout<<endl;
sort(z.begin(),z.end());
z.pop_back();
p=z.begin();
while(p!=z.end()){
    cout<<"["<<*p<<"]";
    p++;
}
cout<<endl;
z.clear();
    }
    return 0;
}

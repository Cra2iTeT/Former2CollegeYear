#include <iostream>
using namespace std;

/*请在这里填写答案*/
template<class T>
T Double(T a){
	return 2*a;
}

int main(void){
    char c='\0';
    int i=0;
    long l=0;
    scanf("%c%d%ld",&c,&i,&l);
    cout<<Double(c)<<endl;
    cout<<Double(i)<<endl;
    cout<<Double(l)<<endl;
    float f=1.1;
    double d=2.2;
    scanf("%f%lf",&f,&d);
    cout<<Double(f)<<endl;
    cout<<Double(d)<<endl;
    return 0;
}


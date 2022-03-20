#include <iostream>
using namespace std;

/*请在这里填写答案*/
class Adder{
private:
    int num;
public:
    Adder(int x=0){
        num=x;
        cout<<"Adder Constructor run"<<endl;
    }
    Adder(const Adder &a){
        num=a.num;
        cout<<"Adder CopyConstructor run"<<endl;
    }
    ~Adder(){
        cout<<"Adder Destructor run"<<endl;
    }
    void setNum(int x){
        num=x;
    }
    int getNum() const{
        return num;
    }
    Adder operator + (Adder &a){
        Adder t;
        t.num=num+a.num;
        return t;
    }
    Adder operator ++ (int){
        Adder t=*this;
        num++;
        return t;
    }
    Adder &operator ++ (){
        ++num;
        return *this;
    }
    void show() const{
        cout<<"Adder("<<num<<")"<<endl;
    }
};
//主函数
int main(void){
    int x;
    Adder a1,a2(a1);
    cin>>x;
    (a1++).show();
    a1.show();
    a2.setNum(x);
    (++a2).show();
    a2.show();
    (a1+a2).show();
    return 0;
}

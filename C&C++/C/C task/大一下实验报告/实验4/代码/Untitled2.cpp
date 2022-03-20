#include <iostream>
using namespace std;

/*请在这里填写答案*/
template<class A>
class Absolute{
    private:
        A s;
    public:
        Absolute(A t){
            s=t;
        }
        A getValue(void) const{
            if(s>0) return s;
            else return -s;
        }
};
int main(void){
    char c='\0';
    int i=0;
    long l=0;
    scanf("%c%d%ld",&c,&i,&l);
    float f=1.1;
    double d=2.2;
    scanf("%f%lf",&f,&d);
    Absolute<char> dc(c);
    cout<<dc.getValue()<<endl;
    Absolute<int> di(i);
    cout<<di.getValue()<<endl;
    Absolute<long> dl(l);
    cout<<dl.getValue()<<endl;
    Absolute<float> df(f);
    cout<<df.getValue()<<endl;
    Absolute<double> dd(d);
    cout<<dd.getValue()<<endl;
    return 0;
}

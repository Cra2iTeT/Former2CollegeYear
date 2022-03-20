#include <iostream>
using namespace std;

/*请在这里填写答案*/
class Complex{
	private:
		double real;
		double imag;
	public:
		Complex(double r = 0.0,double i = 0.0){
			real=r;
			imag=i;
		}
		~Complex(){}
		friend Complex operator+(const Complex &x,const Complex &y){
			Complex temp;
			temp.real = y.real + x.real;
			temp.imag = y.imag + x.imag;
			return temp;
		}
		friend Complex operator - (const Complex &x,const Complex &y){
			Complex temp;
			temp.real = x.real - y.real;
			temp.imag = x.imag - y.imag;
			return temp;
		}
		friend Complex operator * (const Complex &x,const Complex &y){
			Complex temp;
			double a,b,c,d;
			a = x.real*y.real;
			b = x.real*y.imag;
			c = x.imag*y.real;
			d = x.imag*y.imag;
			temp.real = a - d;
			temp.imag = c + b;
			return temp;
		}
		friend Complex operator / (const Complex &x,const Complex &y){
			Complex temp;
			double a,b,c;
			a = y.real * y.real + y.imag * y.imag;
			b = x.real * y.real + x.imag * y.imag;
			c = x.imag * y.real - x.real * y.imag;
			temp.real = b / a;
			temp.imag = c / a;
			return temp;
		}
		friend ostream &operator << (ostream &out,Complex &TeT){
			if(TeT.imag>0){
				out<<TeT.real<<"+"<<TeT.imag<<"i";
			}
			else{
				out<<TeT.real<<TeT.imag<<"i";
			}
			return out;
		}
		friend istream &operator >> (istream &in,Complex &TeT){
			in>>TeT.real>>TeT.imag;
			return in;
		}
};
int main()      //主函数
{
    Complex c1(1, 1), c2(-1, -1), c3;    //定义复数类的对象
    cin>>c1;
    cout <<c1<<endl;
    cout <<c2<<endl;
    c3 = c1 - c2;
    cout << c3<<endl;
    c3 = c1 + c2;
    cout << c3<<endl;
    c3=c1 * c2;
    cout << c3<<endl;
    c3=c1 / c2;
    cout << c3<<endl;
    return 0;
}

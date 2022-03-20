#include<iostream>

using namespace std;

class Complex
{
    public:
        Complex(double r=0,double i=0):real(r), imag(i){    }
        Complex operator+(Complex &a) const;//重载双目运算符'+'
        Complex operator-=(Complex &a); //重载双目运算符'-='
        friend Complex operator-(Complex &a,Complex &b);//重载双目运算符'-'
        void Display() const;
    private:
        double real;
        double imag;
};

Complex Complex::operator+(Complex &a) const{
	Complex temp;
	temp.real=real+a.real;
	temp.imag=imag+a.imag;
	return temp;
}
Complex Complex::operator-=(Complex &a){
	real=real-a.real;
	imag=imag-a.imag;
	return Complex(real,imag);
}
Complex operator-(Complex &a,Complex &b){
	return Complex(a.real-b.real,a.imag-b.imag);
}
void Complex::Display() const
{
    cout << "(" << real << ", " << imag << ")" << endl;
}

int main()
{
    double r, m;
    cin >> r >> m;
    Complex c1(r, m);
    cin >> r >> m;
    Complex c2(r, m);
    Complex c3 = c1+c2;
    c3.Display();
    c3 = c1-c2;
    c3.Display();
    c3 -= c1;
    c3.Display();
    return 0;
}

#include<iostream>
using namespace std;
const double PI=3.1415;
class Circle
{
	private:
		double radius;
	public:
		void setRadius(double);
		double getRadius();
		double circumference();
		double area();
		friend double fCircle_L(Circle &r);
		friend double fCircle_S(Circle &r);
		~Circle(){
			cout<<"Destructor run"<<endl;
		}
		Circle(double radius=0.0){
			cout<<"Constructor run"<<endl;
		}
		Circle(Circle &r){
			radius=r.radius;
			cout<<"CopyConstructor run"<<endl;
		}
};

void Circle::setRadius(double r){		//设置半径 
	radius=r;
}
double Circle::getRadius(){
	return radius;
}

double Circle::circumference(){		//计算周长 
	return 2*PI*radius;
}
double Circle::area(){
	return PI*radius*radius;
}

double fCircle_L(Circle &r){
	return r.circumference();
}
double fCircle_S(Circle &r){
	return r.area();
}
int main(void){
    double  r;
    cin >> r;
    Circle  c1;
    c1.setRadius(r);
    cout << c1.circumference() << endl;
    cout << c1.area() << endl;
    Circle  c2(c1);
    cout << fCircle_L(c2) << endl;
    cout << fCircle_S(c2) << endl;
    return 0;
}

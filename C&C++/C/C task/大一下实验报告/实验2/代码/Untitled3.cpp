#include <iostream>
using namespace std;
//Point类
class Point{
protected:
    double x;
    double y;
public:
    Point(double xv=0,double yv=0);//有参构造
    Point(const Point &p);         //拷贝构造
    ~Point();                      //析构函数
    void show() const;             //显示Point信息
    double area()const;            //面积=0
    void setX(double xv);          //设置X坐标
    void setY(double yv);          //设置Y坐标
    double getX() const;           //获取X坐标
    double getY() const;           //获取Y坐标
};
//有参构造
Point::Point(double xv,double yv){
    x=xv;
    y=yv;
    cout<<"Point Constructor run"<<endl;
}
//拷贝构造
Point::Point(const Point &p){
    x=p.x;
    y=p.y;
    cout<<"Point CopyConstructor run"<<endl;
}
//析构函数
Point::~Point(){
    cout<<"Point Destructor run"<<endl;
}
//显示Point
void Point::show() const{
    cout<<"("<<x<<","<<y<<")";
}
//设置X坐标
void Point::setX(double xv){
    x=xv;
}
//设置Y坐标
void Point::setY(double yv){
    y=yv;
}
//面积函数
double Point::area() const{
    return 0;
}
//获取X坐标
double Point::getX() const{
    return x;
}
//获取Y坐标
double Point::getY() const{
    return y;
}

const double PI=3.14159;

class Circle:public Point{
	double radius;
	public:
		Circle(double x=0,double y=0,double r=0):Point(x,y){
			this->radius=r;
			cout<<"Circle Constructor run"<<endl;
		}
		Circle(Circle &a):Point(a){
			//x=a.x;
			//y=a.y;
			radius=a.radius;
			cout<<"Circle CopyConstructor run"<<endl;
		}
		~Circle(){
			cout<<"Circle Destructor run"<<endl;
		}
		void setRadius(double r=0){
			radius=r;
		}
		double getRadius() const{
			return radius;
		}
		double circumference() const{
			return 2*PI*radius;
		}
		double area() const{
			return PI*radius*radius;
		}
		void show() const{
			cout<<"("<<x<<","<<y<<"),Radius="<<radius; 
		}
};

class Sphere:public Circle{
	public:
		Sphere(double x=0,double y=0,double r=0):Circle(x,y,r){
			//x=Point::getX();
			//y=Point::getY();
			//this->radius=r;
			cout<<"Sphere Constructor run"<<endl;
		}
		Sphere(Sphere &a):Circle(a){
			//x=a.x;
			//y=a.y;
			//radius=a.radius;
			cout<<"Sphere CopyConstructor run"<<endl; 
		}
		~Sphere(){
			cout<<"Sphere Destructor run"<<endl;
		}
		double volume() const{
			double r=Circle::getRadius();
			return 4*PI*r*r*r/3;
		}
		double area() const{
			double r=Circle::getRadius();
			return 4*PI*r*r;
		}
};
//主函数
int main(void){
    double  r;
    cin>>r;
    Sphere s1(1,2,4),s2(s1);
    s1.show();
    cout<<endl<<"Area="<<s1.area()<<endl<<"Volume="<<s1.volume()<<endl;
    s2.setRadius(r);
    s2.Circle::show();
    cout<<endl<<"Area="<<s2.Circle::area()<<endl<<"Circumference="<<s2.Circle::circumference()<<endl;
    return 0;
}

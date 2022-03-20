#include <iostream>
using namespace std;
//Point��
class Point{
protected:
    double x;
    double y;
public:
    Point(double xv=0,double yv=0);//�вι���
    Point(const Point &p);         //��������
    ~Point();                      //��������
    void show() const;             //��ʾPoint��Ϣ
    double area()const;            //���=0
    void setX(double xv);          //����X����
    void setY(double yv);          //����Y����
    double getX() const;           //��ȡX����
    double getY() const;           //��ȡY����
};
//�вι���
Point::Point(double xv,double yv){
    x=xv;
    y=yv;
    cout<<"Point Constructor run"<<endl;
}
//��������
Point::Point(const Point &p){
    x=p.x;
    y=p.y;
    cout<<"Point CopyConstructor run"<<endl;
}
//��������
Point::~Point(){
    cout<<"Point Destructor run"<<endl;
}
//��ʾPoint
void Point::show() const{
    cout<<"("<<x<<","<<y<<")";
}
//����X����
void Point::setX(double xv){
    x=xv;
}
//����Y����
void Point::setY(double yv){
    y=yv;
}
//�������
double Point::area() const{
    return 0;
}
//��ȡX����
double Point::getX() const{
    return x;
}
//��ȡY����
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
//������
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

#include <iostream>
using namespace std;
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

const double PI = 3.14159;

class Circle:public Point{
	private:
		//double x;
		//double y;
		double radius;
	public:
		Circle(double x = 0,double y = 0,double r = 0):Point(x,y){
			//this->x = xx;
			//this->y = yy;
			this->radius = r;
			cout<<"Circle Constructor run"<<endl;
		}
		Circle(Circle &r):Point(r){
			x = r.x;
			y = r.y;
			radius = r.radius;
			cout<<"Circle CopyConstructor run"<<endl;
		}
		~Circle(){
			cout<<"Circle Destructor run"<<endl;
		}
		void setRadius(double r);		//���غ�����radius
		double getRadius() const;
		double circumference() const;		//����Բ���ܳ�
		double area() const;		//����Բ�����
		void show() const;		//��ʾԲ����Ϣ����ʾ��ʽΪ��(Բ��X����,Բ��Y����),Radius=�뾶
};

//���غ�����radius
void Circle::setRadius(double r){
	radius = r;
}
double Circle::getRadius() const{
	return radius;
}

//����Բ���ܳ�
double Circle::circumference() const{
	return 2*PI*radius;
}

//����Բ�����
double Circle::area() const{
	return PI*radius*radius;
}

//��ʾԲ����Ϣ����ʾ��ʽΪ��(Բ��X����,Բ��Y����),Radius=�뾶
void Circle::show() const{
	cout<<"("<<x<<","<<y<<"),Radius="<<radius;
}

int main(void){
    double  r;
    cin>>r;
    Circle c1(1,2,4),c2,c3(c1);
    c1.show();
    cout<<endl<<"Area="<<c1.area()<<endl<<"Circumference="<<c1.circumference()<<endl;
    c2.show();
    cout<<endl<<"Area="<<c2.area()<<endl<<"Circumference="<<c2.circumference()<<endl;
    c3.setRadius(r);
    c3.show();
    cout<<endl<<"Area="<<c3.area()<<endl<<"Circumference="<<c3.circumference()<<endl;
    return 0;
}

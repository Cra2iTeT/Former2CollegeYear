#include <iostream>
using namespace std;
//����Point
class Point{
private:
    double x;
    double y;
public:
    Point(double xv=0,double yv=0);/*���캯��*/
    Point(const Point &p);         /*��������*/
    ~Point();                      /*��������*/
    virtual void show()const;      /*��ʾ*/
    void setX(double xv);          /*����X����*/
    void setY(double yv);          /*����Y����*/
    double getX() const;           /*��ȡX����*/
    double getY() const;           /*��ȡY����*/
};
Point::Point(const double xv,const double yv){/*���캯��*/
    x=xv;
    y=yv;
    cout<<"Point Constructor run"<<endl;
}
Point::Point(const Point &p){/*��������*/
    x=p.x;
    y=p.y;
    cout<<"Point CopyConstructor run"<<endl;
}
Point::~Point(){/*��������*/
    cout<<"Point Destructor run"<<endl;
}
void Point::show() const{/*��ʾ*/
    cout<<"Point(X="<<x<<",Y="<<y<<")";
}
void Point::setX(double xv){/*����X����*/
    x=xv;
}
void Point::setY(double yv){/*����Y����*/
    y=yv;
}
double Point::getX() const{/*��ȡX����*/
    return x;
}
double Point::getY() const{/*��ȡY����*/
    return y;
}
class Plane{/*ƽ��ͼ�λ���*/
public:
    virtual double length()const=0;/*�ܳ�*/
    virtual double area()const=0;  /*���*/
};

/*����������д��*/

class Circle:public Plane,public Point{
	private:
		double x;
		double y;
		double radius;
	protected:
		static double PI;
	public:
		Circle(double x=0,double y=0,double r=0):Point(x,y){
			radius=r;
			cout<<"Circle Constructor run"<<endl;
		}
		Circle(const Circle &t):Point(t){
			radius=t.radius;
			cout<<"Circle CopyConstructor run"<<endl;
		}
		~Circle(){
			cout<<"Circle Destructor run"<<endl;
		}
		void setR(double r){
			radius=r;
		}
		double getR() const{
			return radius;
		}
		void show() const{
			cout<<"Circle(Point(X="<<getX()<<",Y="<<getY()<<"),Radius="<<radius<<")";
		}
		double area() const{
			return PI*radius*radius;
		}
		double length() const{
			return 2*PI*radius;
		}
};

double Circle::PI=3.14159;
void show(Point *p){/*��������ʾ����*/
    p->show();
}
void length(Plane *p){/*ƽ��ͼ�ε��ܳ�����*/
    cout<<"Length="<<p->length()<<endl;
}
void area(Plane &p){/*ƽ��ͼ�ε��������*/
    cout<<"Area="<<p.area()<<endl;
}
//������
int main(void){
    double x,y,r;
    Circle c1,c2(c1);
    show(&c1);
    cout<<endl;
    area(c1);
    length(&c1);
    cin>>x>>y>>r;
    c2.setX(x);
    c2.setY(y);
    c2.setR(r);
    show(&c2);
    cout<<endl;
    area(c2);
    length(&c2);
}


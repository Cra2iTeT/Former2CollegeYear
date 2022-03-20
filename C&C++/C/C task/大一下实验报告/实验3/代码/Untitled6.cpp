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
    void setX(double xv);          /*����X����*/
    void setY(double yv);          /*����Y����*/
    double getX()const;            /*��ȡX����*/
    double getY()const;            /*��ȡY����*/
    virtual void show()const;      /*��ʾ*/
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
void Point::setX(double xv){/*����X����*/
    x=xv;
}
void Point::setY(double yv){/*����Y����*/
    y=yv;
}
double Point::getX()const{/*��ȡX����*/
    return x;
}
double Point::getY()const{/*��ȡY����*/
    return y;
}
void Point::show()const{/*��ʾ*/
    cout<<"Point(X="<<x<<",Y="<<y<<")";
}
//ƽ��ͼ����Plane
class Plane{
public:
    virtual double length()const=0;/*�ܳ�*/
    virtual double area()const=0;  /*���*/
};
//����ͼ����Solid
class Solid{
public:
    virtual double volume()const=0;/*���*/
    virtual double s_Area()const=0;/*�����*/
};

/*����������д��*/

class Circle:public Point,public Plane{
	private:
		double x,y,radius;
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

class Cylinder:public Circle,public Solid{
	private:
		double x,y,radius,height;
	public:
		Cylinder(double x,double y,double r,double h):Circle(x,y,r){
			height=h;
			cout<<"Cylinder Constructor run"<<endl;
		}
		Cylinder(const Cylinder &zcy):Circle(zcy){
			height=zcy.height;
			cout<<"Cylinder CopyConstructor run"<<endl;
		}
		~Cylinder(){
			cout<<"Cylinder Destructor run"<<endl;
		}
		void setH(double h){
			height=h;
		}
		double getH() const{
			return height;
		}
		void show() const{
			cout<<"Cylinder(Circle(Point(X="<<getX()<<",Y="<<getY()<<"),Radius="<<getR()<<"),Height="<<getH()<<")";
		}
		double s_Area()const{
			double ar,lh;
			ar=2*(Circle::area());
			lh=Circle::length();
			ar+=(lh*getH());
			return ar;
		}
		double volume()const{
			double ar;
			ar=Circle::area();
			return ar*getH();
		}
};
void show(Point *p){/*��������ʾ����*/
    p->show();
}
void length(Plane *p){/*ƽ��ͼ�ε��ܳ�����*/
    cout<<"Length="<<p->length()<<endl;
}
void area(Plane &p){/*ƽ��ͼ�ε��������*/
    cout<<"Area="<<p.area()<<endl;
}

void volumn(Solid *s){/*����ͼ�ε��������*/
    cout<<"Volumn="<<s->volume()<<endl;
}
void s_Area(Solid &s){/*����ͼ�εı��������*/
    cout<<"S_Area="<<s.s_Area()<<endl;
}
//������
int main(void){
    double  h;
    cin>>h;
    Cylinder cy1(1,2,3,4),cy2(cy1);
    show(&cy1);
    cout<<endl;
    area(cy1);
    length(&cy1);
    s_Area(cy1);
    volumn(&cy1);
    cy2.setH(h);
    show(&cy2);
    cout<<endl;
    area(cy2);
    length(&cy2);
    s_Area(cy2);
    volumn(&cy2);
    return 0;
}

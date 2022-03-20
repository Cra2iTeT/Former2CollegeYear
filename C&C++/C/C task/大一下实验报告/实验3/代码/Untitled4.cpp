#include <iostream>
#include<cmath>
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


class Triangle:public Plane{
	private:
		Point a;
		Point b;
		Point c;
	public:
		Triangle(const Point &a,const Point &b,const Point &c);
		Triangle(const Triangle &);
		~Triangle();
		void setA(const Point &);//set point a;
		Point getA()const;//get point a;
		void setB(const Point &);//set point b;
		Point getB()const;//get point b;
		void setC(const Point &);//set point c;
		Point getC()const;//get point c;
		void show()const;
		double area()const;
		double length()const;
};
Triangle::Triangle(const Point &A=Point(0,0),const Point &B=Point(0,0),const Point &C=Point(0,0)):a(A),b(B),c(C)
{
	cout<<"Triangle Constructor run"<<endl;
}
Triangle::Triangle(const Triangle &temp):a(temp.a),b(temp.b),c(temp.c)
{
	cout<<"Triangle CopyConstructor run"<<endl;
}
Triangle::~Triangle(){
	cout<<"Triangle Destructor run"<<endl;
}
void Triangle::setA(const Point &aa){
	a.setX(aa.getX());
	a.setY(aa.getY());
}
void Triangle::setB(const Point &bb){
	b.setX(bb.getX());
	b.setY(bb.getY());
}
void Triangle::setC(const Point &cc){
	c.setX(cc.getX());
	c.setY(cc.getY());
}
Point Triangle::getA()const{
return a;
}
Point Triangle::getB()const{
return b;
}
Point Triangle::getC()const{
return c;
}
void Triangle::show()const{
cout<<"Triangle(";
    cout<<"A=";
a.show();
cout<<",";
   cout<<"B=";
b.show();
cout<<",";
   cout<<"C=";
c.show();
cout<<")";
}
double Triangle::area()const{
		double A,B,C;
    int sum=1;
    if(sum++==1) 
    {
        Point a1(a),b1(b);
        A=sqrt((a1.getX()-b1.getX())*(a1.getX()-b1.getX())+(a1.getY()-b1.getY())*(a1.getY()-b1.getY()));
    }
    if(sum++==2)
    {
        Point a1(a),c1(c);
        B=sqrt((a1.getX()-c1.getX())*(a1.getX()-c1.getX())+(a1.getY()-c1.getY())*(a1.getY()-c1.getY()));
    }
    if(sum++==3)
    {
        Point c1(c),b1(b);
        C=sqrt((c1.getX()-b1.getX())*(c1.getX()-b1.getX())+(c1.getY()-b1.getY())*(c1.getY()-b1.getY()));
    }
	double P=(A+B+C)/2;
	return sqrt(P*(P-A)*(P-B)*(P-C));
}
double Triangle::length()const{
	double A,B,C;
    Point ax(a),ay(a);
    Point bx(b),by(b);
    Point cx(c),cy(c);
	A=sqrt((ax.getX()-bx.getX())*(ax.getX()-bx.getX())+(ay.getY()-by.getY())*(ay.getY()-by.getY()));
	B=sqrt((ax.getX()-cx.getX())*(ax.getX()-cx.getX())+(ay.getY()-cy.getY())*(ay.getY()-cy.getY()));
	C=sqrt((cx.getX()-bx.getX())*(cx.getX()-bx.getX())+(cy.getY()-by.getY())*(cy.getY()-by.getY()));
	return A+B+C;
}

void length(Plane *p){/*ƽ��ͼ�ε��ܳ�����*/
    cout<<"Length="<<p->length()<<endl;
}
void area(Plane &p){/*ƽ��ͼ�ε��������*/
    cout<<"Area="<<p.area()<<endl;
}
//������
int main(void){
    double x,y;
    Point p1,p2(1,1),p3(2,2);
    Triangle t1,t2(t1);
    t1.show();
    cout<<endl;
    area(t1);
    length(&t1);
    cin>>x>>y;
    p1.setX(x);
    p1.setY(y);
    t2.setA(p1);
    t2.setB(p2);
    t2.setC(p3);
    t2.show();
    cout<<endl;
    area(t2);
    length(&t2);
    return 0;
}

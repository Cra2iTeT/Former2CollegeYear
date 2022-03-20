#include <iostream>
#include <fstream>
using namespace std;
//����Point
class Point
{
private:
    double x;
    double y;
public:
    Point(double xv=0,double yv=0);/*���캯��*/
    void setX(double xv);          /*����X����*/
    void setY(double yv);          /*����Y����*/
    double getX() const;           /*��ȡX����*/
    double getY() const;           /*��ȡY����*/
    friend ostream & operator << (ostream &out, const Point &p); //�����<<����
    friend istream & operator >> (istream &in, Point &p); //�����>>����
};
class Plane /*ƽ��ͼ�λ���*/
{
public:
    virtual double length()const=0;/*�ܳ�*/
    virtual double area()const=0;  /*���*/
};
//Բ��Circle
class Circle:public Point,public Plane
{
private:
    double radius;
protected:
    static const double PI;
public:
    Circle(double xv=0,double yv=0,double r=0);/*���캯��*/
    void setR(double r);                       /*���ð뾶*/
    double getR() const;                       /*��ȡ�뾶*/
    double area()const;                        /*���*/
    double length()const;                      /*�ܳ�*/
    friend ostream & operator << (ostream &out, const Circle &c); //�����<<����
    friend istream & operator >> (istream &in, Circle &c); //�����>>����
};

/*����������д��һ���ִ�*/

//����
Point::Point(double xv,double yv){
	x = xv;
	y = yv;
}
void Point::setX(double xv){
	x = xv;
}
double Point::getX() const{
	return x;
}
void Point::setY(double yv){
	y = yv;
}
double Point::getY() const{
	return y;
}
ostream & operator <<(ostream &out, const Point &p){
	out.write((char *)&p,sizeof(p));
	return out;
}
istream & operator >> (istream &in, Point &p){
	in.read((char *)&p,sizeof(p));
	return in;
}
void f(Plane const &p)
{
    cout<<p.area()<<endl;
    cout<<p.length()<<endl;
}

//Բ��
Circle::Circle(double xv,double yv,double r):Point(xv,yv){
	radius = r;
}
void Circle::setR(double r){
	radius = r;
}
double Circle::getR() const{
	//cout<<radius<<";;"<<endl;
	return radius;
}
const double Circle::PI = 3.14159;
double Circle::area() const{
	return PI*radius*radius;
}
double Circle::length() const{
	return 2*PI*radius;
}
ostream & operator << (ostream &out, const Circle &c){
	out.write((char *)&c,sizeof(c));
	return out;
}
istream & operator >> (istream &in, Circle &c){
	in.read((char *)&c,sizeof(c));
	return in;
}
//������
int main(void)
{
    double d1,d2;
    cin>>d1>>d2;
    Point p(d1,d2);
    Circle c;
/*����������д�ڶ����ִ�*/
	ofstream outfile1("s3.txt",ios::trunc);
	outfile1<<p;
	outfile1.close();
	ifstream infile1("s3.txt",ios::in);
	infile1>>p;
	infile1.close();
	c.setR(p.getX()+p.getY());
	c.setX(p.getY());
	c.setY(p.getX());
	ofstream outfile2("b3.txt",ios::trunc|ios::binary);
	outfile2<<c;
	outfile2.close();
	ifstream infile2("b3.txt",ios::in|ios::binary);
	infile2>>c;
	infile2.close();
    f(c);
    return 0;
}

#include <iostream>
#include <fstream>
using namespace std;
//点类Point
class Point
{
private:
    double x;
    double y;
public:
    Point(double xv=0,double yv=0);/*构造函数*/
    void setX(double xv);          /*设置X坐标*/
    void setY(double yv);          /*设置Y坐标*/
    double getX() const;           /*获取X坐标*/
    double getY() const;           /*获取Y坐标*/
    friend ostream & operator << (ostream &out, const Point &p); //运算符<<重载
    friend istream & operator >> (istream &in, Point &p); //运算符>>重载
};
class Plane /*平面图形基类*/
{
public:
    virtual double length()const=0;/*周长*/
    virtual double area()const=0;  /*面积*/
};
//圆类Circle
class Circle:public Point,public Plane
{
private:
    double radius;
protected:
    static const double PI;
public:
    Circle(double xv=0,double yv=0,double r=0);/*构造函数*/
    void setR(double r);                       /*设置半径*/
    double getR() const;                       /*获取半径*/
    double area()const;                        /*面积*/
    double length()const;                      /*周长*/
    friend ostream & operator << (ostream &out, const Circle &c); //运算符<<重载
    friend istream & operator >> (istream &in, Circle &c); //运算符>>重载
};

/*请在这里填写第一部分答案*/

//点类
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

//圆类
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
//主函数
int main(void)
{
    double d1,d2;
    cin>>d1>>d2;
    Point p(d1,d2);
    Circle c;
/*请在这里填写第二部分答案*/
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

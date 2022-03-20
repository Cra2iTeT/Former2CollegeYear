#include <iostream>
using namespace std;
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
		void setRadius(double r);		//返回和设置radius
		double getRadius() const;
		double circumference() const;		//计算圆的周长
		double area() const;		//计算圆的面积
		void show() const;		//显示圆的信息，显示格式为：(圆心X坐标,圆心Y坐标),Radius=半径
};

//返回和设置radius
void Circle::setRadius(double r){
	radius = r;
}
double Circle::getRadius() const{
	return radius;
}

//计算圆的周长
double Circle::circumference() const{
	return 2*PI*radius;
}

//计算圆的面积
double Circle::area() const{
	return PI*radius*radius;
}

//显示圆的信息，显示格式为：(圆心X坐标,圆心Y坐标),Radius=半径
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

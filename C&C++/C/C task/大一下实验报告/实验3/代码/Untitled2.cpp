#include <iostream>
using namespace std;
//点类Point
class Point{
private:
    double x;
    double y;
public:
    Point(double xv=0,double yv=0);/*构造函数*/
    Point(const Point &p);         /*拷贝构造*/
    ~Point();                      /*析构函数*/
    virtual void show()const;      /*显示*/
    void setX(double xv);          /*设置X坐标*/
    void setY(double yv);          /*设置Y坐标*/
    double getX() const;           /*获取X坐标*/
    double getY() const;           /*获取Y坐标*/
};
Point::Point(const double xv,const double yv){/*构造函数*/
    x=xv;
    y=yv;
    cout<<"Point Constructor run"<<endl;
}
Point::Point(const Point &p){/*拷贝构造*/
    x=p.x;
    y=p.y;
    cout<<"Point CopyConstructor run"<<endl;
}
Point::~Point(){/*析构函数*/
    cout<<"Point Destructor run"<<endl;
}
void Point::show() const{/*显示*/
    cout<<"Point(X="<<x<<",Y="<<y<<")";
}
void Point::setX(double xv){/*设置X坐标*/
    x=xv;
}
void Point::setY(double yv){/*设置Y坐标*/
    y=yv;
}
double Point::getX() const{/*获取X坐标*/
    return x;
}
double Point::getY() const{/*获取Y坐标*/
    return y;
}
class Plane{/*平面图形基类*/
public:
    virtual double length()const=0;/*周长*/
    virtual double area()const=0;  /*面积*/
};

/*请在这里填写答案*/

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
void show(Point *p){/*点基类的显示函数*/
    p->show();
}
void length(Plane *p){/*平面图形的周长函数*/
    cout<<"Length="<<p->length()<<endl;
}
void area(Plane &p){/*平面图形的面积函数*/
    cout<<"Area="<<p.area()<<endl;
}
//主函数
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


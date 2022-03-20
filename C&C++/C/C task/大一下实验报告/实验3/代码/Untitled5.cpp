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
    void setX(double xv);          /*设置X坐标*/
    void setY(double yv);          /*设置Y坐标*/
    double getX()const;            /*获取X坐标*/
    double getY()const;            /*获取Y坐标*/
    virtual void show()const;      /*显示*/
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
void Point::setX(double xv){/*设置X坐标*/
    x=xv;
}
void Point::setY(double yv){/*设置Y坐标*/
    y=yv;
}
double Point::getX()const{/*获取X坐标*/
    return x;
}
double Point::getY()const{/*获取Y坐标*/
    return y;
}
void Point::show()const{/*显示*/
    cout<<"Point(X="<<x<<",Y="<<y<<")";
}
//平面图形类Plane
class Plane{
public:
    virtual double length()const=0;/*周长*/
    virtual double area()const=0;  /*面积*/
};
//立体图形类Solid
class Solid{
public:
    virtual double volume()const=0;/*体积*/
    virtual double s_Area()const=0;/*表面积*/
};

/*请在这里填写答案*/

class Circle:public Point,public Plane{
	private:
		double x,y;
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
class Sphere:public Circle,public Solid{
	private:
		double x,y,radius;
	public:
		Sphere(double x=0,double y=0,double r=0):Circle(x,y,r){
			cout<<"Sphere Constructor run"<<endl;
		}
		Sphere(const Sphere &t):Circle(t){
			cout<<"Sphere CopyConstructor run"<<endl;
		}
		~Sphere(){
			cout<<"Sphere Destructor run"<<endl;
		}
		void show() const{
			cout<<"Sphere(Circle(Point(X="<<getX()<<",Y="<<getY()<<"),Radius="<<getR()<<"))";
		}
		double s_Area()const{
			return 4*PI*getR()*getR();
		}
		double volume()const{
			return 4*PI*getR()*getR()*getR()/3;
		}
};
void show(Point *p){/*点基类的显示函数*/
    p->show();
}
void length(Plane *p){/*平面图形的周长函数*/
    cout<<"Length="<<p->length()<<endl;
}
void area(Plane &p){/*平面图形的面积函数*/
    cout<<"Area="<<p.area()<<endl;
}

void volumn(Solid *s){/*立体图形的体积函数*/
    cout<<"Volumn="<<s->volume()<<endl;
}
void s_Area(Solid &s){/*立体图形的表面积函数*/
    cout<<"S_Area="<<s.s_Area()<<endl;
}
//主函数
int main(void){
    double  r;
    cin>>r;
    Sphere s1(1,2,3),s2(s1);
    show(&s1);
    cout<<endl;
    area(s1);
    length(&s1);
    s_Area(s1);
    volumn(&s1);
    s2.setR(r);
    show(&s2);
    cout<<endl;
    area(s2);
    length(&s2);
    s_Area(s2);
    volumn(&s2);
    return 0;
}

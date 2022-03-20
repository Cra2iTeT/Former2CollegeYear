#include <iostream>
using namespace std;
//Person类
class Person{
protected:
    char no[20];                   //身份证号
    char name[20];                //姓名
public:
    Person(char *str1=0,char *str2=0);//有参构造
    Person(const Person &p);        //拷贝构造
    ~Person();                    //析构函数
    void show() const;             //显示Person信息
    void setNo(char *str);          //设置身份证号
    void setName(char *str);        //设置姓名
    char *getNo();                //获取身份证号
    char* getName();              //获取姓名
};
//有参构造
Person::Person(char *str1,char *str2){
    int i;
    i=0;
    if(str1!=0)
        while(str1[i]!='\0'){
            no[i]=str1[i];
            i++;
        }
    no[i]='\0';
    i=0;
    if(str2!=0)
        while(str2[i]!='\0'){
            name[i]=str2[i];
            i++;
        }
    name[i]='\0';
    cout<<"Person Constructor run"<<endl;
}
//拷贝构造
Person::Person(const Person &p){
    int i=0;
    while(p.no[i]!='\0'){
        no[i]=p.no[i];
        i++;
    }
    no[i]='\0';
    i=0;
    while(p.name[i]!='\0'){
        name[i]=p.name[i];
        i++;
    }
    name[i]='\0';
    cout<<"Person CopyConstructor run"<<endl;
}
//析构函数
Person::~Person(){
    cout<<"Person Destructor run"<<endl;
}
//显示Person
void Person::show() const{
    cout<<"No="<<no<<",Name="<<name<<endl;
}
//设置身份证号
void Person::setNo(char *str){
    int i=0;
    if (str)
        while(str[i]!='\0'){
            no[i]=str[i];
            i++;
        }
    no[i]='\0';
}
//设置姓名
void Person::setName(char *str){
    int i=0;
    if (str)
        while(str[i]!='\0'){
            name[i]=str[i];
            i++;
        }
    name[i]='\0';
}
//获取身份证号
char* Person::getNo(){
    return no;
}
//获取姓名
char* Person::getName(){
    return name;
}

class Teacher:public Person{
	char tNo[10];
	char departmentName[20];
	double wages;
	public:
		Teacher(char *a=0, char *b=0, char *c=0, char *d=0, double e=0.0):Person(a,b){
			int i;
			char *p1=getNo();
			char *p2=getName();
			for(i=0;p1[i]!='\0';i++){
				no[i]=p1[i];
			}
			no[i]='\0';
			for(i=0;p2[i]!='\0';i++){
				name[i]=p2[i];
			}
			name[i]='\0';
			for(i=0;c[i]!='\0';i++){
				tNo[i]=c[i];
			}
			tNo[i]='\0';
			for(i=0;d[i]!='\0';i++){
				departmentName[i]=d[i];
			}
			departmentName[i]='\0';
			wages=e;
			cout<<"Teacher Constructor run"<<endl;
		}
		Teacher(const  Teacher  &f):Person(f){
			int i;
			for(i=0;f.no[i]!='\0';i++){
				no[i]=f.no[i];
			}
			no[i]='\0';
			for(i=0;f.name[i]!='\0';i++){
				name[i]=f.name[i];
			}
			name[i]='\0';
			for(i=0;f.tNo[i]!='\0';i++){
				tNo[i]=f.tNo[i];
			}
			tNo[i]='\0';
			for(i=0;f.departmentName[i]!='\0';i++){
				departmentName[i]=f.departmentName[i];
			}
			departmentName[i]='\0';
			wages=f.wages;
			cout<<"Teacher CopyConstructor run"<<endl;
		}
		~Teacher(){
			cout<<"Teacher Destructor run"<<endl;
		}
		void  setTNo(char *);
		char * getTNo();
		void  setDepartmentName(char *);
		char*  getDepartmentName();
		void  setWages(double );
		double  getWages();
		void show() const;
};

//分别返回和设置工号tNo
void Teacher::setTNo(char *a='\0'){
	int i=0;
	while(a[i]!='\0'){
		tNo[i]=a[i];
		i++;
	}
	tNo[i]='\0';
}
char *Teacher::getTNo(){
	return tNo;
}

//返回和设置部门departmentName
void Teacher::setDepartmentName(char *a='\0'){
	int i=0;
	while(a[i]!='\0'){
		departmentName[i]=a[i];
		i++;
	}
	departmentName[i]='\0';
}
char *Teacher::getDepartmentName(){
	return departmentName;
}

//返回和设置工资wages
void Teacher::setWages(double w=0.0){
	wages=w;
}
double Teacher::getWages(){
	return wages;
}

//显示教师的基本信息
void Teacher::show() const{
	int t;
	double T;
	t=(int)(wages*10);
	if((t%10)>4)
		T=t/10+1;
	else T=t/10;
	cout<<"No="<<no<<",Name="<<name<<endl;
	cout<<"TNo="<<tNo<<",DepartmentName="<<departmentName<<",Wages="<<T<<endl;
}

class Student:public Person{
	char no[20];
	char name[20];
	char sNo[10];
	char className[20];
	double score;
	public:
		Student(char*a=NULL,char *b=NULL,char*c=NULL,char*d=NULL,double t=0):Person(a,b){
		char *p1=getNo();
		char *p2=getName();
		int i;
		for(i=0;p1[i]!='\0';i++){
			no[i]=p1[i];
		}
		no[i]='\0';
		for(i=0;p2[i]!='\0';i++){
			name[i]=p2[i];
		}
		name[i]='\0';
		for(i=0;c[i]!='\0';i++){
			sNo[i]=c[i];
		}
		sNo[i]='\0';
		for(i=0;d[i]!='\0';i++){
			className[i]=d[i];
		}
		className[i]='\0';
		score=t;
		cout<<"Student Constructor run"<<endl;
	}
	Student(const  Student  &f):Person(f){
		int i=0;
	while(f.no[i]!='\0'){
		no[i]=f.no[i];
		i++;
	}
	no[i]='\0';
	i=0;
	while(f.name[i]!='\0'){
		name[i]=f.name[i];
		i++;
	}
	name[i]='\0';
	i=0;
	while(f.sNo[i]!='\0'){
		sNo[i]=f.sNo[i];
		i++;
	}
	sNo[i]='\0';
	i=0;
	while(f.className[i]!='\0'){
		className[i]=f.className[i];
		i++;
	}
	className[i]='\0';
	score=f.score;
	cout<<"Student CopyConstructor run"<<endl;
}
	~Student(){
		cout<<"Student Destructor run"<<endl;
	}
	void  setSNo(char *);
	char * getSNo();
	void  setClassName(char *);
	char*  getClassName();
	void  setScore(double );
	double  getScore();
	void show() const{
		cout<<"No="<<no<<",Name="<<name<<endl;
		int t,T;
		t=(int)(score*10);
		if((t%10)>4)
			T=t/10+1;
		else
			T=t/10; 
		cout<<"SNo="<<sNo<<",ClassName="<<className<<",Score="<<T<<endl;
	}
};

//返回和设置学号sNo
void Student::setSNo(char*s )
{
	int i=0;
	   while(s[i]!='\0'){
	   	sNo[i]=s[i];
	   	i++;
	   }
	sNo[i]='\0';
}
char *Student::getSNo(){
	return sNo;
}

//返回和设置班级className
void Student::setClassName(char *s){
		int i=0;
	   while(s[i]!='\0'){
	   className[i]=s[i];
	   	i++;
	   }
	className[i]='\0';
}
char*  Student::getClassName(){
	return className;
}

//返回和设置成绩score
void  Student::setScore(double s=0.0){
	score=s;
}
double  Student::getScore(){
	return score;
}
//主函数
int main(){
    char s1[19]="130502190001010332";
    char s2[20]="doublebest";
    char s3[19]="20181234";
    char s4[20]="铁1801";
    double value=60.67;
    Student stu1(s1,s2,s3,s4,value);
    stu1.show();
    Student stu2=stu1;
    cin.getline(s3,10,'\n');
    cin.getline(s4,20,'\n');
    cin>>value;
    stu2.setSNo(s3);
    stu2.setClassName(s4);
    stu2.show();
    Teacher t1(s1,s2,s3,s4,value);
    t1.show();
    Teacher t2=t1;
    t2.setTNo(s3);
    t2.setDepartmentName(s3);
    t2.show();
    return 0;
}

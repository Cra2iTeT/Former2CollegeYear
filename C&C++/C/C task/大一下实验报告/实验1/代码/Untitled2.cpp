#include<iostream>
using namespace std;

class Student{
	char no[20];
	char name[20];
	int age;
	static int sum;
	public:
		Student(char *,char *,int);
		Student(Student &);
		~Student(){
			sum--;
			cout<<"Destructor run"<<endl;
			cout<<"Numtotal:"<<sum<<endl;
		}
		void setNo(char *);
		char * getNo();
		void setName(char *);
		char * getName();
		void show();
		void setAge(int);
		int getAge();
};

Student::Student(char *s1=NULL,char *s2=NULL,int N=0){
	sum++;
	int i;
	for(i=0;s1[i]!='\0';i++)
		no[i]=s1[i];
	no[i]='\0';
	for(i=0;s2[i]!='\0';i++)
		name[i]=s2[i];
	name[i]='\0';
	cout<<"Constructor run"<<endl;
}
Student::Student(Student &stu){
	int i;
	for(i=0;stu.no[i]!='\0';i++)
		no[i]=stu.no[i];
	for(i=0;stu.name[i]!='\0';i++)
		name[i]=stu.name[i];
	age=stu.age;
	sum++;
	cout<<"CopyConstructor run"<<endl;
}

void Student::setNo(char *sNo){		//分别返回和设置no
	int i;
	for(i=0;sNo[i]!='\0';i++)
		no[i]=sNo[i];
	no[i]='\0';
	//cout<<i<<endl;
}
char * Student::getNo(){
	return no;
}

void Student::setName(char *sNa){		//分别返回和设置name
	int i;
	for(i=0;sNa[i]!='\0';i++)
		name[i]=sNa[i];
	name[i]='\0';
	//cout<<i<<endl;
}
char * Student::getName(){
	return name;
}

void Student::setAge(int n){		//分别返回和设置age
	age=n;
}
int Student::getAge(){
	return age;
}

void Student::show(){
	cout<<"Numtotal:"<<sum<<endl;
	int i;
	if(sum!=0){
		cout<<"No:";
		for(i=0;no[i]!='\0';i++)
			cout<<no[i];
		cout<<",Name:";
		for(i=0;name[i]!='\0';i++)
			cout<<name[i];
		cout<<",Age:"<<age<<endl;
	}
}

int Student::sum=0;

int main(){
    char s1[10]="20190327";
    char s2[20]="doublebest";
    Student stu1(s1,s2);
    stu1.setAge(21);
    stu1.show();
    Student stu2=stu1;
    cin.getline(s1,10,'\n');
    cin.getline(s2,20,'\n');
    stu2.setNo(s1);
    stu2.setName(s2);
    stu2.show();
    return 0;
}

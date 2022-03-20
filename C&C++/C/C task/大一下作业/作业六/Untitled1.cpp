#include <iostream>
#include <string>
using namespace std;

class Animal{
	int m_nWeightBase;
	protected:
		int m_nAgeBase;
	public:
		void set_weight(int i);
		void set_age(int i);
		int get_weight();
};

void Animal::set_weight(int i){
	m_nWeightBase=i;
}
int Animal::get_weight(){
	return m_nWeightBase;
}

void Animal::set_age(int i){
	m_nAgeBase=i;
}
class Cat:private Animal{
	string m_strName;
	public:
		Cat(string n){
			m_strName=n;
		}
		void set_print_age(){
			Animal::set_age(5);
			cout<<m_strName<<", age = "<<m_nAgeBase<<endl;
		}
		void set_print_weight(){
			Animal::set_weight(6);
			cout<<m_strName<<", weight = "<<Animal::get_weight()<<endl;
		}
};
int main()
{
    Cat cat("Persian");     //定义派生类对象cat
    cat.set_print_age();
    cat.set_print_weight(); //派生类对象调用自己的公有函数
    return 0;
}

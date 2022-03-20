#include<iostream>
using namespace std;
class B{
	public:
		B(){
			cout<<b++;
		}
		~B(){
			cout<<b--;
		}
		static int Getb(){
			return b;
		}
	private:static int b;
};
int B::b=5;
int main(){
	B b1,b2,b3;
	cout<<B::Getb();
	return 0;
}

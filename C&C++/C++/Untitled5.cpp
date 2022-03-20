#include<iostream>
using namespace std;

struct node{
	int data;
	struct node *pre;
	struct node *next;
};

int main(){
	int len;
	cin>>len;
	
	struct node *head=new struct node;
	struct node *h=head;
	head->data=9999;
	head->pre=NULL;
	head->next=NULL;
	
	int i=0;
	for(;i<len;i++){
		struct node *p=new struct node;
		cin>>p->data;
		p->pre=h;
		h->next=p;
		p->next=NULL;
		h=h->next;
	}
	
	h=head->next;
	int d;
	cin>>d;
	
	int flag=1;
	for(i=0;i<len;i++){
		if(h->data==d&&h!=head->next){
			h->data=h->pre->data;
			h->pre->data=d;
			flag=0;
		}
		h=h->next;
	}
	if(flag){
		cout<<"Î´ÕÒµ½"<<d; 
	}else{
		h=head->next;
		for(i=0;i<len;i++){
			cout<<h->data;
			h=h->next;
		}
	}
}

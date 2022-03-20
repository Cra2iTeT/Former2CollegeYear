#include<iostream>
using namespace std;
typedef struct BiTNode{
	char data;
	struct BiTNode *lchild,*rchild;
}BiTNode,*BiTree;

void CreateBiTree(BiTree &T){
	char ch;
	cin>>ch;
	if(ch=='#')
		T=NULL;
	else{
		T=new BiTNode;
		T->data=ch;
		CreateBiTree(T->lchild);
		CreateBiTree(T->rchild);
	}
}

void InOrder(BiTree &T){
	if(T->lchild!=NULL){
		InOrder(T->lchild);
	}
	cout<<T->data<<" ";
	if(T->rchild!=NULL){
		InOrder(T->rchild);
	}
}

int main(){
	BiTNode *T=new BiTNode;
	CreateBiTree(T->lchild);
	InOrder(T->lchild);
}


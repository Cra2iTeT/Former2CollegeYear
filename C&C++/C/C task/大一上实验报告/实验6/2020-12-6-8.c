#include<stdio.h>
#include<stdlib.h>
struct node{//链表结点结构
    int data;
    struct node * next;
};
struct node * create(int n){//构建有n个元素的链表
    struct node *head=NULL,*p=NULL,*q=NULL;
    int i;
    head=(struct node *)malloc(sizeof(struct node));
    head->next=NULL;
    p=head;
    for(i=0;i<n;i++){
        q=(struct node *)malloc(sizeof(struct node));
        q->next=NULL;
        scanf("%d",&(q->data));
        p->next=q;
        p=q;
    }
    return head;
}

void rev(struct node *head){
	struct node *p0,*p1,*p2,*p3;
	p0=head;		/*记录链表的原起始*/ 
	p1=head->next;
	p0->next=NULL;
	p2=p3=NULL;
	while(p1){		/*空则结束*/ 
		p2=p1->next;
		p1->next=p3;
		p3=p1;
		p1=p2;
	}
	p0->next=p3;
}

void print(struct node *head){//链表输出
    while(head->next){
        head=head->next;
        printf("%5d",head->data);
    }
    printf("\n");
}
int main(){
    struct node *head=NULL;
    int n;
    scanf("%d",&n);
    head=create(n);
	print(head);
    rev(head);
    print(head);
    return 0;
}

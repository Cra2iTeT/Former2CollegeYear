#include<stdio.h>
#include<stdlib.h>
//注释的语句为测试使用 
struct node{//链表结点结构;
    int data;
    struct node *next;
};
struct node *joseph(int n,int k,int m){
	int i,j=0,l,count,amount=0;
	struct node *p,*h,*head,*q;
	head=(struct node *)malloc(sizeof(struct node));
	q=p=head;
	for(i=0;i<n;i++){
		if(i<n-1)
			h=(struct node *)malloc(sizeof(struct node));
		p->data=i+1;
		/*printf(",%d,",p->data);
		printf(";%d;\n",i);*/
		p->next=h;
		p=p->next;
		p->next=NULL;
	}
	p->next=head;
	p=head;
	/*for(i=0;i<10;i++){
		printf("%d;",p->data);
		p=p->next;
	}*/
	count=n;
	for(i=0;i<k-2;i++){
		q=p;
		p=p->next;
	}
	//printf(";%d;\n",p->data);
	for(;count>1;){
		q=p;
		p=p->next;
		amount++;
		if(amount==m){
			//printf(";%d;\n",p->data);
			q->next=p->next;
			p=q->next;
			amount=1;
			count--;
		}
	}
	return q;
}
int main(void){
    int n,m,k;
    struct node *head;
    scanf("%d%d%d",&n,&k,&m);
    head=joseph(n,k,m);
    printf("%d",head->data);
    free(head);
    return 0;
}

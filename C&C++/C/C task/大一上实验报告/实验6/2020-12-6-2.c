#include<stdio.h>
#include<stdlib.h>
//注释的语句为测试使用
struct Node{
    char num[9];
    char name[21];
    struct Node *next;
};
struct Node * create(void){
    struct Node *head,*p,*tail;
    head=(struct Node *)malloc(sizeof(struct Node));
    int i=1;
    while(1){
    	//printf("%d\n",p);
    	p=(struct Node *)malloc(sizeof(struct Node));
    	if(i==1) head->next=tail=p;
    	//printf("%d,\n",p);
    	gets(p->num);
    	//printf("%s,\n",p->num);
    	//if(p->num[0]!='0'){
    	if(*(p->num)!='0'){
    		gets(p->name);
    		//printf("%s,\n",p->name);
			p->next=NULL;
			tail->next=p;
    		tail=p;
    		i--;
		}
		//printf("%d,\n",p);
		//if(p->next==NULL) printf("oVo\n");
		if(*(p->num)=='0'){
			p=NULL;
			//printf("%d,\n",p);
			return head;
		}
	}
}
void delNode(struct Node *a,struct Node *b){
	struct Node *A,*B,*h;
	int i;
	h=a,B=b,A=h->next;
	/*printf("%d,\n",h);
	printf("%d,\n",a);
	printf("%d,\n",A);
	printf("%d,\n",b);
	printf("%d,\n",B);*/
	while(B->next!=NULL){
		h=a;
		A=h->next;
		while(A!=NULL){
			/*printf("%s,\n",A->num);
			printf("%s,\n",B->num);*/
			i=strcmp(A->num,B->num);
			/*if(a->num==B->num){
				h=a=a->next;
				A=h->next;
			}*/
			if(i==0){
				h->next=A->next;
				A=h->next;
			}
			else{
				h=A;
				A=h->next;
			}
			/*printf("%d,\n",h);
			printf("%d,\n",A);*/
		}
		B=B->next;
	}
}
void print(struct Node *head){
    struct Node *p=head->next;
    while(p)    {
        printf("%s-%s\n",p->num,p->name);
        p=p->next;
    }
}
int main(void){
    struct Node *a,*b;
    a=create();
    b=create();
    delNode(a,b);
    print(a);
    return 0;
}


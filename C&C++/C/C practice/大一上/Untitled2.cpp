#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct Node
{
    char num[8];
    char name[20];
    struct Node *next;
};
struct Node * create(void)
{
	struct Node *head=NULL,*p=NULL,*q=NULL;
	int k=1;
	head=(struct Node*)malloc(sizeof(struct Node));
	q=(struct Node*)malloc(sizeof(struct Node));
	do
	{
		p=(struct Node*)malloc(sizeof(struct Node));
        scanf("%s",p->num);
        if(p->num[0]=='0')  break;
        scanf("%s",p->name);
        p->next=q->next;
        q->next=p;
        if(k)
        {
        	head=q;
		}
        p=p->next;
        q=q->next;
        k=0;
	}while(1);
	    q->next=NULL;
	return head;
}
	
void delNode(struct Node *a,struct Node *b)
{
	struct Node *p,*q,*h,*pH,*ph;
	p=ph=a;
	pH=ph->next;
	while(p->next)
	{
		h=b->next;
		while((h->next)!=NULL)
		{
		    if(strcmp(pH->num,h->num)==0)
	        {
	  	    	ph->next=pH->next;
				pH=ph->next;
				//printf(";ph=%s;\n",pH->num);
	        }
	        /*printf(";h=%s;\n",h->num);
	        printf(";p=%s;\n",pH->num);*/
            h=h->next;
		}
		p=p->next;
		//printf(";p=%s;\n",p->num);
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

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
	struct Node *p,*q,*h;
	int k;
	p=a;
	
	while(p->next)
	
	{          h=b;
               	k=0;
		/*	b=b->next;
			printf("b%s\n",b->num);
		  if(b==NULL)   
		  {
		     //	p=p->next;
                b=h->next;
			}*/
		            while((h->next)!=NULL)
		         {
		         		  if(strcmp(p->next->num,h->next->num)==0)
	                    {
		                  p->next=p->next->next;
		                  k=1;
	                    }
	                
	                
                    
		         	//q=p->next;
		            //p->next=q->next;
		            //free(q);
		           // printf("a%s\n",p->next->num );
                     h=h->next;
				 }
				  if(k==0)  {
                    	p=p->next;
					}
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

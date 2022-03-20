#include<stdio.h>
#include<stdlib.h>

struct node{
	int data;
	char *next;
};

int max(struct node *head){
	struct node *j,*k;
	int i;
	j=head;
	k=head->next;
	for(i=0;i<5;i++){
		j=j->next;
		if(j->data>k->data) k=j;
	}
	return k->data;
}

int main( ){
    int i;
    struct node *p,*head;
    head=(struct node *)malloc(sizeof(struct node));
    head->next=NULL;
    for(i=0; i<5; i++){
        p=(struct node *)malloc(sizeof(struct node));
        scanf("%d",&(p->data));
        //printf("%d",p->data);
        p->next=head->next;
        head->next=p;
    }
    printf("Max=%d",max(head));
    return 0 ;
}

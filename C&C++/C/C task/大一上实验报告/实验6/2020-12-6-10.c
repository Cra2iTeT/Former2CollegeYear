#include<stdio.h>
#include<string.h>
#include<stdlib.h>
//ע�͵����Ϊ����ʹ��
struct node{//������ṹ
    char sno[5];//ѧ��
    int result;//�ɼ�
    struct node * next;
};
struct node *create(int n){//������n��Ԫ�ص�����������С����
    struct node *head,*p,*q;
    int i,j;
    char ch;
    head=(struct node *)malloc(sizeof(struct node));
    head->next=NULL;
    p=head;
    for(i=0;i<n;i++){
        q=(struct node *)malloc(sizeof(struct node));
        for(j=0;((q->sno)[j]=getchar())!='\n';j++);
        (q->sno)[j]='\0';
        scanf("%d",&j);
        q->result=j;
        while((ch = getchar()) != '\n' && ch != EOF);//������뻺����
        p=head;
        while(p->next!=NULL&&p->next->result<=q->result) p=p->next;
        q->next=p->next;
        p->next=q;
    }
    return head;
}
struct node *merge(struct node *head1,struct node *head2){		//��Ŀ���������д� 
	struct node *p,*hP;
	int i,score;
	char s[5];
	p=hP=head1->next;
	for(;p->next!=NULL;) p=p->next;
	p->next=head2->next;
	p=hP;
	/*for(;p!=NULL;p=p->next) printf(";%d;\n",p->result);
	p=hP;*/
	struct node *p1;
	for(;p!=NULL;p=p->next){
		for(p1=p->next;p1!=NULL;p1=p1->next){
			if(p->result>p1->result)
				for(i=0;i<5&&p->sno[i]!='\0';i++){		//copy data
					s[i]=p->sno[i];
					score=p->result;
					p->result=p1->result;
					p->sno[i]=p1->sno[i];
					p1->sno[i]=s[i];
					p1->result=score;
					/*printf(";%d;%d;\n",p->result,p1->result);
					printf(";%s;%s;\n",p->sno,p1->sno);*/
				}
		}
	}
	p=(struct node *)malloc(sizeof(struct node));		//print���������Ҫһ���յ�ͷָ�� 
	p->next=hP;
	return p;
}
void print(struct node *head){//�������
    while(head->next){
        head=head->next;
        printf("%5s:%d",head->sno,head->result);
     }
    printf("\n");
}
int main(){
    struct node *head1=NULL,*head2=NULL;
    head1=create(3);
    print(head1);
    head2=create(3);
    print(head2);
    head1=merge(head1,head2);
    print(head1);
    return 0;
}

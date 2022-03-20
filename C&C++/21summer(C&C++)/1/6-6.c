#include <stdio.h>
#include <stdlib.h>

typedef struct Node *PtrToNode;
struct Node {
    int Data; /* �洢������� */
    PtrToNode Next; /* ָ����һ������ָ�� */
};
typedef PtrToNode List; /* ���嵥�������� */

int FactorialSum( List L );

int main()
{
    int N, i;
    List L, p;

    scanf("%d", &N);
    L = NULL;
    for ( i=0; i<N; i++ ) {
        p = (List)malloc(sizeof(struct Node));
        scanf("%d", &p->Data);
        p->Next = L;
		L = p;
    }
    printf("%d\n", FactorialSum(L));

    return 0;
}

/* ��Ĵ��뽫��Ƕ������ */
int FactorialSum( List L ){
	int iI,ij;
	int iSum=0,iIndex;
	while(L!=NULL){
		iIndex=1;
		iI=ij=L->Data;
		for(;iI>0;iI--){
			iIndex*=iI; //��¼�׳�
		}
		iSum+=iIndex;
		L=L->Next;
	}
	return iSum;
}
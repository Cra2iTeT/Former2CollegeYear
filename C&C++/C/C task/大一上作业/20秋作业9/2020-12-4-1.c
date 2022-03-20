#include<stdio.h>
void  sort( int *a, int *b, int *c );
int  main(){
    int  a, b, c ;
    scanf( "%d%d%d", &a, &b, &c) ;
    sort( &a, &b, &c ) ;
    printf( "The result is%5d%5d%5d\n", a, b, c ) ;
    return  0 ;
}
void  sort( int *a, int *b, int *c )
{
	int i;
	if(*a>*b){
		i=*a;
		*a=*b;
		*b=i;
	}
	if(*a<=*b);
	if(*b<=*c);
	if(*b>*c){
		i=*b;
		*b=*c;
		*c=i;
		if(*a<=*b);
		if(*a>*b){
			i=*a;
			*a=*b;
			*b=i;
		}
	}
}

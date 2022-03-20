#include<stdio.h>
#include<math.h>
int  main( ){
    void  f( int m ) ;
    int  m ;
    scanf( "%d", &m ) ;
    f( m ) ;
    return  0 ;
}
void f(int m)
{
	int i,j=0;
	for(i=1;i<sqrt(m);i++){
		if(m%i==0) j=1;
		else j=0;
	}
	if(j) printf("%d is not a Prime Number.\n",m);
	else printf("%d is a Prime Number.\n",m);
}

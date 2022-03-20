#include<stdio.h>
int gys(int x,int y)
{
    int min,t,T;
	if(x%y==0) min=y;
	else{
    	min=x%y;
    	t=y%min;
    	while(t!=0){
        	min=t,T=min;
        	t=T%min;
    	}
    }
	return min;
}

int gbs(int x,int y)
{
    int max,min;
    min=gys(x,y);
    max=x*y/min;
	return max;
}

int  main( ){
    int  m, n, t ;
    scanf( "%d%d", &m, &n ) ;
    if( m < n ){
        t = m ;
        m = n ;
        n = t ;
    }
    t = gys( m, n ) ;
    printf( "gys=%d\n", t ) ;
    t = gbs( m, n ) ;
    printf( "gbs=%d\n", t ) ;
    return 0 ;
}

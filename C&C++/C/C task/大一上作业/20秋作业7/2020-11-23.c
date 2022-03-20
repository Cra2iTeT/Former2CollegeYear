#include<stdio.h>
#define PI 3.14 
int  main( ){ 
    
float area(float r);
;
    float  x = 2.4 , y ;
    y = area( x ) ;    
    printf( "%6.2f\n" , y ) ;
    return  0 ;
}
float  area ( float  r ){
    float  s ;
    s= PI * r * r ;
    
return s;
;
}

#include<stdio.h>
int  strcompare( char *str1,char *str2);
int  main( ){
    char  a[80],b[80];
    gets(a);
    gets(b);
    printf( "%d\n", strcompare(a,b)) ;
    return 0 ;
}
int  strcompare( char *str1,char *str2)
{
	int i=0;
	for(i=0;str1[i] == str2[i] && str1[i] != '\0';i++);
	return (str1[i]-str2[i]);
}

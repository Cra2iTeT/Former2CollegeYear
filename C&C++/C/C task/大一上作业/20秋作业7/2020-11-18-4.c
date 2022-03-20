#include<stdio.h>
int strcom(char str1[],char str2[])
{
	int i,result;
	for(i=0;i<80&&(str1[i]!=0||str2[i]!=0);i++){
		result=str1[i]-str2[i];
		if(result==0);
		if(result>0){
			result=1;
			break;
		} 
		else if(result<0){
			result=-1;
			break;
		}
	}
	return result;
}
int  main( ){
    char  str1[80],str2[80];
    int  result;
    gets(str1);
    gets(str2);
    result=strcom(str1,str2);
    if(result==1)
        printf( "\"%s\" > \"%s\"\n", str1,str2) ;
    else if(result==-1)
        printf( "\"%s\" < \"%s\"\n", str1,str2) ;
    else
        printf( "\"%s\" = \"%s\"\n", str1,str2) ;
    return  0 ;
}

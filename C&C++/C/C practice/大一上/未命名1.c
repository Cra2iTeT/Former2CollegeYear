#include<stdio.h>
int main(){
  int num[26]={0},i;
  char c;
  while((c=getchar())!='#')
    if(c>='A'&&c<='Z')
      
num[c-'A']+=1; 
  for(i=0;i<26;i++)
    if(num[i])
      printf("%c:%d\n",i+'A',num[i]);
  return 0;
}

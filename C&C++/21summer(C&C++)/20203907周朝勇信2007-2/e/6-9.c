#include <stdio.h>

int Count_Digit ( const int N, const int D );

int main()
{
    int N, D;

    scanf("%d %d", &N, &D);
    printf("%d\n", Count_Digit(N, D));
    return 0;
}

/* ��Ĵ��뽫��Ƕ������ */
int Count_Digit ( const int N, const int D ){
  int iN;
  if(N<0)	//ȡ����ֵ 
  	iN=-N;
  else 
  	iN=N;
  
  if(N==0&&D==0)
  return 1;
  
  int count=0;
  while(iN){
    if(iN%10==D)
      count++;
    iN/=10;
  }
  return count;
}

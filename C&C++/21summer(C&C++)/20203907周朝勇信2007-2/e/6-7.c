#include <stdio.h>
#include <math.h>

int IsTheNumber ( const int N );

int main()
{
    int n1, n2, i, cnt;

    scanf("%d %d", &n1, &n2);
    cnt = 0;
    for ( i=n1; i<=n2; i++ ) {
        if ( IsTheNumber(i) )
            cnt++;
    }
    printf("cnt = %d\n", cnt);

    return 0;
}

/* 你的代码将被嵌在这里 */
int IsTheNumber ( const int N ){
  int iN=N;
  int iB;
  int iP[10]={0};
  int iM=sqrt(n);
  if(iM*iM==iN){
    while(iN){
      iB=iN%10;
      iP[iB]++;
      iN/=10;
    }
    for(int i=0;i<=9;i++){
      if(iP[i]>1)
      return 1;
    }
  }
  return 0;
}

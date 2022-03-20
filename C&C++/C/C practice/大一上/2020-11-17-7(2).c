#include<stdio.h>
int main ()
{
    int c[5][5];
    int i,j,a,b;
    for(i=0;i<5;i++)
        for(j=0;j<5;j++)
        scanf("%d",&c[i][j]);
     for(i=0;i<5;i++)
        for(j=0;j<5;j++)
        {
            for(b=0;b<5;b++)
            {
                if(c[i][j]<c[i][b])
                    break;
                for(a=0;a<5;a++)
                   {
                    if(c[i][j]>c[a][j])
                    break;
                   }
            }
            if(a==5&&b==5)
            printf("[%d,%d,%d]",i,j,c[i][j]);
        }

    return 0;
}

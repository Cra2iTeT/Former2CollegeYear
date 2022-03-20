#include<stdio.h>
int main(){
    int head,foot,a[2]={0};
    FILE* fp = NULL;
    printf("请输入头和脚的数量：");
    scanf("%d%d",&head,&foot);
    while(a[0]<=head){
        
a[0]++,a[1]=head-a[0]
;
        if(a[0]*2+a[1]*4==foot){
            fp = fopen("d:\record.dat","w");
            if(fp!=NULL){
                fwrite(a,sizeof(int),2,fp);
                fclose(fp);
                break;
            }
        }
        a[0]++;
        }
    return 0;
}

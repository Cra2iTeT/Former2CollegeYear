
#include<stdio.h>
int main()
{
    FILE * fp_text,* fp_binary;
    char write_buf[4]={'1','2','/n','3'};
    char read_buf_text[6],read_buf_binary[6];
    int read_count_text,read_count_binary;
    //未检测打开是否失败
    fp_text=fopen("test1","wt+");
    fp_binary=fopen("test2","wb+");
    fwrite(write_buf,4,1,fp_text);
    fwrite(write_buf,4,1,fp_binary);
    //fflush(fp_text);
    //fflush(fp_binary);
 
    fseek(fp_text,0L,SEEK_SET);//fseek附带了fflush功能
    fseek(fp_binary,0L,SEEK_SET);
    read_count_text=fread(read_buf_text,sizeof(char),5,fp_text);
    read_count_binary=fread(read_buf_binary,sizeof(char),5,fp_binary);
    //加''/0''，便于打印字符串
    read_buf_text[read_count_text]='/0';
    read_buf_binary[read_count_binary]='/0';
    printf("In Text Mode:read_count=%d,string=%s/n",read_count_text,read_buf_text);
    printf("In Binary Mode:read_count=%d,string=%s/n",read_count_binary,read_buf_binary);
    fclose(fp_text);
    fclose(fp_binary);     
    return 0;　
}

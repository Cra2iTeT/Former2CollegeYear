#include<stdio.h>
struct People{
  int id;
  char name[10];
};
int main(){
  struct People a = {'0', "name"};
  struct People b = a;
  a.id = 20;
  printf("%d,%s", b.id, b.name);
  return 0;
}

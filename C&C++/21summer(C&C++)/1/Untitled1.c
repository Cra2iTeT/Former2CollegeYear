#include <windows.h> 
#include <iostream>
  
int main() 
{ 
  DWORD start, stop; 
  unsigned int t = 0; 
  start = GetTickCount(); 
  while (t++ < 10e+6); 
  stop = GetTickCount(); 
  printf("time: %lld ms\n", stop - start); 
  return 0; 
}

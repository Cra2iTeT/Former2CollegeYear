#include <iostream>
using namespace std;
#define N 100

class BigNum{
private:
    char num[N];
public:
    BigNum(char c[]="+0")
	{
    int i=0;
    int k=0;
    if(c[0]!='-'&&c[0]!='+')
        {
        	num[0]='+';
        	i++;
		}
    while(c[k]!='\0'){
        num[i]=c[k];
        i++;
        k++;
    }
    num[i]='\0';
        cout<<"BigNum Constructor run"<<endl;
    }
    BigNum(BigNum&);
    ~BigNum(){
    cout<<"BigNum Destructor run"<<endl;
    }
    void  setNum(char c[]);
    char const *getNum(void) const;
    BigNum  operator+(BigNum&);
    BigNum  operator-(BigNum&);
    void show() const;
};
void BigNum::show()const{
    cout<<"BigNum"<<"(";
	cout<<num<<")"<<endl;
}
BigNum::BigNum(BigNum&t){
    int i=0;
    while(t.num[i]!='\0'){
        num[i]=t.num[i];
        i++;
    }
    num[i]='\0';
    cout<<"BigNum CopyConstructor run"<<endl;
}
void BigNum::setNum(char c[]){
    int i=0;
    int k=0;
    if(c[0]!='-'&&c[0]!='+')
        {
        	num[0]='+';
        	i++;
		}
    while(c[k]!='\0'){
        num[i]=c[k];
        i++;
        k++;
    }
    num[i]='\0';
}
char const *BigNum::getNum()const{
    return num;
}
BigNum  BigNum::operator+(BigNum&t){
    BigNum q=t;
	BigNum s;
    BigNum z=s;
    if(num[1]=='0'&&t.num[1]=='0')
     {
     	z.num[0]='0';
     	z.num[1]='\0';
     	return z;
	 }
	int c=1;
    while(c<99)
       {
       	z.num[c]='0';
       	c++;
	   }
       z.num[c]='\0';
    int i1=0,i2=0;
    while(num[i1]!='\0')  i1++;
    while(t.num[i2]!='\0')  i2++;
    int i11=i1,i22=i2;
     if(i11>i22) {
    	t.num[i1]='\0';
		int k=i1-i2;
		while(k!=0){
			int t1=i1-1;
			while(t1!=1){
				t.num[t1]=t.num[t1-1];
				t1--;
			}
			k--;
		}
		int i=1;
		while(i<=i11-i22)
		 {
		 	t.num[i]='0';
		 	i++;
		 }
	}
	else if(i11<i22){
    	t.num[i2]='\0';
		int k=i2-i1;
		while(k!=0){
			int t1=i2-1;
			while(t1!=1){
				num[t1]=num[t1-1];
				t1--;
			}
			k--;
		}
		int i=1;
		while(i<=i22-i11)
		 {
		 	
			 num[i]='0';
		 	i++;
		 }
	}
	//分情况。
       if(num[0]=='+')
       {
         	if(t.num[0]=='+')
			 {
       		    int i=1;
                int j=1;
                while(num[i]!='\0'&&t.num[i]!='\0'){
                      s.num[j]=num[i]+t.num[i]-48;
                         j++;
                         i++;
                        }
                    s.num[j]='\0';
                    j--;
                    int T;
                    T=j+1;
                    z.num[T+1]='\0';
                    int jinwei;
                    while(j!=0){
    	                    jinwei=0;
                           	z.num[T]=((int)s.num[j]-48)%10+z.num[T];
                        	jinwei=((int)z.num[T]-48)/10;
                        	z.num[T]=(((int)z.num[T])-48)%10+48;
               	            z.num[T-1]=((int)z.num[T-1]-48)+((int)s.num[j]-48)/10+48+jinwei;
    	                    T--;
                          	j--;
	                }
                    if((int)z.num[2]-48==10){
	                 	z.num[1]='1';
	                 	z.num[2]='0';
                    }
	                if(z.num[1]=='0'){
	               	int k=1;
                	while(z.num[k]!='\0')
    	            {
    	             	z.num[k]=z.num[k+1];
    	               	k++;
		        	}
	              }        
                      return z;
		}
	     	if(t.num[0]=='-'){
			bool flag=true;
			int K=1;
			while(1){
    	          if(num[K]>t.num[K])
    	        {
    	   	      flag=true;
    	   	      break;
		        }
               	else if(num[K]<t.num[K])
    	       {
    	    	flag=false;
    	     	break;
		       }
		        else  K++;
		
    	      if(num[K]=='\0') break;
	          }
	     	 if(!flag) {
		       s.num[0]='-';
		       z.num[0]='-';
	          } 
             int i;
             i=i11>i22?i11:i22;
             i=i-1;
             int j=i;
             int temp=j;
              if(!flag)
             {
	         	int temp[101];
		        int K=1;
	        	while(num[K]!='\0')
	     	{
		    	temp[K]=t.num[K];
			    t.num[K]=num[K];
		    	num[K]=temp[K];
		    	K++;
		    }
	      }
              while(j!=0){
                 s.num[j]=num[i]-t.num[i]+48;
                 j--;
                i--;
            }
           j=temp+1;
           s.num[j]='\0';
           j--;
           int T;
           T=j+1;
           z.num[T+1]='\0';
           while(j!=0){
		   if(s.num[j]<'0')
		  {
		    z.num[T]=(int)s.num[j]+10+z.num[T]-48;
		    s.num[j-1]=s.num[j-1]-1;
		  }
		   else{
			z.num[T]=(int)s.num[j];
		  }
		  T--;
		  j--;
	     }
	while(z.num[1]=='0'){
		int k=1;
    	while(z.num[k]!='\0')
    	    {
    	    	z.num[k]=z.num[k+1];
    	    	k++;
			}
	}
    return z;
		}
	   }
	   if(num[0]=='-')
       {
       	    if(t.num[0]=='+'){
       		bool flag=true;
			int K=1;
			while(1){
    	          if(t.num[K]>num[K])
    	        {
    	   	      flag=true;
    	   	      break;
		        }
               	else if(t.num[K]<num[K])
    	       {
    	    	flag=false;
    	     	break;
		       }
		        else  K++;
		
    	      if(num[K]=='\0') break;
	          }
	     	 if(!flag) {
		       s.num[0]='-';
		       z.num[0]='-';
	          } 
             int i;
             i=i11>i22?i11:i22;
             i=i-1;
             int j=i;
             int temp=j;
              if(!flag)
             {
	         	int temp[101];
		        int K=1;
	        	while(t.num[K]!='\0')
	     	{
		    	temp[K]=num[K];
			    num[K]=t.num[K];
		    	t.num[K]=temp[K];
		    	K++;
		    }
	      }
              while(j!=0){
                 s.num[j]=t.num[i]-num[i]+48;
                 j--;
                i--;
            }
           j=temp+1;
           s.num[j]='\0';
           cout<<s.num<<endl;
           j--;
           int T;
           T=j+1;
           z.num[T+1]='\0';
           while(j!=0){
		   if(s.num[j]<'0')
		  {
		    z.num[T]=(int)s.num[j]+10+z.num[T]-48;
		    s.num[j-1]=s.num[j-1]-1;
		  }
		   else{
			z.num[T]=(int)s.num[j];
		  }
		  T--;
		  j--;
	     }
	while(z.num[1]=='0'){
		int k=1;
    	while(z.num[k]!='\0')
    	    {
    	    	z.num[k]=z.num[k+1];
    	    	k++;
			}
	}
    return z;
		}
		   }
		    if(t.num[0]=='-'){
			    int i=1;
                int j=1;
                z.num[0]='-';
                while(num[i]!='\0'&&t.num[i]!='\0'){
                      s.num[j]=num[i]+t.num[i]-48;
                         j++;
                         i++;
                        }
                    s.num[j]='\0';
                    j--;
                    int T;
                    T=j+1;
                    z.num[T+1]='\0';
                    int jinwei;
                    while(j!=0){
    	                    jinwei=0;
                           	z.num[T]=((int)s.num[j]-48)%10+z.num[T];
                        	jinwei=((int)z.num[T]-48)/10;
                        	z.num[T]=(((int)z.num[T])-48)%10+48;
               	            z.num[T-1]=((int)z.num[T-1]-48)+((int)s.num[j]-48)/10+48+jinwei;
    	                    T--;
                          	j--;
	                }
                    if((int)z.num[2]-48==10){
	                 	z.num[1]='1';
	                 	z.num[2]='0';
                    }
	                if(z.num[1]=='0'){
	               	int k=1;
                	while(z.num[k]!='\0')
    	            {
    	             	z.num[k]=z.num[k+1];
    	               	k++;
		        	}
	              }        
                      return z;
		}
	   }

BigNum  BigNum::operator-(BigNum &t)
{
	
    BigNum s;
	BigNum z=s;
	bool flaga=false;
    int l=0;
    while(num[l]==t.num[l]){
    		l++;
    	if(num[l]=='\0'&&t.num[l]=='\0'){
    		flaga=true;
		}
	}
	if(flaga){
		z.num[0]='0';
		z.num[1]='\0';
		return z;
	}
    int c=1;
    while(c<99)
       {
       	z.num[c]='0';
       	c++;
	   }
       z.num[c]='\0';
           int i1=0,i2=0;
    while(num[i1]!='\0')  i1++;
    while(t.num[i2]!='\0')  i2++;
    int i11=i1,i22=i2;
     if(i11>i22) {
    	t.num[i1]='\0';
		int k=i1-i2;
		while(k!=0){
			int t1=i1-1;
			while(t1!=1){
				t.num[t1]=t.num[t1-1];
				t1--;
			}
			k--;
		}
		int i=1;
		while(i<=i11-i22)
		 {
		 	t.num[i]='0';
		 	i++;
		 }
	}
	else if(i11<i22){
    	t.num[i2]='\0';
		int k=i2-i1;
		while(k!=0){
			int t1=i2-1;
			while(t1!=1){
				num[t1]=num[t1-1];
				t1--;
			}
			k--;
		}
		int i=1;
		while(i<=i22-i11)
		 {
		 	
			 num[i]='0';
		 	i++;
		 }
	}
              if(num[0]=='+')
       {
         	if(t.num[0]=='+'){
       		bool flag=true;
			int K=1;
			while(1){
    	          if(num[K]>t.num[K])
    	        {
    	   	      flag=true;
    	   	      break;
		        }
               	else if(num[K]<t.num[K])
    	       {
    	    	flag=false;
    	     	break;
		       }
		        else  K++;
		
    	      if(num[K]=='\0') break;
	          }
	     	 if(!flag) {
		       s.num[0]='-';
		       z.num[0]='-';
	          } 
             int i;
             i=i11>i22?i11:i22;
             i=i-1;
             int j=i;
             int temp=j;
              if(!flag)
             {
	         	int temp[101];
		        int K=1;
	        	while(num[K]!='\0')
	     	{
		    	temp[K]=t.num[K];
			    t.num[K]=num[K];
		    	num[K]=temp[K];
		    	K++;
		    }
	      }
              while(j!=0){
                 s.num[j]=num[i]-t.num[i]+48;
                 j--;
                i--;
            }
           j=temp+1;
           s.num[j]='\0';
           //cout<<s.num<<endl;
           j--;
           int T;
           T=j+1;
           z.num[T+1]='\0';
           while(j!=0){
		   if(s.num[j]<'0')
		  {
		    z.num[T]=(int)s.num[j]+10+z.num[T]-48;
		    s.num[j-1]=s.num[j-1]-1;
		  }
		   else{
			z.num[T]=(int)s.num[j];
		  }
		  T--;
		  j--;
	     }
	while(z.num[1]=='0'){
		int k=1;
    	while(z.num[k]!='\0')
    	    {
    	    	z.num[k]=z.num[k+1];
    	    	k++;
			}
	}
    return z;
		   }
	     	if(t.num[0]=='-'){
			int i=1;
                int j=1;
                while(num[i]!='\0'&&t.num[i]!='\0'){
                      s.num[j]=num[i]+t.num[i]-48;
                         j++;
                         i++;
                        }
                    s.num[j]='\0';
                    j--;
                    int T;
                    T=j+1;
                    z.num[T+1]='\0';
                    int jinwei;
                    while(j!=0){
    	                    jinwei=0;
                           	z.num[T]=((int)s.num[j]-48)%10+z.num[T];
                        	jinwei=((int)z.num[T]-48)/10;
                        	z.num[T]=(((int)z.num[T])-48)%10+48;
               	            z.num[T-1]=((int)z.num[T-1]-48)+((int)s.num[j]-48)/10+48+jinwei;
    	                    T--;
                          	j--;
	                }
                    if((int)z.num[2]-48==10){
	                 	z.num[1]='1';
	                 	z.num[2]='0';
                    }
	                if(z.num[1]=='0'){
	               	int k=1;
                	while(z.num[k]!='\0')
    	            {
    	             	z.num[k]=z.num[k+1];
    	               	k++;
		        	}
	              }        
                      return z;
                      
		}
	   }
	   if(num[0]=='-')
       {
       	    if(t.num[0]=='+'){
       		int i=1;
                int j=1;
                z.num[0]='-';
                while(num[i]!='\0'&&t.num[i]!='\0'){
                      s.num[j]=num[i]+t.num[i]-48;
                         j++;
                         i++;
                        }
                    s.num[j]='\0';
                    j--;
                    int T;
                    T=j+1;
                    z.num[T+1]='\0';
                    int jinwei;
                    while(j!=0){
    	                    jinwei=0;
                           	z.num[T]=((int)s.num[j]-48)%10+z.num[T];
                        	jinwei=((int)z.num[T]-48)/10;
                        	z.num[T]=(((int)z.num[T])-48)%10+48;
               	            z.num[T-1]=((int)z.num[T-1]-48)+((int)s.num[j]-48)/10+48+jinwei;
    	                    T--;
                          	j--;
	                }
                    if((int)z.num[2]-48==10){
	                 	z.num[1]='1';
	                 	z.num[2]='0';
                    }
	                if(z.num[1]=='0'){
	               	int k=1;
                	while(z.num[k]!='\0')
    	            {
    	             	z.num[k]=z.num[k+1];
    	               	k++;
		        	}
	              }        
                      return z;
		   }
		    if(t.num[0]=='-'){
			bool flag=true;
			int K=1;
			while(1){
    	          if(t.num[K]>num[K])
    	        {
    	   	      flag=true;
    	   	      break;
		        }
               	else if(t.num[K]<num[K])
    	       {
    	    	flag=false;
    	     	break;
		       }
		        else  K++;
		
    	      if(num[K]=='\0') break;
	          }
	     	 if(!flag) {
		       s.num[0]='-';
		       z.num[0]='-';
	          } 
             int i;
             i=i11>i22?i11:i22;
             i=i-1;
             int j=i;
             int temp=j;
              if(!flag)
             {
	         	int temp[101];
		        int K=1;
	        	while(t.num[K]!='\0')
	     	{
		    	temp[K]=num[K];
			    num[K]=t.num[K];
		    	t.num[K]=temp[K];
		    	K++;
		    }
	      }
              while(j!=0){
                 s.num[j]=t.num[i]-num[i]+48;
                 j--;
                i--;
            }
           j=temp+1;
           s.num[j]='\0';
           cout<<s.num<<endl;
           j--;
           int T;
           T=j+1;
           z.num[T+1]='\0';
           while(j!=0){
		   if(s.num[j]<'0')
		  {
		    z.num[T]=(int)s.num[j]+10+z.num[T]-48;
		    s.num[j-1]=s.num[j-1]-1;
		  }
		   else{
			z.num[T]=(int)s.num[j];
		  }
		  T--;
		  j--;
	     }
	while(z.num[1]=='0'){
		int k=1;
    	while(z.num[k]!='\0')
    	    {
    	    	z.num[k]=z.num[k+1];
    	    	k++;
			}
	}
    return z;
		}
	   }
}
//主函数
int main(void){
    char c[100],op;
    cin>>c;
    BigNum b1(c),b2(b1);
    b1.show();
    cin>>c;
    b2.setNum(c);
    b2.show();
    cin>>op;
    if(op=='+') (b1+b2).show();
    if(op=='-') (b1-b2).show();
    return 0;
}

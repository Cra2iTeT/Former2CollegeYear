#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;

const int N=1010;
int n,m; 
int f[N];
int main(){
	cin>>n>>m;// 4 5
	for(int i=0;i<n;i++){  //从0开始枚举
		int v,w,c;
		cin>>v>>w>>c;
		int t;
		for(int j=v,x=v,t=1;j*t<=m&&t<=c;t++,x++) //小到大枚举体积，＜v的不枚举
		  f[x]=max(f[x],f[x-v]+w);
	}
	/*初始化的时候把所有的 f[i]都初始化为0 
	/f[m] 表示体积 小于等于m的情况下 ，所有方法里面 
	/转移的时候不一定是从f[0]转移过来的，可以从任意一个状态转移 
	/当用不完整个背包的容量的时候 ，假设剩k容量就可以从k转移 
	/则一定可以枚举到 最优解一样的选法 ，因为体积变成了一样的 
	/假设最优解用了m-k的体积，f[m]就一定可以从k开始枚举 ，也只用了 m-k的体积
	 也会枚举到最优解 ，所以f[m]表示的就是体积小于等于 m的情况下的最优解 */ 
	cout<<f[m]<<endl;  //最大价值（不需要枚举从0到m） 
	return 0;
}

/*
* 文件名：main.cpp
* 作者：20203907; 周朝勇
* 完成日期：2021/08/24
* 文件内容：空间点线面的创立
* 当前版本：1.0
*/
#include<iostream>
#include<cmath>
#include<cstdlib>
using namespace std;


/*
* 类的作用：Cpoint创建了点类
* 类的使用：Cpoint cp;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/24
*/
class CPoint{
	private:
		 float m_fX, m_fY, m_fZ;	//坐标
	public:
		CPoint(float x=0.0,float y=0.0,float z=0.0){
			this->m_fX=x;
			this->m_fY=y;
			this->m_fZ=z;
		}
		~CPoint(){
		}
		void setX(float x);
		float getX();
		void setY(float y);
		float getY();
		void setZ(float z);
		float getZ();
};

/*
*方法作用：设置和返回坐标
*参数：set函数参数是各坐标，get函数无参
*返回值：set函数无返回值，get函数返回各坐标（float） 
*/
void CPoint::setX(float x){
	this->m_fX=x;
}

float CPoint::getX(){
	return this->m_fX;
}

void CPoint::setY(float y){
	this->m_fY=y;
}

float CPoint::getY(){
	return this->m_fY;
}

void CPoint::setZ(float z){
	this->m_fZ=z;
}

float CPoint::getZ(){
	return this->m_fZ;
}

/*
* 类的作用：CLine创建了线类
* 类的使用：CLine cl;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/24
*/
class CLine{
	private:
		float m_fX1,m_fX2,m_fY1,m_fY2,m_fZ1,m_fZ2;
		float m_fM,m_fN,m_fP;	//点斜式方向向量分量
	public:
		int iFlag;	//记录是怎么创建的直线
		
		CLine(){
			iFlag=0;
		}
		~CLine(){
		}
		
		void pp(float x1=0.0,float x2=0.0,float y1=0.0,float y2=0.0,float z1=0.0,float z2=0.0){	//两点创建 
			this->m_fX1=x1;
			this->m_fX2=x2;
			this->m_fY1=y1;
			this->m_fY2=y2;
			this->m_fZ1=z1;
			this->m_fZ2=z2;
			iFlag=1;
		}
		void pO(float x=0.0,float y=0.0,float z=0.0,float m=0.0,float n=0.0,float p=0.0){
			this->m_fX1=x;
			this->m_fY1=y;
			this->m_fZ1=z;
			this->m_fM=m;
			this->m_fN=n;
			this->m_fP=p;
			iFlag=2;
		}
		
		void setX(float x1=0.0,float x2=0.0);	//设置和返回向量或坐标 
		void setY(float y1=0.0,float y2=0.0);
		void setZ(float z1=0.0,float z2=0.0);
		 
		void setM(float m=0.0);
		void setN(float n=0.0);
		void setP(float p=0.0);
		
		float getXx();
		float getYy();
		float getZz();
		
		float getXX();	//返回第二个点 
		float getYY();
		float getZZ();
		 
		float getM();
		float getN();
	 	float getP();
};

/*
*方法作用：设置或返回向量或坐标
*参数：set函数参数是对应的向量分量或坐标分量，get函数无参
*返回值：set函数无返回值，get函数返回对应的向量分量或坐标分量
*/
void CLine::setX(float x1,float x2){
	this->m_fX1=x1;
	this->m_fX2=x2;
}

void CLine::setY(float y1,float y2){
	this->m_fY1=y1;
	this->m_fY2=y2;
}

void CLine::setZ(float z1,float z2){
	this->m_fZ1=z1;
	this->m_fZ2=z2;
}

void CLine::setM(float m){
	this->m_fM=m;
}

void CLine::setN(float n){
	this->m_fN=n;
}

void CLine::setP(float p){
	this->m_fP=p;
}

float CLine::getXx(){
	return this->m_fX1; 
}

float CLine::getXX(){
	return this->m_fX2; 
}

float CLine::getYy(){
	return this->m_fY1;
}

float CLine::getYY(){
	return this->m_fY2;
}

float CLine::getZz(){
	return this->m_fZ1;
}

float CLine::getZZ(){
	return this->m_fZ2;
}

float CLine::getM(){
	return this->m_fM;
}

float CLine::getN(){
	return this->m_fN;
}
float CLine::getP(){
	return this->m_fP;
}


/*
* 类的作用：CPanel创建了面类
* 类的使用：CPanel cP;
* 作者：20203907 周朝勇
* 当前版本及完成时间：ver 1.01，2021/08/24
*/
class CPanel{
	private:
		float m_fX1,m_fX2,m_fX3,m_fY1,m_fY2,m_fY3,m_fZ1,m_fZ2,m_fZ3;
		float m_fM,m_fN,m_fP;	//向量 
	public:
		int iFlag;	//记录是怎么创建的平面 
		CPanel(){
			iFlag=0; 
		} 
		~CPanel(){
		}
		
		void ppp(float x1=0.0,float x2=0.0,float x3=0.0,float y1=0.0,float y2=0.0,float y3=0.0,float z1=0.0,float z2=0.0,float z3=0.0){	//三点创建 
			this->m_fX1=x1;
			this->m_fX2=x2;
			this->m_fX3=x3; 
			this->m_fY1=y1;
			this->m_fY2=y2;
			this->m_fX3=y3; 
			this->m_fZ1=z1;
			this->m_fZ2=z2;
			this->m_fX3=z3; 
			iFlag=1;
		}
		
		void pO(float x=0.0,float y=0.0,float z=0.0,float m=0.0,float n=0.0,float p=0.0){	//一点一向量 
			this->m_fX1=x;
			this->m_fY1=y;
			this->m_fZ1=z;
			this->m_fM=m;
			this->m_fN=n;
			this->m_fP=p;
			iFlag=2;
		}
		
		void setX(float x1=0.0,float x2=0.0,float x3=0.0);	//设置和返回向量或坐标 
		void setY(float y1=0.0,float y2=0.0,float y3=0.0);
		void setZ(float z1=0.0,float z2=0.0,float z3=0.0);
		 
		void setdM(float m=0.0);
		void setdN(float n=0.0);
		void setdP(float p=0.0);
		
		float getXx();
		float getYy();
		float getZz();
		
		float getXX();	//返回第二个点 
		float getYY();
		float getZZ();
		
		float getXXx();	//返回第三个点 
		float getYYy();
		float getZZz();
		 
		float getM();
		float getN();
	 	float getP();
		
};

/*
*方法作用：设置或返回向量或坐标
*参数：set函数参数是对应的向量分量或坐标分量，get函数无参
*返回值：set函数无返回值，get函数返回对应的向量分量或坐标分量
*/
void CPanel::setX(float x1,float x2,float x3){
	this->m_fX1=x1;
	this->m_fX2=x2;
	this->m_fX3=x3;
}

void CPanel::setY(float y1,float y2,float y3){
	this->m_fY1=y1;
	this->m_fY2=y2;
	this->m_fY3=y3;
}

void CPanel::setZ(float z1,float z2,float z3){
	this->m_fZ1=z1;
	this->m_fZ2=z2;
	this->m_fZ3=z3;
}
		 
void CPanel::setdM(float m){
	this->m_fM=m;
}

void CPanel::setdN(float n){
	this->m_fN=n;
}

void CPanel::setdP(float p){
	this->m_fP=p;
}

float CPanel::getXx(){
	return this->m_fX1;
}

float CPanel::getYy(){
	return this->m_fY1;
}

float CPanel::getZz(){
	return this->m_fZ1;
}
		
float CPanel::getXX(){
	return this->m_fX2;
}

float CPanel::getYY(){
	return this->m_fY2;
}

float CPanel::getZZ(){
	return this->m_fZ2;
}
		
float CPanel::getXXx(){
	return this->m_fX3;
}

float CPanel::getYYy(){
	return this->m_fY3;
}

float CPanel::getZZz(){
	return this->m_fZ3;
}

float CPanel::getM(){
	return this->m_fM;
}

float CPanel::getN(){
	return this->m_fN;
}

float CPanel::getP(){
	return this->m_fP;
}

/*
*方法作用：显示功能菜单 
*无参
*无返回值 
*/
void showMenu(){
	cout<<"请选择下面的一个项目"<<endl;
	cout<<"-----1 两点之间的距离-----"<<endl;
	cout<<"-----2 点到直线的距离-----"<<endl;
	cout<<"-----3 点到平面的距离-----"<<endl;
	cout<<"-----4 线和线的关系  -----"<<endl;
	cout<<"-----5 点和平面的关系-----"<<endl;
	cout<<"-----6 线和平面的关系-----"<<endl;
	cout<<"-----7 平面和平面的关系---"<<endl;
	cout<<"-----8 直线的单位法向量---"<<endl;
	cout<<"-----9 平面的单位方向向量-"<<endl;
	cout<<"-----0 退出程序-----------"<<endl;
	cout<<endl;
	cout<<"-----请输入选项:";
}

/*
*方法作用：计算两点距离 
*无参
*无返回值
*/
void distance(){
	float fX,fY,fZ;
	
	cout<<"请输入第一个点的坐标"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ; 
	
	CPoint cp1(fX,fY,fZ);
	
	cout<<"请输入第二个点的坐标"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ; 
	
	CPoint cp2(fX,fY,fZ);
	
	float fLen;
	fLen=sqrt((cp1.getX()-cp2.getX())*(cp1.getX()-cp2.getX())+(cp1.getY()-cp2.getY())*(cp1.getY()-cp2.getY())+(cp1.getZ()-cp2.getZ())*(cp1.getZ()-cp2.getZ()));
	
	cout<<"这两点的距离为:"<<fLen<<endl;
}

/*
*方法作用：计算点到直线距离
*无参
*返回值：点到直线距离
*/
float pLL(){
	float fX,fY,fZ;
	
	int iIndex=1;	//记录选择 
	cout<<"请输入点的坐标"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ;
	
	CPoint cp(fX,fY,fZ);
	
	CLine cl;
	
	cout<<"要使用两点确定直线请输入1，要使用点斜式确定直线请输入2"<<endl;
	cout<<"您请输入：";
	cin>>iIndex;
	
	if(iIndex==1){
		float fX1,fY1,fZ1;
		cout<<"请输入第一个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fX2,fY2,fZ2;
		cout<<"请输入第二个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX2;
		cout<<"Y:";
		cin>>fY2;
		cout<<"Z:";
		cin>>fZ2; 
		
		cl.pp(fX1,fY1,fZ1,fX2,fY2,fZ2);
		
		float fXx,fYy,fZz;	//点和直线上点向量
		fXx=fX-fX1;
		fYy=fY-fY1;
		fZz=fZ-fZ1;
		
		float fXX,fYY,fZZ;	//直线的向量
		fXX=fX2-fX1;
		fYY=fY2-fY1;
		fZZ=fZ2-fZ1;
		
		float fLen1;	//直线上两点距离 
		fLen1=sqrt(fXX*fXX+fYY*fYY+fZZ*fZZ);
		
		float fLen2;	//直线上点和直线外点距离
		fLen2=sqrt(fXx*fXx+fYy*fYy+fZz*fZz);
		
		float fQuality;	//数量积
		fQuality=fXx*fXX+fYy*fYY+fZz*fZZ;
		
		float fInclude;	//夹角
		fInclude = acos(fQuality/fLen1/fLen2);
		
		float fLen;	//点到直线距离
		fLen=abs(fLen2*sin(fInclude));
		if(fLen2==0||sin(fInclude)==0){
			return 0;
		}
		return fLen;
	}
	if(iIndex==2){
		float fX1,fY1,fZ1;
		cout<<"请输入点的坐标"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fM,fN,fP;
		cout<<"请输入向量"<<endl;
		cout<<"X:";
		cin>>fM;
		cout<<"Y:";
		cin>>fN;
		cout<<"Z:";
		cin>>fP;
		
		
		cl.pO(fX1,fY1,fZ1,fM,fN,fP);
		
		float fXx,fYy,fZz;	//点和直线上点向量
		fXx=fX-fX1;
		fYy=fY-fY1;
		fZz=fZ-fZ1;
		
		float fXX,fYY,fZZ;
		fXX=cl.getM();
		fYY=cl.getN();
		fZZ=cl.getP();
		
		float fLen1;	//直线上两点距离
		fLen1=sqrt(fXX*fXX+fYY*fYY+fZZ*fZZ);
		
		float fLen2;	//直线上点和直线外点距离
		fLen2=sqrt(fXx*fXx+fYy*fYy+fZz*fZz);
		
		float fQuality;	//数量积
		fQuality=fXx*fXX+fYy*fYY+fZz*fZZ;
		
		float fInclude;	//夹角
		fInclude = acos(fQuality/fLen1/fLen2);
		
		float fLen;	//点到直线距离
		fLen=abs(fLen2*sin(fInclude));
		
		return fLen;
	}
}

/*
*方法作用：判断点和直线关系 
无参
无返回值 
*/
void pL(){
	float fLen;
	fLen=pLL();
	if(fLen==0){
		cout<<"点在线上"<<endl;
	}
	else{
		cout<<"点在线外"<<endl;
	}
}

/*
*方法作用：计算点到平面距离
*无参
*返回值：距离 
*/
float pPL(){
	float fX,fY,fZ;
	
	int iIndex=1;	//记录选择 
	cout<<"请输入点的坐标"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ;
	
	cout<<"如果要用三点确定平面请输入1，用一个点一个法向量确定平面请输入2"<<endl;
	cout<<"请输入：";
	cin>>iIndex;
	
	CPanel cP;
	if(iIndex==1){
		float fX1,fY1,fZ1;
		cout<<"请输入第一个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fX2,fY2,fZ2;
		cout<<"请输入第二个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX2;
		cout<<"Y:";
		cin>>fY2;
		cout<<"Z:";
		cin>>fZ2;
		
		float fX3,fY3,fZ3;
		cout<<"请输入第三个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX3;
		cout<<"Y:";
		cin>>fY3;
		cout<<"Z:";
		cin>>fZ3;
		
		cP.ppp(fX1,fY1,fZ1,fX2,fY2,fZ2,fX3,fY3,fZ3);
		
		float fA,fB,fC,fD;	//直线的一般方程关键参数
		fA=(fY2-fY1)*(fZ3-fZ1)-(fZ2-fZ1)*(fY3-fY1);
		fB=(fZ2-fZ1)*(fX3-fX1)-(fX2-fX1)*(fZ3-fZ1);
		fC=(fX2-fX1)*(fY3-fY1)-(fY2-fY1)*(fX3-fX1);
		
		float fLen;
		fLen=abs(fA*fX+fB*fY+fC*fZ)/sqrt(fA*fA+fB*fB+fC*fC);
		
		return fLen;
	}
	if(iIndex==2){
		float fX1,fY1,fZ1;
		cout<<"请输入点的坐标"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fM,fN,fP;
		cout<<"请输入向量"<<endl;
		cout<<"X:";
		cin>>fM;
		cout<<"Y:";
		cin>>fN;
		cout<<"Z:";
		cin>>fP;
		
		float fLen;
		fLen=abs(fM*fX+fN*fY+fP*fZ)/sqrt(fM*fM+fN*fN+fP*fP);
		
		return fLen;
	}
}

/*
*方法作用：判断点和平面关系
*无参
*无返回值 
*/
void pP(){
	float fLen;
	fLen=pPL();
	if(fLen==0){
		cout<<"点在面内"<<endl;
	}
	else{
		cout<<"点在面外"<<endl;
	}
} 

/*
*方法作用：判断线和线的关系
*无参
*无返回值 
*/
void lL(){
	float fM1,fN1,fP1;
	cout<<"请输入第一条直线的方向向量"<<endl;
	cout<<"X:";
	cin>>fM1;
	cout<<"Y:";
	cin>>fN1;
	cout<<"Z:";
	cin>>fP1;
	
	float fM2,fN2,fP2;	
	cout<<"请输入第二条直线的方向向量"<<endl; 
	cout<<"X:";
	cin>>fM2;
	cout<<"Y:";
	cin>>fN2;
	cout<<"Z:";
	cin>>fP2;
	
	float fX1,fY1,fZ1;
	cout<<"请输入第一条直线的已知点坐标"<<endl;
	cout<<"X:";
	cin>>fX1;
	cout<<"Y:";
	cin>>fY1;
	cout<<"Z:";
	cin>>fZ1;
	
	float fX2,fY2,fZ2;
	cout<<"请输入第二条直线的已知点坐标:"<<endl;
	cout<<"X:";
	cin>>fX2;
	cout<<"Y:";
	cin>>fY2;
	cout<<"Z:";
	cin>>fZ2;
	
	float fXx,fYy,fZz;
	fXx = fX1-fX2;
	fYy = fY1-fY2;
	fZz = fZ1-fZ2;
	//混合积
	float fXX,fYY,fZZ;
	fXX = fN1*fP2 - fP1*fN2;
	fYY = fM1*fP2 - fP1*fM2;
	fZZ = fM1*fN2 - fN1*fM2;
	//判断是否异面
	if(fXX*fXx+fYY*fYy+fZZ*fZz!=0) {
		if(fM1*fM2+fN1*fN2+fP1*fP2 == 0){
		cout<<"这两条直线异面且互相垂直"<<endl;
		}
		else cout<<"这两条直线异面"<<endl; 
	}
	else {
		if(fM1*fM2+fN1*fN2+fP1*fP2 == 0){
		cout<<"这两条直线共面且互相垂直"<<endl;
		}
   		else if(fM1/fM2 == fN1/fN2 == fP1/fN2){
		cout<<"这两条直线共面且互相平行"<<endl;
		}
		else cout<<"这两条直线共面且相交"<<endl; 
	}
}

/*
*方法作用：判断线和面的关系
*无参
*无返回值 
*/
void lP(){
	cout<<"直线的一般方程为Ax+By+Cz+D=0"<<endl;
	cout<<"请输入平面一般方程的参数"<<endl;
	float fA,fB,fC;
	cout<<"A:";
	cin>>fA;
	cout<<"B:";
	cin>>fB;
	cout<<"C:";
	cin>>fC;
	
	cout<<"请输入直线的方向向量"<<endl;
	float fM,fN,fP;
	cout<<"m:";
	cin>>fM;
	cout<<"n:";
	cin>>fN;
	cout<<"p:";
	cin>>fN;
	
	if(fA*fM+fB*fN+fC*fP==0){
		cout<<"直线与平面平行"<<endl;
	}
	else if(fA/fM==fB/fN==fC/fP){
		cout<<"直线与平面垂直"<<endl;
	}
	else{
		cout<<"直线与平面相交"<<endl;
	}
} 

/*
*方法作用：判断面和面的关系 
*无参
*无返回值 
*/
void PP(){
	cout<<"直线的一般方程为Ax+By+Cz+D=0"<<endl;
	cout<<"请输入第一个平面一般方程的参数"<<endl;
	float fA1,fB1,fC1,fD1;
	cout<<"A:";
	cin>>fA1;
	cout<<"B:";
	cin>>fB1;
	cout<<"C:";
	cin>>fC1;
	cout<<"D:";
	cin>>fD1;
	
	cout<<"请输入第二个平面一般方程的参数"<<endl;
	float fA2,fB2,fC2,fD2;
	cout<<"A:";
	cin>>fA2;
	cout<<"B:";
	cin>>fB2;
	cout<<"C:";
	cin>>fC2;
	cout<<"D:";
	cin>>fD2;
	
	if(fA1/fA2==fB1/fB2==fC1/fC2){
		if(fA1/fA2 == fD1/fD2)
		cout<<"是同一个平面"<<endl;
		else 
		cout<<"这两个平面平行"<<endl; 
	}
	else if(fA1*fA2+fB1*fB2+fC1*fC2==0){
		cout<<"这两个平面垂直"<<endl;
	}
	else{
		cout<<"这两个平面相交"<<endl;
	}
}

/*
*方法作用：求面的单位法向量
*无参
*无返回值 
*/
void Pp(){
	float fX1,fX2,fX3,fY1,fY2,fY3,fZ1,fZ2,fZ3;
	cout<<"请输入第一个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		cout<<"请输入第二个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX2;
		cout<<"Y:";
		cin>>fY2;
		cout<<"Z:";
		cin>>fZ2;

		cout<<"请输入第三个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX3;
		cout<<"Y:";
		cin>>fY3;
		cout<<"Z:";
		cin>>fZ3;
		
	float fXx1,fYy1,fZz1,fXx2,fYy2,fZz2;
	fXx1=fX1-fX2;
	fYy1=fY1-fY2;
	fZz1=fZ1-fZ2;
	
	fXx2=fX1-fX3;
	fYy2=fY1-fY3;
	fZz2=fZ1-fZ3;
	
	float fXx,fYy,fZz;
	fXx=fYy1*fZz2-fZz1*fYy2;
	fYy=fXx1*fZz2-fZz1*fXx2;
	fZz=fXx1*fYy2-fYy1*fXx2;
	
	cout<<"所求平面的单位法向量为:("<<fXx/sqrt(fXx*fXx+fYy*fYy+fZz*fZz)<<","<<fYy/sqrt(fXx*fXx+fYy*fYy+fZz*fZz)<<","<<fZz/sqrt(fXx*fXx+fYy*fYy+fZz*fZz)<<")"<<endl;
}

/*
*方法作用：求平面的单位法向量
*无参
*无返回值 
*/
void PPP(){
	cout<<"直线的一般方程为Ax+By+Cz+D=0"<<endl;
	cout<<"请输入平面一般方程的参数"<<endl;
	float fA,fB,fC,fD;
	cout<<"A:";
	cin>>fA;
	cout<<"B:";
	cin>>fB;
	cout<<"C:";
	cin>>fC;
	cout<<"D:";
	cin>>fD;
	
	CPanel cP;
	
	cout<<"所求直线的单位法向量为:("<<fA/sqrt(fA*fA+fB*fB+fC*fC)<<","<<fB/sqrt(fA*fA+fB*fB+fC*fC)<<","<<fC/sqrt(fA*fA+fB*fB+fC*fC)<<")"<<endl;
}

/*
*方法作用：创建平面
*无参
*无返回值 
*/
void crtP(){
	cout<<"1.三点确定平面"<<endl;
	cout<<"2.平面的一般方程"<<endl;
	cout<<"请输入你的选择:";
	int iChoice=2;
	cin>>iChoice;
	switch(iChoice){
		case 1:
			Pp();
			break;
		case 2:
			PPP();
			break;
	}
}

/*
*方法作用：求直线的单位向量
*无参
*无返回值 
*/
void Ll(){
	cout<<"直线的一般方程为Ax+By+Cz+D=0"<<endl;
	cout<<"请输入第一个平面一般方程的参数"<<endl;
	float fA1,fB1,fC1,fD1;
	cout<<"A:";
	cin>>fA1;
	cout<<"B:";
	cin>>fB1;
	cout<<"C:";
	cin>>fC1;
	cout<<"D:";
	cin>>fD1;
	
	cout<<"请输入第二个平面一般方程的参数"<<endl;
	float fA2,fB2,fC2,fD2;
	cout<<"A:";
	cin>>fA2;
	cout<<"B:";
	cin>>fB2;
	cout<<"C:";
	cin>>fC2;
	cout<<"D:";
	cin>>fD2;
	
	float fM,fN,fP;
	fM=fB1*fC2-fB2*fC1;
	fN=fA1*fC2-fA1*fC1;
	fP=fA1*fB2-fA2*fB1;
	
	cout<<"所求直线的单位方向向量为:("<<fM/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fN/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fP/sqrt(fM*fM+fN*fN+fP*fP)<<")"<<endl;
}

void LL(){
	float fX1,fX2,fY1,fY2,fZ1,fZ2;
	cout<<"请输入第一个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		cout<<"请输入第二个点的坐标"<<endl;
		cout<<"X:";
		cin>>fX2;
		cout<<"Y:";
		cin>>fY2;
		cout<<"Z:";
		cin>>fZ2;
		
		float fM,fN,fP;
		fM=fX2-fX1;
		fN=fY2-fY1;
		fP=fZ2-fZ1;
		
		cout<<"所求直线的单位方向向量为:("<<fM/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fN/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fP/sqrt(fM*fM+fN*fN+fP*fP)<<")"<<endl;
}

/*
*方法作用：创建直线 
*无参
*无返回值 
*/
void crtL(){
	cout<<"1.两平面相交确定直线"<<endl;
	cout<<"2.两点确定直线"<<endl;
	cout<<"请输入你的选择:";
	int iChoice=2;
	cin>>iChoice;
	switch(iChoice){
		case 1:
			Ll();
			break;
		case 2:
			LL();
			break;
	}
}



int main(){
	int iChoice;
	while(1){
		showMenu();
		cin>>iChoice;
		switch(iChoice){
			case 1:
				distance();
				system("pause");
				system("cls");
				break;
			case 2:
				cout<<pLL()<<endl;
				system("pause");
				system("cls");
				break;
			case 3:
				cout<<pPL()<<endl;
				system("pause");
				system("cls");
				break;
			case 4:
				lL(); 
				system("pause");
				system("cls");
				break;
			case 5:
				pP(); 
				system("pause");
				system("cls");
				break;
			case 6:
				lP(); 
				system("pause");
				system("cls");
				break;
			case 7:
				PP();
				system("pause");
				system("cls");
				break;
			case 8:
				crtL();
				system("pause");
				system("cls");
				break;
			case 9:
				crtP();
				system("pause");
				system("cls");
				break;
			case 0:
				cout<<"程序已退出";
				exit(0);
		}
	}
}

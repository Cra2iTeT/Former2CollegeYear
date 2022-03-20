/*
* �ļ�����main.cpp
* ���ߣ�20203907; �ܳ���
* ������ڣ�2021/08/24
* �ļ����ݣ��ռ������Ĵ���
* ��ǰ�汾��1.0
*/
#include<iostream>
#include<cmath>
#include<cstdlib>
using namespace std;


/*
* ������ã�Cpoint�����˵���
* ���ʹ�ã�Cpoint cp;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/24
*/
class CPoint{
	private:
		 float m_fX, m_fY, m_fZ;	//����
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
*�������ã����úͷ�������
*������set���������Ǹ����꣬get�����޲�
*����ֵ��set�����޷���ֵ��get�������ظ����꣨float�� 
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
* ������ã�CLine����������
* ���ʹ�ã�CLine cl;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/24
*/
class CLine{
	private:
		float m_fX1,m_fX2,m_fY1,m_fY2,m_fZ1,m_fZ2;
		float m_fM,m_fN,m_fP;	//��бʽ������������
	public:
		int iFlag;	//��¼����ô������ֱ��
		
		CLine(){
			iFlag=0;
		}
		~CLine(){
		}
		
		void pp(float x1=0.0,float x2=0.0,float y1=0.0,float y2=0.0,float z1=0.0,float z2=0.0){	//���㴴�� 
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
		
		void setX(float x1=0.0,float x2=0.0);	//���úͷ������������� 
		void setY(float y1=0.0,float y2=0.0);
		void setZ(float z1=0.0,float z2=0.0);
		 
		void setM(float m=0.0);
		void setN(float n=0.0);
		void setP(float p=0.0);
		
		float getXx();
		float getYy();
		float getZz();
		
		float getXX();	//���صڶ����� 
		float getYY();
		float getZZ();
		 
		float getM();
		float getN();
	 	float getP();
};

/*
*�������ã����û򷵻�����������
*������set���������Ƕ�Ӧ���������������������get�����޲�
*����ֵ��set�����޷���ֵ��get�������ض�Ӧ�������������������
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
* ������ã�CPanel����������
* ���ʹ�ã�CPanel cP;
* ���ߣ�20203907 �ܳ���
* ��ǰ�汾�����ʱ�䣺ver 1.01��2021/08/24
*/
class CPanel{
	private:
		float m_fX1,m_fX2,m_fX3,m_fY1,m_fY2,m_fY3,m_fZ1,m_fZ2,m_fZ3;
		float m_fM,m_fN,m_fP;	//���� 
	public:
		int iFlag;	//��¼����ô������ƽ�� 
		CPanel(){
			iFlag=0; 
		} 
		~CPanel(){
		}
		
		void ppp(float x1=0.0,float x2=0.0,float x3=0.0,float y1=0.0,float y2=0.0,float y3=0.0,float z1=0.0,float z2=0.0,float z3=0.0){	//���㴴�� 
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
		
		void pO(float x=0.0,float y=0.0,float z=0.0,float m=0.0,float n=0.0,float p=0.0){	//һ��һ���� 
			this->m_fX1=x;
			this->m_fY1=y;
			this->m_fZ1=z;
			this->m_fM=m;
			this->m_fN=n;
			this->m_fP=p;
			iFlag=2;
		}
		
		void setX(float x1=0.0,float x2=0.0,float x3=0.0);	//���úͷ������������� 
		void setY(float y1=0.0,float y2=0.0,float y3=0.0);
		void setZ(float z1=0.0,float z2=0.0,float z3=0.0);
		 
		void setdM(float m=0.0);
		void setdN(float n=0.0);
		void setdP(float p=0.0);
		
		float getXx();
		float getYy();
		float getZz();
		
		float getXX();	//���صڶ����� 
		float getYY();
		float getZZ();
		
		float getXXx();	//���ص������� 
		float getYYy();
		float getZZz();
		 
		float getM();
		float getN();
	 	float getP();
		
};

/*
*�������ã����û򷵻�����������
*������set���������Ƕ�Ӧ���������������������get�����޲�
*����ֵ��set�����޷���ֵ��get�������ض�Ӧ�������������������
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
*�������ã���ʾ���ܲ˵� 
*�޲�
*�޷���ֵ 
*/
void showMenu(){
	cout<<"��ѡ�������һ����Ŀ"<<endl;
	cout<<"-----1 ����֮��ľ���-----"<<endl;
	cout<<"-----2 �㵽ֱ�ߵľ���-----"<<endl;
	cout<<"-----3 �㵽ƽ��ľ���-----"<<endl;
	cout<<"-----4 �ߺ��ߵĹ�ϵ  -----"<<endl;
	cout<<"-----5 ���ƽ��Ĺ�ϵ-----"<<endl;
	cout<<"-----6 �ߺ�ƽ��Ĺ�ϵ-----"<<endl;
	cout<<"-----7 ƽ���ƽ��Ĺ�ϵ---"<<endl;
	cout<<"-----8 ֱ�ߵĵ�λ������---"<<endl;
	cout<<"-----9 ƽ��ĵ�λ��������-"<<endl;
	cout<<"-----0 �˳�����-----------"<<endl;
	cout<<endl;
	cout<<"-----������ѡ��:";
}

/*
*�������ã������������ 
*�޲�
*�޷���ֵ
*/
void distance(){
	float fX,fY,fZ;
	
	cout<<"�������һ���������"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ; 
	
	CPoint cp1(fX,fY,fZ);
	
	cout<<"������ڶ����������"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ; 
	
	CPoint cp2(fX,fY,fZ);
	
	float fLen;
	fLen=sqrt((cp1.getX()-cp2.getX())*(cp1.getX()-cp2.getX())+(cp1.getY()-cp2.getY())*(cp1.getY()-cp2.getY())+(cp1.getZ()-cp2.getZ())*(cp1.getZ()-cp2.getZ()));
	
	cout<<"������ľ���Ϊ:"<<fLen<<endl;
}

/*
*�������ã�����㵽ֱ�߾���
*�޲�
*����ֵ���㵽ֱ�߾���
*/
float pLL(){
	float fX,fY,fZ;
	
	int iIndex=1;	//��¼ѡ�� 
	cout<<"������������"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ;
	
	CPoint cp(fX,fY,fZ);
	
	CLine cl;
	
	cout<<"Ҫʹ������ȷ��ֱ��������1��Ҫʹ�õ�бʽȷ��ֱ��������2"<<endl;
	cout<<"�������룺";
	cin>>iIndex;
	
	if(iIndex==1){
		float fX1,fY1,fZ1;
		cout<<"�������һ���������"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fX2,fY2,fZ2;
		cout<<"������ڶ����������"<<endl;
		cout<<"X:";
		cin>>fX2;
		cout<<"Y:";
		cin>>fY2;
		cout<<"Z:";
		cin>>fZ2; 
		
		cl.pp(fX1,fY1,fZ1,fX2,fY2,fZ2);
		
		float fXx,fYy,fZz;	//���ֱ���ϵ�����
		fXx=fX-fX1;
		fYy=fY-fY1;
		fZz=fZ-fZ1;
		
		float fXX,fYY,fZZ;	//ֱ�ߵ�����
		fXX=fX2-fX1;
		fYY=fY2-fY1;
		fZZ=fZ2-fZ1;
		
		float fLen1;	//ֱ����������� 
		fLen1=sqrt(fXX*fXX+fYY*fYY+fZZ*fZZ);
		
		float fLen2;	//ֱ���ϵ��ֱ��������
		fLen2=sqrt(fXx*fXx+fYy*fYy+fZz*fZz);
		
		float fQuality;	//������
		fQuality=fXx*fXX+fYy*fYY+fZz*fZZ;
		
		float fInclude;	//�н�
		fInclude = acos(fQuality/fLen1/fLen2);
		
		float fLen;	//�㵽ֱ�߾���
		fLen=abs(fLen2*sin(fInclude));
		if(fLen2==0||sin(fInclude)==0){
			return 0;
		}
		return fLen;
	}
	if(iIndex==2){
		float fX1,fY1,fZ1;
		cout<<"������������"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fM,fN,fP;
		cout<<"����������"<<endl;
		cout<<"X:";
		cin>>fM;
		cout<<"Y:";
		cin>>fN;
		cout<<"Z:";
		cin>>fP;
		
		
		cl.pO(fX1,fY1,fZ1,fM,fN,fP);
		
		float fXx,fYy,fZz;	//���ֱ���ϵ�����
		fXx=fX-fX1;
		fYy=fY-fY1;
		fZz=fZ-fZ1;
		
		float fXX,fYY,fZZ;
		fXX=cl.getM();
		fYY=cl.getN();
		fZZ=cl.getP();
		
		float fLen1;	//ֱ�����������
		fLen1=sqrt(fXX*fXX+fYY*fYY+fZZ*fZZ);
		
		float fLen2;	//ֱ���ϵ��ֱ��������
		fLen2=sqrt(fXx*fXx+fYy*fYy+fZz*fZz);
		
		float fQuality;	//������
		fQuality=fXx*fXX+fYy*fYY+fZz*fZZ;
		
		float fInclude;	//�н�
		fInclude = acos(fQuality/fLen1/fLen2);
		
		float fLen;	//�㵽ֱ�߾���
		fLen=abs(fLen2*sin(fInclude));
		
		return fLen;
	}
}

/*
*�������ã��жϵ��ֱ�߹�ϵ 
�޲�
�޷���ֵ 
*/
void pL(){
	float fLen;
	fLen=pLL();
	if(fLen==0){
		cout<<"��������"<<endl;
	}
	else{
		cout<<"��������"<<endl;
	}
}

/*
*�������ã�����㵽ƽ�����
*�޲�
*����ֵ������ 
*/
float pPL(){
	float fX,fY,fZ;
	
	int iIndex=1;	//��¼ѡ�� 
	cout<<"������������"<<endl;
	cout<<"X:";
	cin>>fX;
	cout<<"Y:";
	cin>>fY;
	cout<<"Z:";
	cin>>fZ;
	
	cout<<"���Ҫ������ȷ��ƽ��������1����һ����һ��������ȷ��ƽ��������2"<<endl;
	cout<<"�����룺";
	cin>>iIndex;
	
	CPanel cP;
	if(iIndex==1){
		float fX1,fY1,fZ1;
		cout<<"�������һ���������"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fX2,fY2,fZ2;
		cout<<"������ڶ����������"<<endl;
		cout<<"X:";
		cin>>fX2;
		cout<<"Y:";
		cin>>fY2;
		cout<<"Z:";
		cin>>fZ2;
		
		float fX3,fY3,fZ3;
		cout<<"������������������"<<endl;
		cout<<"X:";
		cin>>fX3;
		cout<<"Y:";
		cin>>fY3;
		cout<<"Z:";
		cin>>fZ3;
		
		cP.ppp(fX1,fY1,fZ1,fX2,fY2,fZ2,fX3,fY3,fZ3);
		
		float fA,fB,fC,fD;	//ֱ�ߵ�һ�㷽�̹ؼ�����
		fA=(fY2-fY1)*(fZ3-fZ1)-(fZ2-fZ1)*(fY3-fY1);
		fB=(fZ2-fZ1)*(fX3-fX1)-(fX2-fX1)*(fZ3-fZ1);
		fC=(fX2-fX1)*(fY3-fY1)-(fY2-fY1)*(fX3-fX1);
		
		float fLen;
		fLen=abs(fA*fX+fB*fY+fC*fZ)/sqrt(fA*fA+fB*fB+fC*fC);
		
		return fLen;
	}
	if(iIndex==2){
		float fX1,fY1,fZ1;
		cout<<"������������"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		float fM,fN,fP;
		cout<<"����������"<<endl;
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
*�������ã��жϵ��ƽ���ϵ
*�޲�
*�޷���ֵ 
*/
void pP(){
	float fLen;
	fLen=pPL();
	if(fLen==0){
		cout<<"��������"<<endl;
	}
	else{
		cout<<"��������"<<endl;
	}
} 

/*
*�������ã��ж��ߺ��ߵĹ�ϵ
*�޲�
*�޷���ֵ 
*/
void lL(){
	float fM1,fN1,fP1;
	cout<<"�������һ��ֱ�ߵķ�������"<<endl;
	cout<<"X:";
	cin>>fM1;
	cout<<"Y:";
	cin>>fN1;
	cout<<"Z:";
	cin>>fP1;
	
	float fM2,fN2,fP2;	
	cout<<"������ڶ���ֱ�ߵķ�������"<<endl; 
	cout<<"X:";
	cin>>fM2;
	cout<<"Y:";
	cin>>fN2;
	cout<<"Z:";
	cin>>fP2;
	
	float fX1,fY1,fZ1;
	cout<<"�������һ��ֱ�ߵ���֪������"<<endl;
	cout<<"X:";
	cin>>fX1;
	cout<<"Y:";
	cin>>fY1;
	cout<<"Z:";
	cin>>fZ1;
	
	float fX2,fY2,fZ2;
	cout<<"������ڶ���ֱ�ߵ���֪������:"<<endl;
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
	//��ϻ�
	float fXX,fYY,fZZ;
	fXX = fN1*fP2 - fP1*fN2;
	fYY = fM1*fP2 - fP1*fM2;
	fZZ = fM1*fN2 - fN1*fM2;
	//�ж��Ƿ�����
	if(fXX*fXx+fYY*fYy+fZZ*fZz!=0) {
		if(fM1*fM2+fN1*fN2+fP1*fP2 == 0){
		cout<<"������ֱ�������һ��ഹֱ"<<endl;
		}
		else cout<<"������ֱ������"<<endl; 
	}
	else {
		if(fM1*fM2+fN1*fN2+fP1*fP2 == 0){
		cout<<"������ֱ�߹����һ��ഹֱ"<<endl;
		}
   		else if(fM1/fM2 == fN1/fN2 == fP1/fN2){
		cout<<"������ֱ�߹����һ���ƽ��"<<endl;
		}
		else cout<<"������ֱ�߹������ཻ"<<endl; 
	}
}

/*
*�������ã��ж��ߺ���Ĺ�ϵ
*�޲�
*�޷���ֵ 
*/
void lP(){
	cout<<"ֱ�ߵ�һ�㷽��ΪAx+By+Cz+D=0"<<endl;
	cout<<"������ƽ��һ�㷽�̵Ĳ���"<<endl;
	float fA,fB,fC;
	cout<<"A:";
	cin>>fA;
	cout<<"B:";
	cin>>fB;
	cout<<"C:";
	cin>>fC;
	
	cout<<"������ֱ�ߵķ�������"<<endl;
	float fM,fN,fP;
	cout<<"m:";
	cin>>fM;
	cout<<"n:";
	cin>>fN;
	cout<<"p:";
	cin>>fN;
	
	if(fA*fM+fB*fN+fC*fP==0){
		cout<<"ֱ����ƽ��ƽ��"<<endl;
	}
	else if(fA/fM==fB/fN==fC/fP){
		cout<<"ֱ����ƽ�洹ֱ"<<endl;
	}
	else{
		cout<<"ֱ����ƽ���ཻ"<<endl;
	}
} 

/*
*�������ã��ж������Ĺ�ϵ 
*�޲�
*�޷���ֵ 
*/
void PP(){
	cout<<"ֱ�ߵ�һ�㷽��ΪAx+By+Cz+D=0"<<endl;
	cout<<"�������һ��ƽ��һ�㷽�̵Ĳ���"<<endl;
	float fA1,fB1,fC1,fD1;
	cout<<"A:";
	cin>>fA1;
	cout<<"B:";
	cin>>fB1;
	cout<<"C:";
	cin>>fC1;
	cout<<"D:";
	cin>>fD1;
	
	cout<<"������ڶ���ƽ��һ�㷽�̵Ĳ���"<<endl;
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
		cout<<"��ͬһ��ƽ��"<<endl;
		else 
		cout<<"������ƽ��ƽ��"<<endl; 
	}
	else if(fA1*fA2+fB1*fB2+fC1*fC2==0){
		cout<<"������ƽ�洹ֱ"<<endl;
	}
	else{
		cout<<"������ƽ���ཻ"<<endl;
	}
}

/*
*�������ã�����ĵ�λ������
*�޲�
*�޷���ֵ 
*/
void Pp(){
	float fX1,fX2,fX3,fY1,fY2,fY3,fZ1,fZ2,fZ3;
	cout<<"�������һ���������"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		cout<<"������ڶ����������"<<endl;
		cout<<"X:";
		cin>>fX2;
		cout<<"Y:";
		cin>>fY2;
		cout<<"Z:";
		cin>>fZ2;

		cout<<"������������������"<<endl;
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
	
	cout<<"����ƽ��ĵ�λ������Ϊ:("<<fXx/sqrt(fXx*fXx+fYy*fYy+fZz*fZz)<<","<<fYy/sqrt(fXx*fXx+fYy*fYy+fZz*fZz)<<","<<fZz/sqrt(fXx*fXx+fYy*fYy+fZz*fZz)<<")"<<endl;
}

/*
*�������ã���ƽ��ĵ�λ������
*�޲�
*�޷���ֵ 
*/
void PPP(){
	cout<<"ֱ�ߵ�һ�㷽��ΪAx+By+Cz+D=0"<<endl;
	cout<<"������ƽ��һ�㷽�̵Ĳ���"<<endl;
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
	
	cout<<"����ֱ�ߵĵ�λ������Ϊ:("<<fA/sqrt(fA*fA+fB*fB+fC*fC)<<","<<fB/sqrt(fA*fA+fB*fB+fC*fC)<<","<<fC/sqrt(fA*fA+fB*fB+fC*fC)<<")"<<endl;
}

/*
*�������ã�����ƽ��
*�޲�
*�޷���ֵ 
*/
void crtP(){
	cout<<"1.����ȷ��ƽ��"<<endl;
	cout<<"2.ƽ���һ�㷽��"<<endl;
	cout<<"���������ѡ��:";
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
*�������ã���ֱ�ߵĵ�λ����
*�޲�
*�޷���ֵ 
*/
void Ll(){
	cout<<"ֱ�ߵ�һ�㷽��ΪAx+By+Cz+D=0"<<endl;
	cout<<"�������һ��ƽ��һ�㷽�̵Ĳ���"<<endl;
	float fA1,fB1,fC1,fD1;
	cout<<"A:";
	cin>>fA1;
	cout<<"B:";
	cin>>fB1;
	cout<<"C:";
	cin>>fC1;
	cout<<"D:";
	cin>>fD1;
	
	cout<<"������ڶ���ƽ��һ�㷽�̵Ĳ���"<<endl;
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
	
	cout<<"����ֱ�ߵĵ�λ��������Ϊ:("<<fM/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fN/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fP/sqrt(fM*fM+fN*fN+fP*fP)<<")"<<endl;
}

void LL(){
	float fX1,fX2,fY1,fY2,fZ1,fZ2;
	cout<<"�������һ���������"<<endl;
		cout<<"X:";
		cin>>fX1;
		cout<<"Y:";
		cin>>fY1;
		cout<<"Z:";
		cin>>fZ1;
		
		cout<<"������ڶ����������"<<endl;
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
		
		cout<<"����ֱ�ߵĵ�λ��������Ϊ:("<<fM/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fN/sqrt(fM*fM+fN*fN+fP*fP)<<","<<fP/sqrt(fM*fM+fN*fN+fP*fP)<<")"<<endl;
}

/*
*�������ã�����ֱ�� 
*�޲�
*�޷���ֵ 
*/
void crtL(){
	cout<<"1.��ƽ���ཻȷ��ֱ��"<<endl;
	cout<<"2.����ȷ��ֱ��"<<endl;
	cout<<"���������ѡ��:";
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
				cout<<"�������˳�";
				exit(0);
		}
	}
}

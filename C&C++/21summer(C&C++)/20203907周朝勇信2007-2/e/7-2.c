int main(){
	int iBt,iPt;	//记录不同的时间
	scanf("%d%d",&iBt,&iPt);
	int iNth,iNtm,iNt;
	int iPth,iPtm;
	iPth=iPt/60;
	iPtm=iPt%60;
	iNth=iBt/100+iPth;
	iNtm=iBt%100+iPtm;
	if(iNtm>=60){
		iNtm-=60;
		iNth++;
	}
	if(iNtm<0){
		iNtm+=60;
		iNth--;
	}
	iNt=iNth*100+iNtm;
    if(iNt/100==0){
		printf("0%d",iNt);
		return 0;
	} 
	printf("%d",iNt);
	return 0;
}

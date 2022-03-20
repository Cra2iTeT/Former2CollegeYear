#include<iostream>
using namespace std;

int const monthDay[12]={31,28,31,30,31,30,31,31,30,31,30,31};
char* const weekName[7]={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
char* const monthName[12]={"Jan","Feb","Mar","Api","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

class Date{
	int year,month,day;
	int isleapYear(){		//determine year leap or not
		if((year%4 == 0&&year%100 != 0)||year%400 == 0)
			return 1;
		else	return 0;
	}
	public:
		void setYear(int ); 
		int getYear();		//return set year
		void setMonth(int );
		int getMonth();		//return set month
		void setDay(int );
		int getday();		//return set day
		void tomorrow();
		void yesterday();		//plus subtract day
		void printMonthCalendar();		//print calendar
		void chineseFormat();
		void americaformat();		//return chinese time
		int weekDay();		//return what time today
		Date(int y = 0,int m = 0,int d = 0){
			cout<<"Constructor run"<<endl;
		}
		Date(Date &t){
			cout<<"CopyConstructor run"<<endl;
			year = t.year;
			month = t.month;
			day = t.day;
		}
		~Date(){
			cout<<"Destructor run"<<endl;
		}
};

void Date::setYear(int y){
	year = y;
}
int Date::getYear(){
	return year;
}

void Date::setMonth(int m){
	month = m;
}
int Date::getMonth(){
	return month;
}

void Date::setDay(int d){
	day = d;
}
int Date::getday(){
	return day;
}

void Date::tomorrow(){
	day+=1;
	int y = Date::isleapYear();
	int m = month;
	if(y){
		if(m==2){
			if(day>29){
				month++;
				day = 1;
			}
		}
		if(m==12){
			if(day>31){
				month = 1;
				day = 1;
				year++;
			}
		}
		else{
			if(day>monthDay[m-1]){
				month++;
				day = 1;
			}
		}
	}
	else{
		if(m==12){
			if(day>31){
				month = 1;
				day = 1;
				year++;
			}
		}
		else{
			if(day>monthDay[m-1]){
				month++;
				day = 1;
			}
		}	
	}
}
void Date::yesterday(){
	day--;
	int m = month;
	int y = Date::isleapYear();
	if(y){
		if(m==3){
			if(day<1){
				month--;
				day = 29;
			}
		}
		if(m==1){
			if(day<1){
				day = 31;
				month = 12;
				year--;
			}
		}
		else{
			if(day<1){
				month--;
				day = monthDay[m-1];
			}
		}
	}
	else{
		if(m==1){
			if(day<1){
				day = 31;
				month = 12;
				year--;
			}
		}
		else{
			if(day>monthDay[m-1]){
				month++;
				day = 1;
			}
		}
	}
}

void Date::chineseFormat(){
	cout<<year<<"Äê"<<month<<"ÔÂ"<<day<<"ÈÕ"<<endl; 
}
void Date::americaformat(){
	cout<<monthName[month-1]<<" "<<day<<","<<year<<endl;
}

void Date::printMonthCalendar(){
	cout<<"SunMonTueWedThuFriSat"<<endl;
	int count,i,n;
	n = weekDay()-(day-1);
	if(n<0) n+=7;
	int y = Date::isleapYear();
	int amont = month-1;
	if(amont==1){
		if(y){
			amont=29;
		}
	}
	else	amont = monthDay[amont];
	for(i = 0;i<n;i++)
		cout<<" "<<" "<<" ";
	for(i = 1,count = n;i<=amont;i++){
		count++;
		cout.width(3);
		cout<<i;
		if(count == 7){
			cout<<endl;
			count = 0;
		}
	}
	cout<<endl;
}

int Date::weekDay(){
	int m,y1;
	m=getMonth();
	y1=getYear();
	if(m<3){
		y1 -= 1;
		m += 12;
	}
	int c = int (y1/100),y=y1-100*c;
	int w = int (c/4)-2*c+y+int (y/4)+(26*(m+1)/10)+day-1;
	w=(w%7+7)%7;
	return w;
}

int main(){
    int year,month,day;
    Date d1;
    Date d2(d1);
    cin>>year>>month>>day;
    d1.setYear(year);
    d1.setMonth(month);
    d1.setDay(day);
    d1.yesterday();
    d1.chineseFormat();
    cin>>year>>month>>day;
    d2.setYear(year);
    d2.setMonth(month);
    d2.setDay(day);
    d2.tomorrow();
    d2.americaformat();
    d2.printMonthCalendar();
    return 0;
}

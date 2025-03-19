#pragma once

class Date
{
private:
	int _day;
	int _month;
	int _year;

public:
	Date()
	{
		this->_day = 1;
		this->_month = 1;
		this->_year = 1999;
	}

	Date(int day, int month, int year);
	Date(const Date& date);

public :
	int getDay() const;
	void setDay(int value);
	int getMonth() const;
	void setMonth(int value);
	int getYear() const;
	void setYear(int value);

public:
	string Show() const;
};


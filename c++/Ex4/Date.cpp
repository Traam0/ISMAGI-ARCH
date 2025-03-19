#include "Date.h"
#include <iostream>;
#include <string>;

using namespace std;

int Date::getDay() const {
	return this->_day;
}

int Date::getMonth() const {
	return this->_month;
}

int Date::getYear() const {
	return this->_year;
}

void Date::setDay(int value){
	if (value < 0 || value > 31) {
		throw new std::exception(" Invalide day => 0 < value <= 31");
	}
	this->_day = value;
}

void Date::setMonth(int value) {
	if (value < 0 || value > 12) {
		throw new std::exception(" Invalide month => 0 < value <= 12");

	}
	this->_month = value;
}

void Date::setYear(int value) {
	if (value < 0) {
		throw new exception(" year must be positive");

	}
	this->_year = value;
}

string Date::Show() const {
	string months[12] = {
		"january", "february", "march", "april", "may", "june",
		"july", "august", "september", "october", "november", "december"
	};
	
	return  this->_day + " " + months[this->_month - 1] + " " + to_string(this->_year);
}

Date::Date(int day, int month, int year) {
	this->setDay(day);
	this->setMonth(month);
	this->setYear(year);
}

Date::Date(const Date& date) {
	this->setDay(date.getDay());
	this->setMonth(date.getMonth());
	this->setYear(date.getYear());
}


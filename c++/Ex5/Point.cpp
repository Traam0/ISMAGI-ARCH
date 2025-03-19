#include "Point.h"
#include <iostream>

using namespace std;

int Point::getX() const {
	return this->_x;
}

int Point::getY() const {
	return this->_y;
}


void Point::setX(int value) {
	this->_x = value;
}

void Point::setY(int value) {
	this->_y = value;
}

void Point::Show() const {
	cout << "Abcisse et ordonnee du point  sont : [" << this->_x << "," << this->_y << "].";
}


Point::Point(int x, int y) {
	this->_x = x;
	this->_y = y;
}

Point::Point(const Point& point) {
	this->setX(point.getX());
	this->setY(point.getY());
}
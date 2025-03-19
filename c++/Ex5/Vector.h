#pragma once
#include "Point.h"
class Vector
{
private:
	Point _p1;
	Point _p2;

public: 
	Vector() {
		this->_p1 = Point();
		this->_p2 = Point();
	}
	
	Vector(const Point& p1, const Point& p2);
	Vector(const Vector& vector);

public: 
	Point getP1() const;
	void setP1(const Point& p1);
	Point getP2() const;
	void setP2(const Point& p2);

public:
	double CalculateNorm() const;
};
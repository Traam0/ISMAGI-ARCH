#pragma once
class Point
{
private:
	int _x;
	int _y;

public:
	Point() {
		this->_x = 0;
		this->_y = 0;
	}

	Point(int x, int y);
	Point(const Point& vector);

public:
	int getX() const;
	void setX(int value);
	int getY() const;
	void setY(int value);

public:
	void Show() const;
};


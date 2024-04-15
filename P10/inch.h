#ifndef __INCH_H
#define __INCH_H

#include <iostream>

class Inch{
private:
    int _whole;
    int _numerator;
    int _denominator;
    void validate();
    int compare(const Inch& rhs);
public:
    Inch();
    Inch(int whole, int numerator, int denominator);
    Inch operator+(const Inch& rhs);
    inline bool operator==(const Inch& rhs) {return compare(rhs) == 0;}
    inline bool operator!=(const Inch& rhs) {return compare(rhs) != 0;}
    inline bool operator<(const Inch& rhs) {return compare(rhs) < 0;}
    inline bool operator<=(const Inch& rhs) {return compare(rhs) <= 0;}
    inline bool operator>(const Inch& rhs) {return compare(rhs) > 0;}
    inline bool operator>=(const Inch& rhs) {return compare(rhs) >= 0;}

    friend std::ostream& operator<<(std::ostream& ost, const Inch& inch);
    friend std::istream& operator>>(std::istream& ist, Inch& inch);
};

#endif
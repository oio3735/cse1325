#include "inch.h"
#include <iostream>
#include <algorithm>
#include <stdexcept>
#include <numeric>

Inch::Inch() : Inch(0, 0, 2){}

Inch::Inch(int whole, int numerator, int denominator)
    : _whole{whole}, _numerator{numerator}, _denominator{denominator}{
        validate();
    }

Inch Inch::operator+(const Inch& rhs){
   int lcm = 64;
    int this_numerator = (_whole * 64 + _numerator * 64 / _denominator);
    int rhs_numerator = (rhs._whole * 64 + rhs._numerator * 64 / rhs._denominator);

    // Add the numerators together
    int new_numerator = this_numerator + rhs_numerator;

    // Reduce the fraction as needed
    int new_whole = new_numerator / lcm;
    new_numerator = new_numerator % lcm;

    return Inch(new_whole, new_numerator, lcm);

}

std::ostream& operator<<(std::ostream& os, const Inch& inch){
    os << inch._whole << " " << inch._numerator << "/" << inch._denominator;
    return os;
}

std::istream& operator>>(std::istream& is, Inch& inch){
    char slash = '/';
    is >> inch._whole >> inch._numerator >> slash >> inch._denominator;
    inch.validate();
    return is;
}

int Inch::compare(const Inch& rhs) const{
    double this_value = static_cast<double>(_whole) + static_cast<double>(_numerator) / _denominator;
    double rhs_value = static_cast<double>(rhs._whole) + static_cast<double>(rhs._numerator) / rhs._denominator;
    if (this_value < rhs_value) return -1;
    if (this_value > rhs_value) return 1;
    return 0;
}

void Inch::validate() {
    if (_denominator != 2 && _denominator != 4 && _denominator != 8 &&
        _denominator != 16 && _denominator != 32 && _denominator != 64) {
        throw std::invalid_argument("Denominator must be 2, 4, 8, 16, 32, or 64");
    }

    // Normalize the fraction
    _whole += _numerator / _denominator;
    _numerator %= _denominator;

    // Reduce the fraction
    int gcd = std::gcd(_numerator, _denominator);
    _numerator /= gcd;
    _denominator /= gcd;
}



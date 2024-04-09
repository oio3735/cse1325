#include "quadratic.h"
#include <cmath>
#include <stdexcept>
#include <iostream>

Quadratic::Quadratic(const std::vector<double>& coefficients) : Polynomial(){
    if(coefficients.size() != 3 || coefficients[0] == 0)
        throw std::runtime_error("a may not be 0");
        _coefficients = coefficients;
}   

void Quadratic::solve() const{
    double a = _coefficients[0];
    double b = _coefficients[1];
    double c = _coefficients[2];
    double numerator = b * b - 4 * a * c;

    if(numerator < 0)
        throw std::runtime_error("No real roots!");

    double root1 = (-b + sqrt(numerator)) / (2 * a);
    double root2 = (-b - sqrt(numerator)) / (2 * a);
    std::cout << "Roots of quadratic polynomial: " << root1 << " and " << root2 << std::endl;
}
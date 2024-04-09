#include "linear.h"
#include <stdexcept>
#include <iostream>

Linear::Linear(const std::vector<double>& coefficients) : Polynomial() {
    if(coefficients.size() != 2 || coefficients[0] == 0)
        throw std::runtime_error("a may not be e0");
    _coefficients = coefficients;
}

void Linear::solve() const{
    double a = _coefficients[0];
    double b = _coefficients[1];
    double root = -b / a;
    std::cout << "Root of linear polynomal: " << root << std::endl;

}
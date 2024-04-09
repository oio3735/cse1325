#ifndef __POLYNOMIAL_H
#define __POLYNOMIAL_H

#include <vector>

class Polynomial{
protected:
    std::vector<double> _coefficients;

public:
    Polynomial() : _coefficients() {}
    virtual ~Polynomial() {}

    virtual void solve() const = 0;
};

#endif


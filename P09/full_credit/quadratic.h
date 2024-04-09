#ifndef __QUADRATIC_H
#define __QUADRATIC_H

#include "polynomial.h"

class Quadratic : public Polynomial{
public:
    Quadratic(const std::vector<double>& coefficients);
    void solve() const override;
};

#endif
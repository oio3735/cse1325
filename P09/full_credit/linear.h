#ifndef __LINEAR_H
#define __LINEAR_H

#include "polynomial.h"

class Linear : public Polynomial {
public: 
    Linear(const std::vector<double>& coefficients);
    void solve() const override;
};

#endif


#include "polynomial.h"
#include "linear.h"
#include "quadratic.h"
#include <iostream>
#include <stdexcept>

int main(int argc, char* argv[]) {
    if (argc != 3 && argc != 4) {
        std::cerr << "Invalid polynomial size - must be linear or quadratic" << std::endl;
        return -1;
    }

    std::vector<double> coefficients;
    for (int i = 1; i < argc; ++i) {
        coefficients.push_back(std::stod(argv[i]));
    }

    Polynomial* p;

    if (argc == 3)
        p = new Linear(coefficients);
    else
        p = new Quadratic(coefficients);

    try {
        p->solve();
    } catch (const std::runtime_error& e) {
        std::cerr << e.what() << std::endl;
    }

    delete p;

    return 0;
}
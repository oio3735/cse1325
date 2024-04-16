#include <iostream>
#include "inch.h"

int main(){
    Inch in, last_in, sum;
    while (std::cin.good()) {
        
        std::cout << "Enter an Inch value: ";
        std::cin >> in;
 
        sum = sum + in;

        std::cout << "You entered: " << in << std::endl;

        std::cout << "Comparison with last entry: ";
        if (in == last_in) {
            std::cout << "== ";
        } else {
            std::cout << "!= ";
        }
        if (in > last_in) {
            std::cout << "> ";
        } else {
            std::cout << "<= ";
        }
        if (in >= last_in) {
            std::cout << ">= ";
        } else {
            std::cout << "< ";
        }
        std::cout << std::endl;

        std::cout << "Running total: " << sum << std::endl;

        last_in = in;
    }

    return 0;
}

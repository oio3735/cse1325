#include <iostream>
#include "inch.h" // Include the Inch class header file

int main() {
    Inch in, last_in, sum;

    while (std::cin.good()) {
        // Read an Inch object into 'in'
        std::cout << "Enter an Inch value (format: whole numerator/denominator): ";
        std::cin >> in;

        // Add it to sum using the + operator
        sum = sum + in;

        // Print the inches just entered
        std::cout << "You entered: " << in << std::endl;

        // Compare with last entry
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

        // Print the running total in sum
        std::cout << "Running total: " << sum << std::endl;

        // Update last_in to the value in in
        last_in = in;
    }

    return 0;
}
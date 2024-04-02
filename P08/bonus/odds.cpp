#include <iostream>
#include <vector>
#include <string>

int main(int argc, char* argv[]) {
    std::vector<std::string> odds;
    std::vector<std::string>* evens = new std::vector<std::string>();
    
    for (int i = 1; i < argc; ++i) {
        std::string arg = argv[i];
        if (arg.length() % 2 == 1) {
            odds.push_back(arg);
        } else {
            evens->push_back(arg);
        }
    }

    std::cout << "Odd lengths:" << std::endl;
    for (auto odd : odds) {
        std::cout << odd << std::endl;
    }

    std::cout << "Even lengths:" << std::endl;
    for (auto even : *evens) {
        std::cout << even << std::endl;
    }


    delete evens; // Deallocate memory allocated on the heap

    return 0;
}
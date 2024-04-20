#include "university.h"
#include <iostream>
#include <vector>
#include <fstream>
#include <map>

typedef std::string State;
typedef std::vector<University> Universities;

int main(int argc, char* argv[]){
   if(argc != 2){
    std::cerr << "Usage: " << argv[0] << "<input_file" << std::endl;
    return -1;
   } 
   std::ifstream input_file(argv[1]);
   if(!input_file){
    std::cerr << argv[1] << ": file not found" << std::endl;
    return -2;
   }
    std::map<State, Universities> universities_map; // Corrected type
    State state;
    University university;

    while (input_file >> state >> university) {
    if (universities_map.find(state) == universities_map.end()) {
        universities_map[state] = Universities(); // Corrected usage
    }
    universities_map[state].push_back(university);
    }
    std::string state_abbreviation;
    while (true) {
        
        std::cout << "Enter a 2-character state abbreviation (or empty to exit): ";
        std::getline(std::cin, state_abbreviation);
        if (state_abbreviation.empty()) {
            break;
        }

        auto it = universities_map.find(state_abbreviation);
        if (it == universities_map.end()) {
            
            std::cout << "No universities found in " << state_abbreviation << std::endl;
        } else {
           
            std::cout << "Universities in " << state_abbreviation << ":" << std::endl;
            for (const auto& university : it->second) {
                std::cout << university << std::endl;
            }
        }
    }

    return 0;
}


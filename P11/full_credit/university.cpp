#include "university.h"
#include <iostream>
#include <vector>

University::University(std::string _name, int _enrollment)
    : _name{_name}, _enrollment{_enrollment} {
    validate();
}

std::string University::name() const{
    return _name;
}

int University::enrollment() const{
    return _enrollment;
}

std::istream& operator>>(std::istream& ist, University& reading){
    std::getline(ist, reading._name);
    ist >> reading._enrollment;
    ist.ignore();
    reading.validate();
    return ist;
}

std::ostream& operator<<(std::ostream& ost, const University& reading){
    ost << "has an enrollment of " << reading._enrollment; 
    return ost;
}

void University::validate(){
    if(_enrollment < 0){
        throw std::invalid_argument("University enrollment cannot be negative");
    }
    if(_enrollment > 0 &&  _name.empty()){
        throw std::invalid_argument("University cannot be anonymous");
    }

}


#ifndef __UNIVERSITY_H
#define __UNIVERSITY_H

#include <iostream>
#include <string>
#include <istream>
#include <ostream>
#include <vector>

class University {
  public:
    University(std::string _name = "", int _enrollment = 0);
    std::string name() const;
    int enrollment() const;
    friend std::istream& operator>>(std::istream& ist, University& reading);
    friend std::ostream& operator<<(std::ostream& ost, const University& reading);
  private:
    std::string _name;
    int _enrollment;
    void validate();
};

#endif

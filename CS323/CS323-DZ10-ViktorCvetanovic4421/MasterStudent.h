#ifndef MASTERSTUDENT_H
#define MASTERSTUDENT_H

#include "Student.h"
#include <string>

class MasterStudent : public Student {
private:
    std::string mentorName;

public:
    MasterStudent(const std::string& firstName, const std::string& lastName, int studentIndex, const std::string& mentorName);

    void info() const;
};

#endif // MASTERSTUDENT_H

#ifndef STUDENT_H
#define STUDENT_H

#include <string>

class Student {
private:
    std::string firstName;
    std::string lastName;
    int studentIndex;

public:
    Student(const std::string& firstName, const std::string& lastName, int studentIndex);

    void info() const;
};

#endif // STUDENT_H

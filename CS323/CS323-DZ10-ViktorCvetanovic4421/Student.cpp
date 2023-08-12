#include "Student.h"
#include <iostream>

Student::Student(const std::string& firstName, const std::string& lastName, int studentIndex)
    : firstName(firstName), lastName(lastName), studentIndex(studentIndex) {}

void Student::info() const {
    std::cout << "Ja sam student: " << firstName << " " << lastName << ", Indeks: " << studentIndex << "\n";
}

#include "MasterStudent.h"
#include <iostream>

MasterStudent::MasterStudent(const std::string& firstName, const std::string& lastName, int studentIndex, const std::string& mentorName)
    : Student(firstName, lastName, studentIndex), mentorName(mentorName) {}

void MasterStudent::info() const {
    Student::info(); // Pozivamo baznu klasu info() metodu
    std::cout << "Moj mentor je: " << mentorName << "\n";
}


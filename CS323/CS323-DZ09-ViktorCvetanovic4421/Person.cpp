#include "Person.h"

int Person::numberOfObjects = 0;

Person::Person(const std::string& name, const std::string& address, const std::string& birthDate)
    : name(name), address(address), birthDate(birthDate) {
    numberOfObjects++;
}

Person::~Person() {
    numberOfObjects--;
}

int Person::getNumberOfObjects() {
    return numberOfObjects;
}

bool Person::operator<(const Person& other) const {
    // Implement your comparison logic here
    // For the purpose of this example, let's assume birthDate is in the format "dd.mm.yy"
    return birthDate < other.birthDate;
}

bool Person::operator>(const Person& other) const {
    // Implement your comparison logic here
    return birthDate > other.birthDate;
}

bool Person::operator==(const Person& other) const {
    // Implement your comparison logic here
    return birthDate == other.birthDate;
}

std::istream& operator>>(std::istream& is, Person& person) {
    // Implement input operator
    is >> person.name >> person.address >> person.birthDate;
    return is;
}

std::ostream& operator<<(std::ostream& os, const Person& person) {
    // Implement output operator
    os << "Name: " << person.name << ", Address: " << person.address << ", Birth Date: " << person.birthDate;
    return os;
}

const std::string& Person::getBirthDate() const {
    return birthDate;
}

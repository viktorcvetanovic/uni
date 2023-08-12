#ifndef PERSON_H
#define PERSON_H

#include <string>
#include <iostream>

class Person {
private:
    std::string name;
    std::string address;
    std::string birthDate;

    static int numberOfObjects;

public:
    Person(const std::string& name, const std::string& address, const std::string& birthDate);
    Person();

    static int getNumberOfObjects();

    bool operator<(const Person& other) const;
    bool operator>(const Person& other) const;
    bool operator==(const Person& other) const;

    friend std::istream& operator>>(std::istream& is, Person& person);
    friend std::ostream& operator<<(std::ostream& os, const Person& person);
    const std::string& getBirthDate() const;
};

#endif // PERSON_H

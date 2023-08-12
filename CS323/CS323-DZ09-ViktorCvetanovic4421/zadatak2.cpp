#include <iostream>
#include <vector>
#include "Person.h"

int main() {
    std::vector<Person> people;
    int n;

    std::cout << "Enter the number of people: ";
    std::cin >> n;

    for (int i = 0; i < n; i++) {
        Person person;
        std::cin >> person;
        people.push_back(person);
    }

    // Find and print the youngest person born under the sign of Cancer (June 21 - July 21)
    Person youngestCancer;
    for (const Person& person : people) {
        if (person.getBirthDate() >= "21.06" && person.getBirthDate() <= "21.07") {
            if (youngestCancer.getBirthDate().empty() || person < youngestCancer) {
                youngestCancer = person;
            }
        }
    }

    if (!youngestCancer.getBirthDate().empty()) {
        std::cout << "Youngest person born under the sign of Cancer:\n";
        std::cout << youngestCancer << "\n";
    } else {
        std::cout << "No person born under the sign of Cancer found.\n";
    }

    std::cout << "Number of created objects: " << Person::getNumberOfObjects() << "\n";

    return 0;
}

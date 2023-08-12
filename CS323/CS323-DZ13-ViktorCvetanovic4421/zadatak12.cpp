#include <iostream>
#include "Posiljka.h"

int main() {
    try {
        Posiljka posiljka("John Doe", 2.5, "Sample Street 123", "Sample Town", "12345", "555-1234");
        std::cout << "Posiljka kreirana.\n";
    } catch (const AdresaNijeValidnaException& e) {
        std::cerr << "Greska: " << e.what() << "\n";
    }

    try {
        Posiljka posiljka("Jane Smith", 3.2, "Invalid Address", "Invalid City", "67890", "555-5678");
        std::cout << "Posiljka kreirana.\n";
    } catch (const AdresaNijeValidnaException& e) {
        std::cerr << "Greska: " << e.what() << "\n";
    }

    return 0;
}

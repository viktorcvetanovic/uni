#include <stdexcept>
#include <string>

class AdresaNijeValidnaException : public std::exception {
private:
    std::string message;

public:
    AdresaNijeValidnaException(const std::string& adr) : message("Adresa nije validna: " + adr) {}

    const char* what() const noexcept override {
        return message.c_str();
    }
};

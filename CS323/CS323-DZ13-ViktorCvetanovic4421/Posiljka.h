#ifndef POSILJKA_H
#define POSILJKA_H

#include <string>
#include "AdresaNijeValidnaException.h"

class Posiljka {
private:
    std::string ime;
    double tezina;
    std::string adresa;
    std::string grad;
    std::string postanskiBroj;
    std::string brojTelefona;

public:
    Posiljka(const std::string& ime, double tezina, const std::string& adresa, const std::string& grad, const std::string& postanskiBroj, const std::string& brojTelefona);

    const std::string& getAdresa() const;
};

#endif // POSILJKA_H

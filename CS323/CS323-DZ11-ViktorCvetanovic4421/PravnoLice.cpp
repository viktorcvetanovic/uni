#include "PravnoLice.h"
#include <iostream>

PravnoLice::PravnoLice(const std::string& ime, const std::string& prezime, const std::string& adresa, const std::string& brojTelefona, const std::string& pib)
    : Lice(ime, prezime, adresa, brojTelefona), pib(pib) {}

void PravnoLice::Info() const {
    std::cout << "Pravno lice: " << ime << " " << prezime << ", Adresa: " << adresa << ", Telefon: " << brojTelefona << ", PIB: " << pib << "\n";
}

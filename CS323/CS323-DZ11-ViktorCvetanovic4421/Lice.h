#ifndef LICE_H
#define LICE_H

#include <string>

class Lice {
protected:
    std::string ime;
    std::string prezime;
    std::string adresa;
    std::string brojTelefona;

public:
    Lice(const std::string& ime, const std::string& prezime, const std::string& adresa, const std::string& brojTelefona);
    virtual ~Lice();

    virtual void Info() const = 0; // Čisto virtuelna funkcija
};

#endif // LICE_H

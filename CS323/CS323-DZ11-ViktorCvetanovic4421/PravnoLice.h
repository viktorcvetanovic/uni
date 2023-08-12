#ifndef PRAVNOLICE_H
#define PRAVNOLICE_H

#include "Lice.h"

class PravnoLice : public Lice {
private:
    std::string pib;

public:
    PravnoLice(const std::string& ime, const std::string& prezime, const std::string& adresa, const std::string& brojTelefona, const std::string& pib);

    void Info() const override;
};

#endif // PRAVNOLICE_H

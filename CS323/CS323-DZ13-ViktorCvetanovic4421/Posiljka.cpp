#include "Posiljka.h"

Posiljka::Posiljka(const std::string& ime, double tezina, const std::string& adresa, const std::string& grad, const std::string& postanskiBroj, const std::string& brojTelefona)
    : ime(ime), tezina(tezina), adresa(adresa), grad(grad), postanskiBroj(postanskiBroj), brojTelefona(brojTelefona) {
    if (adresa.empty() || !isdigit(adresa.back())) {
        throw AdresaNijeValidnaException(adresa);
    }
}

const std::string& Posiljka::getAdresa() const {
    return adresa;
}

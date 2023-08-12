#include "ImeKlase.h"
#include <cmath>
#include <iostream>

KompleksniBroj::KompleksniBroj() : realni(0.0), imaginarni(0.0) {}

KompleksniBroj::KompleksniBroj(double re, double im) : realni(re), imaginarni(im) {}

KompleksniBroj::KompleksniBroj(const KompleksniBroj& other) : realni(other.realni), imaginarni(other.imaginarni) {}

double KompleksniBroj::getRealni() const {
    return realni;
}

double KompleksniBroj::getImaginarni() const {
    return imaginarni;
}

double KompleksniBroj::moduo() const {
    return std::sqrt(realni * realni + imaginarni * imaginarni);
}

KompleksniBroj KompleksniBroj::konjugovano() const {
    return KompleksniBroj(realni, -imaginarni);
}

KompleksniBroj KompleksniBroj::operator+(const KompleksniBroj& other) const {
    return KompleksniBroj(realni + other.realni, imaginarni + other.imaginarni);
}

KompleksniBroj KompleksniBroj::operator-(const KompleksniBroj& other) const {
    return KompleksniBroj(realni - other.realni, imaginarni - other.imaginarni);
}

KompleksniBroj KompleksniBroj::operator*(const KompleksniBroj& other) const {
    return KompleksniBroj(realni * other.realni - imaginarni * other.imaginarni,
                          realni * other.imaginarni + imaginarni * other.realni);
}

KompleksniBroj::~KompleksniBroj() {
    std::cout << "Objekat je unisten" << std::endl;
}

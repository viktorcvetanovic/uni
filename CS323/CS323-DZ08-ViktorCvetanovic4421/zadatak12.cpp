#include <iostream>
#include "ImeKlase.h"

int main() {
    KompleksniBroj z(3.0, 4.0);
    KompleksniBroj w(1.0, 2.0);

    KompleksniBroj sabirak = z + w;
    KompleksniBroj razlika = z - w;
    KompleksniBroj proizvod = z * w;

    std::cout << "Sabirak: " << sabirak.getRealni() << " + " << sabirak.getImaginarni() << "i\n";
    std::cout << "Razlika: " << razlika.getRealni() << " + " << razlika.getImaginarni() << "i\n";
    std::cout << "Proizvod: " << proizvod.getRealni() << " + " << proizvod.getImaginarni() << "i\n";

    std::cout << "Moduo kompleksnog broja z: " << z.moduo() << std::endl;
    std::cout << "Konjugovano kompleksni broj z: " << z.konjugovano().getRealni() << " + " << z.konjugovano().getImaginarni() << "i\n";

    return 0;
}

#ifndef IMEKLASE_H
#define IMEKLASE_H

class KompleksniBroj {
private:
    double realni;
    double imaginarni;

public:
    KompleksniBroj();
    KompleksniBroj(double re, double im);
    KompleksniBroj(const KompleksniBroj& other);

    double getRealni() const;
    double getImaginarni() const;

    double moduo() const;
    KompleksniBroj konjugovano() const;

    KompleksniBroj operator+(const KompleksniBroj& other) const;
    KompleksniBroj operator-(const KompleksniBroj& other) const;
    KompleksniBroj operator*(const KompleksniBroj& other) const;

    ~KompleksniBroj();
};

#endif

#include <iostream>
#include <iomanip>
#include <cmath>

const double PI = 3.141592;

class Valjak {
private:
    double r; // Poluprečnik osnove
    double H; // Visina
public:
    Valjak(double poluprecnik, double visina) : r(poluprecnik), H(visina) {}

    double B() const {
        return PI * r * r;
    }

    double M() const {
        return 2 * PI * r * H;
    }

    double P() const {
        return 2 * B() + M();
    }

    double V() const {
        return B() * H;
    }

    void prikaziPoruku() const {
        std::cout << "B = " << std::setw(10) << B() << " cm2, "
                  << "M = " << std::setw(10) << M() << " cm2,\n"
                  << "P = 2B + M = " << std::setw(10) << P() << " cm2\n"
                  << "V = B * H = " << std::setw(10) << B() << " * " << std::setw(10) << H << " = " << V() << " cm3" << std::endl;
    }
};

int main() {
    double r, H;

    std::cout << "Unesite poluprečnik osnove valjka (r): ";
    std::cin >> r;

    std::cout << "Unesite visinu valjka (H): ";
    std::cin >> H;

    Valjak valjak(r, H);

    std::cout << std::setprecision(2) << std::fixed;
    valjak.prikaziPoruku();

    return 0;
}

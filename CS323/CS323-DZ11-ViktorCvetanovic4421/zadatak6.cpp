#include "Lice.h"
#include "PravnoLice.h"

int main() {
    Lice* osoba; // Pointer na baznu klasu

    PravnoLice pravnoLice("Firma XYZ", "Beograd", "Ulica 123", "011-123-456", "123456789");

    osoba = &pravnoLice; // Pokazivač na pravno lice

    osoba->Info(); // Poziv čisto virtuelne funkcije

    return 0;
}

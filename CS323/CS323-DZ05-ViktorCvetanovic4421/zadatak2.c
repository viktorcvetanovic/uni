#include <stdio.h>
#include <string.h>

struct Osoba {
    char ime[50];
    char adresa[100];
    char datumRodjenja[9]; // Format dd.mm.yy
};

int main() {
    int n;

    printf("Unesite broj osoba: ");
    scanf("%d", &n);

    struct Osoba osobe[n];

    // Unos podataka za svaku osobu
    for (int i = 0; i < n; i++) {
        printf("Osoba %d:\n", i + 1);
        printf("Ime: ");
        scanf(" %s", osobe[i].ime);
        printf("Adresa: ");
        scanf(" %[^\n]s", osobe[i].adresa);
        printf("Datum rodjenja (dd.mm.yy): ");
        scanf(" %s", osobe[i].datumRodjenja);
    }

    // Pronalaženje najstarije osobe rođene u znaku Raka
    char najstarijaRak[9] = "21.06.00"; // Početna vrednost za upoređivanje
    char datumRakaStart[9] = "21.06.00";
    char datumRakaEnd[9] = "21.07.00";
    int indeksNajstarijeRak = -1;

    for (int i = 0; i < n; i++) {
        if (strcmp(osobe[i].datumRodjenja, datumRakaStart) >= 0 &&
            strcmp(osobe[i].datumRodjenja, datumRakaEnd) <= 0 &&
            strcmp(osobe[i].datumRodjenja, najstarijaRak) < 0) {
            strcpy(najstarijaRak, osobe[i].datumRodjenja);
            indeksNajstarijeRak = i;
        }
    }

    // Ispis rezultata
    if (indeksNajstarijeRak != -1) {
        printf("Najstarija osoba rođena u znaku Raka:\n");
        printf("Ime: %s\n", osobe[indeksNajstarijeRak].ime);
        printf("Adresa: %s\n", osobe[indeksNajstarijeRak].adresa);
        printf("Datum rodjenja: %s\n", osobe[indeksNajstarijeRak].datumRodjenja);
    } else {
        printf("Nema osoba rođenih u znaku Raka.\n");
    }

    return 0;
}

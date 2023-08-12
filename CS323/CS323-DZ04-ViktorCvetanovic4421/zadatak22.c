#include <stdio.h>
#include <string.h>

void izbaciNuleSaPocetka(char *str) {
    int duzina = strlen(str);
    char *pok = str; // Pokazivač na početak stringa

    // Pomičemo pokazivač dok ne nađemo prvu nenultu cifru
    while (*pok == '0' && pok - str < duzina) {
        pok++;
    }

    // Pomeramo sve znakove unazad kako bismo izbacili nule na početku
    if (pok != str) {
        while (*pok != '\0') {
            *(pok - (pok - str)) = *pok;
            pok++;
        }
        *(pok - (pok - str)) = '\0';
    }
}

int main() {
    char tekst[] = "00012345";

    izbaciNuleSaPocetka(tekst);

    printf("Nakon izbacivanja nula: %s\n", tekst);

    return 0;
}

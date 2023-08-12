#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* izbaciKarakter(char *string, char c) {
    int duzina = strlen(string);
    int brojNepozeljenih = 0; // Brojač karaktera koje treba izbaciti

    // Prebrojavanje nepoželjenih karaktera
    for (int i = 0; i < duzina; i++) {
        if (string[i] == c) {
            brojNepozeljenih++;
        }
    }

    // Izračunavanje nove dužine stringa nakon izbacivanja karaktera
    int novaDuzina = duzina - brojNepozeljenih;

    // Alokacija memorije za novi string
    char *noviString = (char *)malloc((novaDuzina + 1) * sizeof(char));
    if (noviString == NULL) {
        perror("Greška prilikom alokacije memorije");
        exit(EXIT_FAILURE);
    }

    int j = 0; // Indeks za novi string
    for (int i = 0; i < duzina; i++) {
        if (string[i] != c) {
            noviString[j] = string[i];
            j++;
        }
    }
    noviString[j] = '\0'; // Postavljanje null terminatora na kraju novog stringa

    return noviString;
}

int main() {
    char unos[100];
    char karakter;

    printf("Unesite string: ");
    scanf(" %[^\n]s", unos);

    printf("Unesite karakter koji želite izbaciti: ");
    scanf(" %c", &karakter);

    char *noviString = izbaciKarakter(unos, karakter);

    printf("Novi string nakon izbacivanja karaktera '%c': %s\n", karakter, noviString);

    // Oslobađanje memorije alocirane za novi string
    free(noviString);

    return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    srand(time(NULL));

    int n;
    printf("Unesite broj elemenata niza A: ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Broj elemenata mora biti veći od 0.\n");
        return 1;
    }

    int A[n];
    int B[n], C[n]; // Pretpostavljamo maksimalnu veličinu nizova

    int brojB = 0; // Broj elemenata u nizu B
    int brojC = 0; // Broj elemenata u nizu C

    for (int i = 0; i < n; i++) {
        A[i] = rand() % 101; // Generisanje slučajnog broja u intervalu [0, 100]

        if (A[i] < 50) {
            B[brojB] = A[i];
            brojB++;
        } else {
            C[brojC] = A[i];
            brojC++;
        }
    }

    printf("Niz A: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", A[i]);
    }
    printf("\n");

    printf("Niz B: ");
    for (int i = 0; i < brojB; i++) {
        printf("%d ", B[i]);
    }
    printf("\n");

    printf("Niz C: ");
    for (int i = 0; i < brojC; i++) {
        printf("%d ", C[i]);
    }
    printf("\n");

    return 0;
}

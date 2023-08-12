#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, m;

    printf("Unesite broj redova (n): ");
    scanf("%d", &n);

    printf("Unesite broj kolona (m): ");
    scanf("%d", &m);

    // Alociranje memorije za matricu
    int **matrica = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++) {
        matrica[i] = (int *)malloc(m * sizeof(int));
    }

    // Popunjavanje matrice
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("Unesite element matrice [%d][%d]: ", i, j);
            scanf("%d", &matrica[i][j]);
        }
    }

    // Otvaranje datoteke za pisanje
    FILE *datoteka = fopen("matrica.txt", "w");
    if (datoteka == NULL) {
        perror("Greška pri otvaranju datoteke");
        return 1;
    }

    // Upisivanje dimenzija matrice u datoteku
    fprintf(datoteka, "%d %d\n", n, m);

    // Upisivanje elemenata matrice u datoteku
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            fprintf(datoteka, "%d ", matrica[i][j]);
        }
        fprintf(datoteka, "\n");
    }

    // Zatvaranje datoteke
    fclose(datoteka);

    // Oslobađanje memorije matrice
    for (int i = 0; i < n; i++) {
        free(matrica[i]);
    }
    free(matrica);

    printf("Matrica je upisana u datoteku 'matrica.txt'.\n");

    return 0;
}

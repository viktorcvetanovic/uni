#include <stdio.h>

double calculateSum(int n) {
    double sum = 1.0;

    for (int i = 2; i <= n; i++) {
        double term = 1.0 + (double)i * i / 2.0;
        sum *= term;
    }

    return sum;
}

int main() {
    int n;

    printf("Unesite vrednost n: ");
    scanf("%d", &n);

    if (n < 1) {
        printf("Vrednost n mora biti veća od 0.\n");
    } else {
        double result = calculateSum(n);
        printf("Rezultat sume je: %.2lf\n", result);
    }

    return 0;
}

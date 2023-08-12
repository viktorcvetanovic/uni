#include <stdio.h>

void minmax(int a, int b, int c, int *min, int *max) {
    if (a < b) {
        if (a < c) {
            *min = a;
            *max = (b > c) ? b : c;
        } else {
            *min = c;
            *max = b;
        }
    } else {
        if (b < c) {
            *min = b;
            *max = (a > c) ? a : c;
        } else {
            *min = c;
            *max = a;
        }
    }
}

int main() {
    int a, b, c;
    printf("Unesite tri broja: ");
    scanf("%d %d %d", &a, &b, &c);

    int min_val, max_val;
    minmax(a, b, c, &min_val, &max_val);

    printf("Minimum: %d\n", min_val);
    printf("Maksimum: %d\n", max_val);

    return 0;
}

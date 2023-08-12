#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {
    srand(time(NULL)); // Inicijalizacija generatora slučajnih brojeva

    int broj;
    int interval1 = 0; // Brojač za interval [1, 499]
    int interval2 = 0; // Brojač za interval [501, 1000]

    do {
        broj = rand() % 1000 + 1; // Generiše slučajan broj u intervalu [1, 1000]

        if (broj < 500) {
            interval1++;
        } else if (broj > 500) {
            interval2++;
        }

        printf("Izabran broj: %d\n", broj);

    } while (broj != 500);

    if (interval1 > interval2) {
        printf("Više brojeva je izabrano iz intervala [1, 499].\n");
    } else if (interval1 < interval2) {
        printf("Više brojeva je izabrano iz intervala [501, 1000].\n");
    } else {
        printf("Izjednačen broj izabranih brojeva iz oba intervala.\n");
    }

    return 0;
}

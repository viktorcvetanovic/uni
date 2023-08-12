#include <stdio.h>
double izracunajGodinuIDane(double sati);

int main() {
    int sati;
    printf("Uneci sate");
    scanf("%d",&sati);
    printf("Godina %d",izracunajGodinuIDane(sati));
   return 0;
}

double izracunajGodinuIDane(double sati){
    return sati / 8760;
}
#include <stdio.h>
int izracunajKolikoNovcanica(int* cena, int novcanica);

int main() {
    int cena;
    printf("Uneci cenu u dinarima");
    scanf("%d",&cena);
    printf("Cena je %d", cena);
    printf("Novcanica od 500 se nalazi %d puta: \n", izracunajKolikoNovcanica(&cena,500));
    printf("Novcanica od 100 se nalazi %d puta: \n", izracunajKolikoNovcanica(&cena,100));
    printf("Novcanica od 1 se nalazi %d puta: \n", izracunajKolikoNovcanica(&cena,1));
   return 0;
}


int izracunajKolikoNovcanica(int* cena, int novcanica){
int counter = 0;
    while(*cena-novcanica>=0){
        counter++;
        *cena = *cena-novcanica;
    }
    return counter;
}
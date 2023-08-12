#include <stdio.h>
#include <string.h>

void izbaciNuleSaKraja(char *str) {
    int duzina = strlen(str);
    
    // Pronalazi poziciju poslednjeg nenultog znaka
    int pos = duzina - 1;
    while (pos >= 0 && str[pos] == '0') {
        pos--;
    }
    
    // Postavlja terminator na novu poziciju kako bi se skratio string
    str[pos + 1] = '\0';
}

int main() {
    char tekst[] = "12345000";
    
    izbaciNuleSaKraja(tekst);
    
    printf("Nakon izbacivanja nula: %s\n", tekst);
    
    return 0;
}

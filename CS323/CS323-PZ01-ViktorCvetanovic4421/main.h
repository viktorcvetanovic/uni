//
// Created by vikto on 8/17/2023.
//

#ifndef CS323_PZ01_VIKTORCVETANOVIC4421_MAIN_H
#define CS323_PZ01_VIKTORCVETANOVIC4421_MAIN_H

#endif //CS323_PZ01_VIKTORCVETANOVIC4421_MAIN_H
typedef struct Valute{
    double value;
    char* name;
    char* type;
}valute ;

void updateAccountBalance(const char *accountNumber, double newBalance);
valute readJsonByParameter(char* parameter);
void readStringInput(char* stringToPrint, char* input);
int readIntInput(char* stringToPrint);
void createNewAccount(const char *accountNumber, double initialBalance, const char *accountType);
int doesAccountExist(const char *accountNumber);
int validateAccountNumber(const char *accountNumber);
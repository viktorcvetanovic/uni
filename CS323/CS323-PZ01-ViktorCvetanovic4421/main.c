#include <stdio.h>
#include <string.h>
#include <malloc.h>
#include "cJSON.h"
#include "main.h"


int main(int argc, char* argv[]){
    printf("Welcome to bankomat\n");
    char code[256];
    readStringInput("Please enter your pin code so we can associate account:\n", code);
    valute value = readJsonByParameter(code);
    int chosenNumber;
    readIntInput("Enter one of the option\n"
          "1. Withdraw money\n"
          "2. Deposit money\n"
          "3. Check balance\n", &chosenNumber);
    printf("The option you choosed is %d \n", chosenNumber);
    int depositInput;
    int withdrawInput;
    switch (chosenNumber) {
        case 1:
            readIntInput("How much would you like to withdraw", &withdrawInput);
            if(withdrawInput > value.value){
                printf("Sorry but you dont have enough money on your account");
                return 1;
            }
            updateAccountBalance(value.name,value.value-withdrawInput);
            printf("You withdraw %d, Your balance is %f\n",withdrawInput, value.value- withdrawInput);
            break;
        case 2:
            readIntInput("How much would you like to deposit?\n", &depositInput);
            updateAccountBalance(value.name,depositInput+value.value);
            printf("You have deposited amount : %d, now you have %f \n",depositInput,depositInput+value.value);
            break;
        case 3:
            printf("Your balance is %f\n", value.value);
            break;
        default:
            printf("You have not chosen any of options, application is shutting down\n");
            return 1;
    }
    return 0;
}


valute readJsonByParameter(char* parameter){
    // Read the entire file into memory
    FILE *fp = fopen("bankomat.json", "r");
    if (fp == NULL) {
        perror("Error opening file");
    }
    fseek(fp, 0, SEEK_END);
    long file_size = ftell(fp);
    fseek(fp, 0, SEEK_SET);
    char *json_str = (char *)malloc(file_size + 1);
    fread(json_str, 1, file_size, fp);
    json_str[file_size] = '\0';
    fclose(fp);

    // Parse the JSON data
    cJSON *root = cJSON_Parse(json_str);
    if (root == NULL) {
        const char *error_ptr = cJSON_GetErrorPtr();
        if (error_ptr != NULL) {
            fprintf(stderr, "Error before: %s\n", error_ptr);
        }
    }

    // Get the account object with key "4421"
    cJSON *account = cJSON_GetObjectItem(root, parameter);
    if (account == NULL) {
        printf("Account %s not found in JSON data.\n",parameter);
        cJSON_Delete(root);
        free(json_str);
    }

    // Access and print values from the account object
    cJSON *balance = cJSON_GetObjectItem(account, "balance");
    cJSON *type = cJSON_GetObjectItem(account, "type");

    if (balance && balance->type == cJSON_Number) {
        printf("Balance: %lf\n", balance->valuedouble);
    }

    if (type && type->type == cJSON_String) {
        printf("Type: %s\n", type->valuestring);
    }

    // Clean up cJSON and memory resources
    cJSON_Delete(root);
    free(json_str);

    valute returnValute = {.value = balance -> valuedouble, .name =  parameter, .type = type->valuestring};
    return returnValute;
}

void updateAccountBalance(const char *accountNumber, double newBalance) {
    // Read the existing JSON data from the file
    FILE *fp = fopen("bankomat.json", "r");
    if (fp == NULL) {
        perror("Error opening file");
        return;
    }

    fseek(fp, 0, SEEK_END);
    long file_size = ftell(fp);
    fseek(fp, 0, SEEK_SET);

    char *json_str = (char *)malloc(file_size + 1);
    fread(json_str, 1, file_size, fp);
    fclose(fp);

    // Parse the existing JSON data
    cJSON *root = cJSON_Parse(json_str);
    if (root == NULL) {
        const char *error_ptr = cJSON_GetErrorPtr();
        if (error_ptr != NULL) {
            fprintf(stderr, "Error before: %s\n", error_ptr);
        }
        free(json_str);
        return;
    }

    // Find the account object by account number
    cJSON *accountObject = cJSON_GetObjectItem(root, accountNumber);
    if (accountObject == NULL || !cJSON_IsObject(accountObject)) {
        printf("Account '%s' not found in JSON data.\n", accountNumber);
        cJSON_Delete(root);
        free(json_str);
        return;
    }

    // Update the balance property
    cJSON *balanceNode = cJSON_GetObjectItem(accountObject, "balance");
    if (balanceNode != NULL && cJSON_IsNumber(balanceNode)) {
        cJSON_SetNumberValue(balanceNode, newBalance);
    }

    // Convert JSON to string
    char *updated_json_str = cJSON_Print(root);

    // Write updated JSON string back to file
    FILE *fp_update = fopen("bankomat.json", "w");
    if (fp_update == NULL) {
        perror("Error opening file");
        cJSON_Delete(root);
        free(json_str);
        free(updated_json_str);
        return;
    }
    fputs(updated_json_str, fp_update);
    fclose(fp_update);

    // Clean up cJSON and memory resources
    cJSON_Delete(root);
    free(json_str);
    free(updated_json_str);
}

void readStringInput(char* stringToPrint, char* input){


    printf("%s", stringToPrint);
    if (fgets(input, sizeof(input), stdin) != NULL) {
        // Remove the trailing newline character
        size_t length = strlen(input);
        if (length > 0 && input[length - 1] == '\n') {
            input[length - 1] = '\0';
        }

        printf("You entered: %s\n", input);
    } else {
        printf("Error reading input.\n");
    }
}

void readIntInput(char* stringToPrint, int* input){
    printf("%s", stringToPrint);
    scanf("%d", input);
}

#include "Student.h"
#include "MasterStudent.h"

int main() {
    Student student("Marko", "Marković", 12345);
    student.info();

    MasterStudent masterStudent("Jovan", "Jovanović", 54321, "Profesor Petrović");
    masterStudent.info();

    return 0;
}

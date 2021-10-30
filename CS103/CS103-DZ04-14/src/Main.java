import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Unesite duzinu arraya: ");
        var n = scanner.nextInt();
        scanner.nextLine();
        boolean badLength = n > 20 || n < 0;
        if (badLength) {
            throw new RuntimeException("Pogresna duzina arraya");
        }
        var array = new char[n];
        var counter = 0;
        while (counter < n) {
            System.out.println("Unesi " + counter + " element:");
            array[counter++] = scanner.next().charAt(0);
        }
        System.out.println("Nesortirani array: " + Arrays.toString(array));
        sortArray(array);
        System.out.println("Sortirani array: " + Arrays.toString(array));
        System.out.println(new String(array));
    }

    static void sortArray(char[] array) {
        var n = array.length;
        for (int i = 1; i < n; i++) {
            var key = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}


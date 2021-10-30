import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int[] arr1 = readIntArray(scanner);
        System.out.println("Zavreseno citanje prvog niza");
        int[] arr2 = readIntArray(scanner);
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Velicine nize istu iste");
        }
        if (arr1.length > 256) {
            throw new RuntimeException("Velicina niza mora biti manja od 256");
        }

        System.out.println(scalarProduct(arr1, arr2));
    }

    private static int[] readIntArray(Scanner scanner) {
        System.out.println("Unesite velicinu niza");
        var length = scanner.nextInt();
        scanner.nextLine();
        int[] array = new int[length];
        int i = 0;
        while (i < length) {
            System.out.println("Unesite element " + i + " :");
            array[i] = scanner.nextInt();
            i++;
        }
        return array;
    }

    private static int scalarProduct(int[] arr1, int[] arr2) {
        return scalarProductWrapper(arr1, arr2, arr1.length);
    }

    protected static int scalarProductWrapper(int[] arr1, int[] arr2, int c) {
        if (c == 0) {
            return 0;
        }
        c -= 1;
        return arr1[c] * arr2[c] + scalarProductWrapper(arr1, arr2, c);
    }


}



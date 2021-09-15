package zadatak1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zadatak1 {

    public static int[] foo(int[] arr) {
        int count = 0;
        int[] tmp = new int[0];

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    i++;
                }

                count++;
                tmp = Arrays.copyOf(tmp, count);
                tmp[count - 1] = arr[i];
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite duzinu niza: ");

        int n = scanner.nextInt();
        int[] arr = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10) + 1;
        }

        System.out.println(Arrays.toString(arr));
        int[] dup = foo(arr);
        System.out.println(Arrays.toString(dup));
    }

}

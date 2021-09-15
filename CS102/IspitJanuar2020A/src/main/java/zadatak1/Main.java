package zadatak1;

public class Main {
    public static void main(String[] args) {
        System.out.println(cifra(123,221));
    }

    public static boolean cifra(int d, int n) {
        if (n == 0) {
            return false;
        }
        System.out.println("drugi "+n%10);
        System.out.println("prvi "+d/100%10);
        if (n % 10 == d / 100 % 10) {
            return true;
        }

        return cifra(d, n / 10);
    }
}

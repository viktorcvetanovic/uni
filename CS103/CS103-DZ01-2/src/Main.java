public class Main {

    public static void main(String[] args) {
        int max = 0;
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                var num = i * j;
                if (isPalindrom(num) && num > max) {
                    max = num;
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isPalindrom(int number) {
        return number == reverseNumber(number);
    }

    private static int reverseNumber(int number) {
        int reverse = 0;
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse;
    }
}

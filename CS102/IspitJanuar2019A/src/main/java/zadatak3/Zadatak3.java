package zadatak3;

public class Zadatak3 {
    public static void main(String[] args) {
        System.out.println(doMathWithNumber(5,3,5,6,2));
    }

    public static <T extends Number> T doMathWithNumber(T... array) {
        T newArray[] = (T[]) new Number[array.length];
        T sum = (T) Double.valueOf(0);
        for (int i = 0; i < array.length; i++) {
            newArray[i] = (T) Double.valueOf(Math.pow(array[i].doubleValue(), 2));
        }
        for (T el : newArray) {
            sum = (T) Double.valueOf(sum.doubleValue() + el.doubleValue());
        }

        return (T) Double.valueOf(Math.sqrt(sum.doubleValue()) / newArray.length);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {


    public static void main(String[] args) {
        System.out.println(deleteDuplicate(new Number[]{1, 2, 3, 1, 2, 5, 6, 7}));

    }

    private static List<Number> deleteDuplicate(Number[] arr) {
        arr = sortArr(arr);
        List<Number> list = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            if (!arr[i].equals(arr[i + 1])) {
                list.add(arr[i]);
            }
        }
        return list;
    }


    private static Number[] sortArr(Number[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].doubleValue() < arr[j].doubleValue()) {
                    Number min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
        return arr;
    }

}

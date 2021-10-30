import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(method(new Integer[]{1, 2, 3, 2, 3, 3, 3, 3, 4, 3, 4, 3, 3, 3, 3, 5})));
        System.out.println(Arrays.toString(method(new Integer[]{2,2,3,4,5})));
    }

    public static Integer[] method(Integer[] array) {
        var count = 1;
        var returnArray=new Integer[]{array[0],count};
        Arrays.sort(array);

        for (var i = 0; i < array.length - 1; i++) {
            var help = i + 1;
            if (array[i].equals(array[help])) {
                count++;
                if (count > array.length/2) {
                    returnArray[0]=array[i];
                    returnArray[1]=count;
                }
            } else {
                count = 1;
            }
        }
        return returnArray;
    }
}

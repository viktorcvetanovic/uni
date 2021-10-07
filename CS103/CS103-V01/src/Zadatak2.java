import java.util.Arrays;

public class Zadatak2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMostSeen(new Number[]{1, 2, 2, 3, 3, 3,1,1,1, 4})));
        System.out.println(Arrays.toString(findMostSeen(new Number[]{2,7,8,2})));
        System.out.println(Arrays.toString(findMostSeen(new Number[]{1,3,7,8,9,3,2,3,3})));
    }

    private static Number[] findMostSeen(Number[] arr) {
        Number num = arr[0];
        int seen = 1;
        int counter = 1;
        arr = sortArr(arr);
        for (int i = 0; i < arr.length-1 ;i++ ) {
          for(int j=0;j<arr.length-1;j++){
              if(arr[i].equals(arr[j]) && i!=j){
                  counter++;
              }else{
                  if(counter>seen){
                      num=arr[i];
                      seen=counter;
                  }
                  counter=1;
              }
          }
        }
        return new Number[]{num, seen};
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

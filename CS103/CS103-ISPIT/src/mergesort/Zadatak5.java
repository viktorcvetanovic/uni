package mergesort;

import java.util.Arrays;

public class Zadatak5 {
    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        char[] reci=new char[]{'b','a','c','a'};
        mergeSort.sort(reci,0,reci.length-1);
        System.out.println(Arrays.toString(reci));
    }
}

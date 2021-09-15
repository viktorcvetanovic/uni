package zadatak2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    List<String> strings= Arrays.asList("viktor","car","peder","too");
    List<String> strings1=Arrays.asList("viktor","peder","kralj");
        System.out.println(proveriListe(strings,strings1));
    }

    public static <T extends Comparable<T>> List<T> proveriListe(List<T> a, List<T> b) {
        List<T> c = new ArrayList<>();

        for (T el : a) {
            if(!b.contains(el)){
                c.add(el);
            }
        }
        for (T el1 : b) {
            if(!a.contains(el1)){
                c.add(el1);
            }
        }

        return c;
    }
}

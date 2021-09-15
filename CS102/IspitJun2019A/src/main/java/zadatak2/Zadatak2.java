package zadatak2;

import java.util.ArrayList;
import java.util.List;

public class Zadatak2 {

    public static void main(String[] args) {
        Long niz[] = new Long[5];
        niz[0] = 1l;
        niz[1] = 2l;
        niz[2] = 3l;
        niz[3] = 4l;
        niz[4] = 5l;
        System.out.println(proveriVrednost(niz));
    }

    public static <T extends Number> List<T> proveriVrednost(T niz[]) {
        List<T> list = new ArrayList<>();

        T sum = (T) Integer.valueOf(0);
        T max = (T) Integer.valueOf(Integer.MIN_VALUE);
        T min = (T) Integer.valueOf(Integer.MAX_VALUE);
        for (int i = 0; i < niz.length; i++) {
            if (min.intValue() > niz[i].intValue()) {
                min = niz[i];
            }
            if (max.intValue() < niz[i].intValue()) {
                max = niz[i];
            }
            sum = (T) Double.valueOf(sum.doubleValue() + niz[i].doubleValue());
        }
        list.add(sum);
        list.add(min);
        list.add(max);
        return list;
    }
}

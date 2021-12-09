import java.util.ArrayList;
import java.util.List;

public class Hash2 {

    //    Dizajnirati prostu heš funkciju, laku za izračunavanje, koja mapira string od tri karaktera u
//    celobrojni opseg od 0 do n−1. Izračunati vrednosti heš funkcija za sledeće reči
//    PAL LAP PAM MAP PAT PET SET SAT TAT BAT
//    i za slučajeve kada je n = 11, 13, 17, 19. Koristiti linearno pretraživanje za razrešavanje kolizije
    private List<String> list;
    private int size = 20;
    private static final int hash = 5222341;

    public Hash2() {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
    }

    public void add(String s) {
        int index = doHash(s);
        if (list.get(index) == null) {
            list.set(index, s);
        } else if (list.get(index + doHash2(s)) == null) {
            list.set(index + doHash2(s), s);
        } else {
            size += size / 2;
            for (int i = 0; i < size; i++) {
                list.add(null);
            }
        }

    }


    private int doHash(String str) {
        int value = 0;
        for (char c : str.toCharArray()) {
            value += c;
        }
        return value * hash % size;
    }

    private int doHash2(String str) {
        int helpHash = doHash(str);
        return helpHash * hash % size;
    }

    @Override
    public String toString() {
        return "Hash2{" +
                "list=" + list +
                ", size=" + size +
                '}';
    }
}

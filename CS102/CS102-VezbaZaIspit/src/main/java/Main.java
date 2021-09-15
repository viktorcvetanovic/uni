import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4};
        Integer[] b = {4, 5, 6, 7, 8, 1};
        System.out.println(Arrays.toString(returnDifferenceOfArrays(a, b)));
        System.out.println(returnByIndex(Arrays.asList(1, 2, 3, 4, 2, 5, 6, 7, 8, 9), 2));
        System.out.println(Arrays.deepToString(fetus(new Integer[]{1, 2, 3, 4, 2, 5, 6, 7, 8, 9}, 7)));
        System.out.println(mySubstring("viktorcina", 3, 5));
        System.out.println(Arrays.toString(kreirajNiz(53)));
        sort2DArray(new Integer[][]{{5, 4, 3, 2, 1}, {2, 9, 10, 5, 6, 7, 8}});
        System.out.println(zbirCifaraNaPozicijima('r', "viktorr"));
        System.out.println(dodajNuluPosleNeparneCifre(1234));
    }

    public static <T> T[] returnDifferenceOfArrays(T[] a, T[] b) {
        T[] diff = (T[]) new Object[a.length + b.length];
        int help = 0;
        for (int i = 0; i < b.length; i++) {
            if (!Arrays.asList(a).contains(b[i])) {
                diff[help] = b[i];
                help++;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (!Arrays.asList(b).contains(a[i]) && !Arrays.asList(diff).contains(a[i])) {
                diff[help] = a[i];
                help++;
            }
        }
        return diff;
    }

    //    generičku metodu koja kao parametar ima listu i
//    jedan generički element; potrebno je vratiti listu koja sadrži sve indekse pojavljivanja prosleđenog generičkog elementa u listi.
    public static <T> List<Integer> returnByIndex(List<T> list, T el) {
        List<Integer> pom = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(el)) {
                pom.add(i);
            }
        }
        return pom;
    }

    //     generičku metodu koja prima generički niz i jedan integer; potrebno je da metoda proširi veličinu niza brojčanog tipa na
//     dvodimenzionalni, dimenzija n x n. Svaki naredni red novokreiranog niza predstavlja kvadrat elemenata prethodnog reda.
    public static <T extends Number> T[][] fetus(T niz[], Integer number) {
        T newNiz[][] = (T[][]) new Number[number][number];

        //prepisuje vrednost niza u prvi red matrice
        for (int i = 0; i < newNiz[0].length; i++) {
            newNiz[0][i] = niz[i];
        }
        for (int i = 1; i < newNiz.length; i++) {
            T helpNiz[] = newNiz[i - 1];
            for (int j = 0; j < newNiz[0].length; j++) {
                newNiz[i][j] = (T) Double.valueOf((int) Math.pow(helpNiz[j].doubleValue(), 2));
            }
        }
        return newNiz;
    }

    //    Napisati rekurzivnu metodu koja pravi substring zadatog teksta.
//    Kao argumente metod dobija tekst, kao i levi i desni indeks kao graničnike za novi tekst.
    public static String mySubstring(String text, int a, int b) {
        return null;
    }


    public static int[] kreirajNiz(int number) {
        if (number < 10) {
            return new int[]{number};
        }

        return kreirajNiz(number / 10);
    }

    //    generičku metodu koja prima generički dvodimenzionalni niz; potrebno je da metoda sortira svaku vrstu dvodimenzionalnog niza u rastućem redosledu.
    public static <T extends Number> void sort2DArray(T niz[][]) {
        for (int i = 0; i < niz.length; i++) {
            for (int j = 0; j < niz[i].length; j++) {
                for (int z = 0; z < niz[i].length; z++) {
                    if (niz[i][j].doubleValue() < niz[i][z].doubleValue()) {
                        T pom = niz[i][j];
                        niz[i][j] = niz[i][z];
                        niz[i][z] = pom;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(niz));
    }

    public static int zbirCifaraNaPozicijima(char d, String s) {
        int zbir = 0;
        if (s.length() == 0) {
            return zbir;
        } else if (s.charAt(s.length() - 1) == d) {
            zbir += s.length() - 1;
        }
        return zbir + zbirCifaraNaPozicijima(d, s.substring(0, s.length() - 1));
    }

    public static String dodajNuluPosleNeparneCifre(int number) {
        return ((number >= 10) ? dodajNuluPosleNeparneCifre(number / 10) : "") + (number % 10) + ((number % 2 != 0) ? "0" : "");
    }

    public static String[] svePermutacije(String a){
        String niz[]=new String[a.length()*a.length()];
        if(niz[niz.length-1]!= null){
            return niz;
        }
    return null;
    }
}

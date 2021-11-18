import list.ViktorList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ViktorList<Integer> list = new ViktorList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        list.removeFirst();
        list.print();

        ViktorList<Character> list2=new ViktorList<>();
        list2.addAll(Arrays.asList('a','b','c','a'));
        list2.print();
        System.out.println(list2.isAlphabetOrdered());
    }


}

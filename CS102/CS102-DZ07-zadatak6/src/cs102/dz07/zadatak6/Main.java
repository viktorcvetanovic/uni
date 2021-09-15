/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.dz07.zadatak6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Student> listStudenta = new ArrayList<>();
        listStudenta.add(new Student("Petar", "Milenkovic", 4450));
        listStudenta.add(new Student("Nikola", "Markovic", 4234));
        listStudenta.add(new Student("Marija", "Marinkovic", 4689));

        List<PolozenIspit> listIspita1 = new ArrayList<>();
        listIspita1.add(new PolozenIspit("CS102", 8));
        listIspita1.add(new PolozenIspit("MA101", 8));
        listIspita1.add(new PolozenIspit("IT210", 7));
        List<PolozenIspit> listIspita2 = new ArrayList<>();
        listIspita2.add(new PolozenIspit("CS102", 7));
        listIspita2.add(new PolozenIspit("MA101", 9));
        listIspita2.add(new PolozenIspit("IT210", 7));
        List<PolozenIspit> listIspita3 = new ArrayList<>();
        listIspita3.add(new PolozenIspit("CS102", 10));
        listIspita3.add(new PolozenIspit("MA101", 10));
        listIspita3.add(new PolozenIspit("IT210", 10));

        Map<Integer, List<PolozenIspit>> map = new TreeMap<>();
        map.put(listStudenta.get(0).getBrIndeks(), listIspita1);
        map.put(listStudenta.get(1).getBrIndeks(), listIspita2);
        map.put(listStudenta.get(2).getBrIndeks(), listIspita3);

        Stream<Entry<Integer, List<PolozenIspit>>> sorder = map.entrySet().stream().sorted(Map.Entry.comparingByValue(new MapComparator()));
        sorder.forEach(System.out::println);
    }

}

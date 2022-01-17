package list;

public class Zadatak4 {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(0);
        list.printList();
        list.removeDuplicates();
        System.out.println("------------------------------");
        list.printList();
        System.out.println("--------------------------------");
        System.out.println(list.minElement());
        System.out.println("--------------------------------");
        System.out.println("JEBEM TI MAMU");
        list.insertAfter(4);
        list.printList();
    }





}

package list;


import java.util.List;

public class ViktorList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;


    public boolean removeFirst() {
        if (head.next == null) {
            return false;
        }
        head = head.next;
        size--;
        return true;
    }

    public boolean addLast(T el) {
        Node<T> node = new Node(el);
        if (tail == null) {
            tail = node;
        }
        if (head == null) {
            head = node;
        }
        tail.next = node;
        tail = node;
        size++;

        return true;
    }

    @Deprecated
    public boolean add(T el, int index) {
        return false;
    }

    public void addAll(List<T> array) {
        for (T el : array) {
            addLast(el);
        }
    }

    public boolean isAlphabetOrdered() {
        Node<T> el = head;
        while (el.next != null) {
            T val = el.value;
            T nextVal = el.next.value;
            if (!(val instanceof Character) && !(nextVal instanceof Character)) {
                throw new RuntimeException("Node value must be Charachter");
            }
            if ((Character) val > (Character) nextVal) {
                return false;
            }
            el = el.next;
        }
        return true;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> el = head;
        while (true) {
            System.out.println(el);
            System.out.println();
            if (el.next == null) {
                break;
            } else {
                el = el.next;
            }
        }
    }


    private static final class Node<T> {
        protected T value;
        protected Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

}

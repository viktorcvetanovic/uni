package list;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Node head = new Node();
    private Node tail = new Node();
    private int size = 0;


    public LinkedList() {
    }

    public void add(Integer value) {
        if (head.value == null) {
            head.value = value;
            head.next = tail;
        } else if (tail.value == null) {
            tail.value = value;
        } else {
            var node = new Node(value);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    private int size() {
        return size;
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    public void removeDuplicates() {
        Node node = head;
        List<Node> elements = new ArrayList<>();
        elements.add(node);
        while (node != null) {
            if (elements.contains(node.next)) {
                node.next = node.next.next;
            } else {
                elements.add(node.next);
                node = node.next;
            }
        }
    }

    //Napisati funkciju koja za povezanu listu celih brojeva određuje najmanji elemen
    public Node minElement() {
        Node min = head;
        Node curr = head;
        while ((curr = curr.next) != null) {
            if (min.value > curr.value) {
                min = curr;
            }
        }
        return min;
    }

    public void insertAfter(int value) {
        Node curr = head;
        while ((curr = curr.next) != null) {
            if (curr.value == value) {
                var newNode = new Node(value);
                newNode.next = curr.next;
                curr.next=newNode;
                curr=curr.next;
            }
        }
    }

}

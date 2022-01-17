package linkedlist;

import java.util.Objects;

public class Node implements Comparable<Node>{
    public Integer value;
    public Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public Node() {
    }

    public Node(Integer value, Node next) {
        this.value = value;
        this.next = next;
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }


    @Override
    public int compareTo(Node o) {
        return value.compareTo(o.value);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

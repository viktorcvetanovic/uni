import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private List<Node> list=new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Node> getList() {
        return list;
    }

    public void setList(List<Node> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", list=" + list +
                '}';
    }
}

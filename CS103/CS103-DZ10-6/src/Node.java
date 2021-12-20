import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    private List<Node> nodes = new ArrayList<>();
    private int nodeNumber;
    public static int _nodeNumber=0;

    public void addNode(Node node) {
        nodes.add(node);
        nodeNumber = _nodeNumber++;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeNumber= " + nodeNumber + " "
                + "value= " + value +
                " size= " + nodes.size() +
                '}';
    }
}

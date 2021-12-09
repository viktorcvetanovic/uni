import java.util.Stack;

public class Tree {
    private Node root;

    public void addNormal(Integer value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node node, Integer value) {
        if (node == null) {
            return new Node(value);
        }
        if (node.value > value) {
            node.left = addRecursive(node.left, value);
        } else if (node.value < value) {
            node.right = addRecursive(node.right, value);
        } else {
            return node;
        }
        return node;
    }


    public void print() {
        printRecurisve(root);
    }

    private void printRecurisve(Node node) {
        if (node == null) {
            return;
        }

        printRecurisve(node.right);
        System.out.println(node);
        printRecurisve(node.left);
    }

    public void preOrderWithoutRecursion() {
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            var current = nodes.pop();
            System.out.printf("%s ", current.value);
            if (current.right != null) {
                nodes.push(current.right);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
        }
    }


    private static final class Node {
        public Integer value;
        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}

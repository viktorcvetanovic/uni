import java.io.PrintStream;

public class BinaryTree {
    private Node root;

    public void add(Integer number) {
        root = addRecursive(root, number);
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

    public Node findBiggestEl() {
        Node el = root;
        while (el.right != null) {
            el = el.right;
        }
        return el;
    }


    public void print(PrintStream os) {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this.root);
        os.print(sb.toString());
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.value);
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.right != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
        }
    }


    private static final class Node {

        private Node left;
        private Node right;
        private Integer value;

        public Node(Node left, Node right, Integer value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}



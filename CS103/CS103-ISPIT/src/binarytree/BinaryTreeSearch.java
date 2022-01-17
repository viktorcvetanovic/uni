package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSearch {
    public Node root;


    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (node.value < value) {
            node.right = addRecursive(node.right, value);
        } else if (node.value > value) {
            node.left = addRecursive(node.left, value);
        }
        return node;
    }

    void inorder() {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.value);
            inorderRec(root.right);
        }
    }


    public int togetherDelimiter(Node node) {
        int left = nodeToInt(findLeftLeaves(node.left, new ArrayList<>()));
        int right = nodeToInt(findRightNotLeaves(node.right, new ArrayList<>()));
        return gcd(left,right);
    }

    private int nodeToInt(List<Node> list){
        int a=1;
        for(Node node:list){
            a*=node.value;
        }
        return a;
    }

    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


    private List<Node> findLeftLeaves(Node node, List<Node> list) {
        if (node == null) {
            return list;
        } else if (node.left == null && node.right == null) {
            list.add(node);
        }
        findLeftLeaves(node.left, list);
        findLeftLeaves(node.right, list);
        return list;
    }

    private List<Node> findRightNotLeaves(Node node, List<Node> list) {
        if (node == null) {
            return list;
        } else if (node.left != null || node.right != null) {
            list.add(node);
        }
        findRightNotLeaves(node.left, list);
        findRightNotLeaves(node.right, list);
        return list;
    }

}

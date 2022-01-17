package binarytree;

public class Zadatak2 {
    public static void main(String[] args) {
        BinaryTreeSearch tree=new BinaryTreeSearch();
        tree.add(10);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        tree.add(15);
        tree.add(16);
        tree.add(17);
        tree.inorder();
        System.out.println("-----------------------------------");
        System.out.println(tree.togetherDelimiter(tree.root));
    }
}

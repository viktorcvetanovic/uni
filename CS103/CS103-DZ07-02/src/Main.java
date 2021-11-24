public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(4);
        binaryTree.add(6);
        binaryTree.add(99);
        binaryTree.add(3);
        binaryTree.add(101);
        binaryTree.print(System.out);
        System.out.println("-----Biggest element------");
        System.out.println("The values is: "+binaryTree.findBiggestEl());
        System.out.println(binaryTree.toList());
    }
}

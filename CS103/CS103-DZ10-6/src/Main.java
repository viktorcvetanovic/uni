import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node root=new Node(5);
        Node a=new Node(7);
        Node b=new Node(8);
        Node c=new Node(94);
        root.addNode(a);
        root.addNode(b);
        a.addNode(b);
        b.addNode(c);
        b.addNode(a);
        visit(root);
    }

    private static void visit(Node root){
        visitAll( new ArrayList<>(),root);
    }


    private static void visitAll(List<Node> visited,Node node){
        System.out.println(node);
        for(Node n: node.getNodes()){
            if(!visited.contains(n)){
                visited.add(n);
                visitAll(visited,n);
            }
        }


    }

}

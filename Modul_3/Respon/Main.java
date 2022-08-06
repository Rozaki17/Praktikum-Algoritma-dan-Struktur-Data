package Modul_3.Respon;

public class Main {
    public static void main(String args[]){
        ContinousTree ct = new ContinousTree();

        Node root = ct.newNode(3);
        
        root.left	 = ct.newNode(2);
        root.right	 = ct.newNode(4);
        root.left.left = ct.newNode(1);
        root.left.right = ct.newNode(3);
        root.right.right = ct.newNode(5);
        
        // Node root = ct.newNode(7);

        // root.left	 = ct.newNode(5);
        // root.right	 = ct.newNode(8);
        // root.left.left = ct.newNode(6);
        // root.left.right = ct.newNode(4);
        // root.right.right = ct.newNode(10);

        ct.preorder(root);

        System.out.print(" --> Is This Tree Continous Tree?");
    
        if(ct.treeContinuous(root)) System.out.print(" Yes");
        else System.out.println(" No");
    }
}

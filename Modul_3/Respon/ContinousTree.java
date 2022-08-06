package Modul_3.Respon;

public class ContinousTree {
    Node root;

    Node newNode(int data){
        Node node = new Node(data);
        node.data = data;
        node.left = node.right = null;
        return(node);
    }

    boolean treeContinuous(Node ptr){
        if (ptr == null)
            return true;
    
        if (ptr.left == null && ptr.right == null)
            return true;
    
        if (ptr.left == null)
        return (Math.abs(ptr.data - ptr.right.data) == 1) &&
                treeContinuous(ptr.right);
    
        if (ptr.right == null)
        return (Math.abs(ptr.data - ptr.left.data) == 1) &&
                treeContinuous(ptr.left);
    
        return Math.abs(ptr.data - ptr.left.data)==1 &&
                Math.abs(ptr.data - ptr.right.data)==1 &&
                treeContinuous(ptr.left) &&
                treeContinuous(ptr.right);
    }

    void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

package Modul_5.Jurnal_No2;

public class Stack {
    Node head, current;
    
    void insertStack(Vertices dest){
        Node tmp = new Node(dest);
        if (head == null){
            head = tmp;
        }else{
            tmp.next = head;
            head = tmp;
        }
    }

    Node getHead (){
        return head;
    }
}

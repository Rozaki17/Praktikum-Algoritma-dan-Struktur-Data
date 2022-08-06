package Modul_4;

public class Queue {
    Node head, current;

    void add (Vertex baru){
        Node tmp = new Node(baru);
        if (head == null){
            head = tmp;
        } else {
            current = head;

            while (current.next != null){
                current = current.next;
            }
            current.next = tmp;
        }
    }

    boolean isEmpty (){
        if (head == null){
            return true;
        }
        return false;
    }

    Vertex poll (){
        current = head;
        head = current.next;
        return current.data;
    }
}

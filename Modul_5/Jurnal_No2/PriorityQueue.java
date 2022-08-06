package Modul_5.Jurnal_No2;

public class PriorityQueue {
    Node head, tail, current;

    void add (Vertices dest, int jarak){
        Node tmp = new Node(dest, jarak);
        if (head == null){
            head = tail = tmp;
        } else {
            if (head.jarak > tmp.jarak){
                tmp.next = head;
                head = tmp;
            } else if (tail.jarak < tmp.jarak){
                tail.next = tmp;
                tail = tmp;
            } else {
                current = head;

                while (current.jarak <= tmp.jarak){
                    if (current.next.jarak >= tmp.jarak)
                        break;

                    current = current.next;
                }
                tmp.next = current.next;
                current.next = tmp;
            }
        }
    }

    boolean isEmpty (){
        if (head == null) return true;
        return false;
    }

    Vertices poll (){
        current = head;
        head = head.next;

        return current.dest;
    }

    int size (){
        current = head;
        int size = 0;

        while (current.next != null){
            size++;
            current = current.next;
        }
        return size;
    }
}

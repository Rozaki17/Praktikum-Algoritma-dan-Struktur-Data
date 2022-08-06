package Modul_5.Jurnal_No2;

public class Node {
    Vertices dest;
    int jarak;
    Node next;

    Node (Vertices dest, int jarak){
        this.dest = dest;
        this.jarak = jarak;
    }

    Node (Vertices dest){
        this.dest = dest;
    }
}

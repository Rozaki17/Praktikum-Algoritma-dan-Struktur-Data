package Modul_5.Project;




/*  

    Membuat class Queue yang di mana merumakan kelas turunan dari linkedlist yang ditandai dengan
    penggunaan "extend" setiap atribut dan method yang ada di dalam class linkedlist akan terdapat
    atau diwarisi ke kelas anaknya yaitu Queue. 
    Queue ini berfungsi untuk melakukan operasi que pada saat menjalankan operasi bfs yakni saat 
    penghapusan data dan penambahan data.
*/

public class Queue<T> extends LinkedList<T>{
    public void queue(T data){
        addFirst(data);
    }

/*
    Method deque ini merupakan method yang sifatnya public sehingga dapat diakses dari kelas lain
    Method ini digunakan untuk menghapus isi dari queue. Dalam method ini memanfaatkan method dari kelas
    parent yaitu removefirst().
    Jika hanya ada satu isi dari queue maka bisa dimanfaatkan method removefirst yang ada di class
    linkedlist.
*/
    //menghapus isi queue
    public Node<T> dequeue(){
        Node<T> tmp = head;
        removefirst();
        return tmp;
    }

    public void enqueue(T data){
        addLast(data);
    }
}

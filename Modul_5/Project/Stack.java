package Modul_5.Project;

/*
    Membuat class Stack yang dimana class ini bertipe public, sehingga bisa diakses dari
    kelas manapun. Kelas Stack ini tergolong dalam generic class yang di mana memungkinkan class menjadi 
    tipe parameter dengan berbagai macam tipe.
    <T> Yang berarti Tipe Parameter yang digunakan untuk menentukan jenis tipe data yang ingin gunakan pada 
    variable atau atribut didalamnya, T bisa kita ubah menjadi tipe data apa saja, seperti Integer, String, 
    Boolean, Character, Float, Byte, dll. 

    Membuat class Stack yang di mana merumakan kelas turunan dari LinkedList yang ditandai dengan
    penggunaan "extend" setiap atribut dan method yang ada di dalam class linkedlist akan terdapat
    atau diwarisi ke kelas anaknya yaitu Stack. 
    Pembuatan class Stack ini digunakan saat melakukan BFS atau Breadth First Search pada graph.
*/

public class Stack<T> extends LinkedList<T>{
    
/*
    Pembuatan method push yang digunakan untuk menambah data pada stack, di mana 
    pada method ini menggunakan method dari kelas LinkedList yaitu addFisrt() untuk
    menambahkan data pada stack.
*/
    public void push(T data){
        addFirst(data);
    }

/*
    Pembuatan method pop yang digunakan untuk menghapus data pada stack, di mana 
    pada method ini data yang ditunjuk oleh pointer head akan disipan terlebih dahulu di 
    variable save.
*/

    public Node<T> pop(){
        Node<T> save = head;
        head = head.next;
        return save;
    }
}


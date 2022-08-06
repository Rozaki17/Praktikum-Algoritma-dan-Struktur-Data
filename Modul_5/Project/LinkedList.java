package Modul_5.Project;

/* 
    Membuat class dengan nama "LinkedList" yang dimana class ini bertipe public, sehingga bisa diakses dari
    kelas manapun. Kelas node ini tergolong dalam generic class yang di mana memungkinkan class menjadi 
    tipe parameter dengan berbagai macam tipe.
    <T> Yang berarti Tipe Parameter yang digunakan untuk menentukan jenis tipe data yang ingin gunakan pada 
    variable atau atribut didalamnya, T bisa kita ubah menjadi tipe data apa saja, seperti Integer, String, 
    Boolean, Character, Float, Byte, dll.
*/

public class LinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;
/* 
    Node<T> head dan Node<T> tail diberikan protected agar hanya bisa diakses oleh class 
    turunananya di mana class LinkedList sebagai kelas parent
*/

/* 
    Method addLast adalah method generic sehingga memungkinkan method menjadi memiliki
    tipe parameter dengan berbagai macam tipe.
    Untuk menambah data baru, maka dibuat sebuah objek dengan nama baru, yang dimana kondisinya:
        Jika belum ada di dalamnya maka data baru tersebut akan menjadi head sekaligus tail
        Namun jika tidak, maka pointer dari tail menunjuk ke baru dan pointer prev data baru menunjuk ke tail
        lalu pindahkan pointer tail ke data baru yang ditambahkan.
*/

    public void addLast(T data){
        Node<T> baru  = new Node<T>(data);
        if(isEmpty()){
            head = tail = baru;
            return;
        }

        tail.next = baru;
        baru.prev = tail;
        tail = baru;
    }
    
    public void addFirst(T data){
        Node<T> baru  = new Node<T>(data);
        if(head == null){
            head = tail = baru;
            return;
        }
        baru.next=head;
        head.prev=baru;
        head=baru;
    }
    public void print(){}

   /* 
        Method isEmpty() adalah method yang sifatnya public sehingga bisa diakses oleh class
        manapun. Method ini berfungsi untuk mengecek apakah ada elemen di dalam linkedlist atau tidak
   */ 

    public boolean isEmpty(){
        return head ==null;
    }
    
   /*
        Method removefirst() adalah method yang sifatnya public sehingga dapat diakses oleh 
        class manapun. Method ini digunakan untuk menghapus data paling depan atau yang ditunjuk
        oleh pointer head.
        Jika linkedlist dalam keaadaan kosong maka tidak perlu ada elemen yang di hapus, pengecekan
        dilakukan dengan menanfaatkan method isempty()
        Namun jika linkedlist tidak kosong maka pindahkan head ke elemen di sebelahnya. 

   */ 
    public void removefirst(){
        if(isEmpty())
            return;
        head = head.next;
    }

    public Node<T> getHead(){
        return head;
    }
}


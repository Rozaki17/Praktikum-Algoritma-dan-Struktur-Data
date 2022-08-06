package Modul_5.Project;

/* 
    Membuat class dengan nama "Node" yang dimana class ini bertipe public, sehingga bisa diakses dari
    kelas manapun. Kelas node ini tergolong dalam generic class yang di mana memungkinkan class menjadi 
    tipe parameter dengan berbagai macam tipe.
    <T> Yang berarti Tipe Parameter yang digunakan untuk menentukan jenis tipe data yang ingin gunakan pada 
    variable atau atribut didalamnya, T bisa kita ubah menjadi tipe data apa saja, seperti Integer, String, 
    Boolean, Character, Float, Byte, dll.
*/

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

 /*  Membuat sebuah constructor dari class Node yang dimana ini merupakan 
     method yang dipanggil pertama saat pembuatan objek nantinya.
*/
    public Node(T data){
        this.data = data;
    }
}

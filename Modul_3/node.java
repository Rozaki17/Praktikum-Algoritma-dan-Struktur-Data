package Modul_3;

//berikut merupakan class yang digunakan untuk membuat tipe data node, yang dimana node akan menjadi penampung data dari tree yang
//akan kita buat. disini data yang ada dalam node bertipa String, karena kita akan menyimpan nama nantinya
public class node {
    //berikut merupakan deklarasi variabel nama bertipe data string yang akan digunakan menyimpan nama dari anggota keluarga
    //yang nantinya akan kita buatkan silsilah keluarganya menggunakan konsep tree
    String nama;
    //berikut merupakan deklarasi variabel left dan right, yang mana merupakan sebagai pointer untuk penunjuk bahwa sebuah parent node
    //memiliki dua buah child, yaitu disebut sebagai left dan right
    node left, right;

    //berikut merupakan constructor yang merupakan pengisi dari data nama pada setiap node yang dibuat objeknya pada class manapun
    //menggunakan node ini
    node (String nama){
        //berikut merupakan syntax proses pengisian nilai data nama pada setiap node yang dibuat, penggunaan this artinya bahwa menandakan 
        //variabel tersebut merupakan variabel dari node yang akan diisi namun karena nama variabel nya sama dengan parameter constructor nya
        //oleh karena itu menggunakan this
        this.nama = nama;
    }
}

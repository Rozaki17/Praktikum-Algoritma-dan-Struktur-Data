package Modul_1;

/*
Syntax berikut merupakan syntax yang digunakan untuk mengimport atau memasukkan library scanner kedalam
program kita sehingga kita bisa memasukkan data secara dinamis
*/
import java.util.Scanner;
/*
Class untuk membuat linked list, yang dimana class ini akan memanfaatkan class node tadi dengan membuat objeknya sebagai isi
dari linked list yang akan dibuat sehingga kita bisa membuat sebuah linked list dari kumpulan node node tadi.
Di dalam class LinkedList ini terdapat sebuah penunjuk bantuan juga, yang berguna untuk membantu kita dalam
mengakses isi dari pada linked list kita yang sudah kita buat nantinya, serta terdapat beberapa method yang terdapat
dalam linked list ini sehingga kita bisa melakukan perubahan, hapus, tambah data dsb pada linked list yang kita miliki.
*/
class Linkedlist {
    /*
    Node head adalah penunjuk yang berguna menandai data pertama atau teratas dari linked list yang dibuat dan current adalah 
    penunjuk bantuan yang berguna untuk mengakses semua node yang ada pada linked list yang dibuat secara satu persatu
    */
    Node head, current;
    /*
    Method ini merupakan method yang digunakan untuk memasukkan data pada linked list yang akan dibuat
    */
    void insert (String data){
        /*
        Akan dicek apakah head kosong atau tidak, jika kosong maka data baru yang masuk akan menjadi head itu sendiri
        */
        if (head == null){
            head = new Node(data);
        /*
        Jika tidak maka, posisikan current pada head lalu stop jika sampai dimana next dari node yang ditempati
        current kosong maka disanalah buat objek baru lalu hubungkan dengan next yang kosong tadi
        */
        }else{
            current = head;

            while(current.next != null){
                current = current.next;
            }
            Node tmp = new Node(data);
            current.next = tmp;
            tmp.prev = current;
        }
    }
    /*
    Method berikut merupakan method yang digunakan untuk melakukan prosez perubahan data pemain pada
    linked list yang sudah dibuat dengan adanya 2 parameter, yaitu untuk masukan index berapa yaitu pertandingan
    yang akan diganti pemain nya dan masukan palyer yaitu nama pemain pengganti yang akan menggantikan pemain pada
    pertandingan yang akan diganti pemainnya
    */
    void changeData (int index, String player){
        /*
        Posisikan current pada head dari linked list, lalu melakukan looping pada linked list yang ada untuk mencari 
        pada pertandingan berapa yang akan diganti pemainnya
        */
        current = head;
        for (int a = 1; a < index-1; a++){
            current = current.next;
        }
        /*
        Membuat objek baru yang diisi dengan data nama pemain pengganti dari pertandingan yang akan diganti pemainnya
        lalu menghubungkan node pemain baru dengan satu node selanjutnya yang ditunjuk oleh current saaat ini
        lalu hubungkan prev node data baru dengan current lalu hubungkan next dari current dengan node baru
        pindahkan current pada node selanjutnya yg terhubung dengan node baru
        hubungkan prev dari current dengan data baru
        */
        Node tmp = new Node(player);
        tmp.next = current.next.next;
        tmp.prev = current;
        current.next = tmp;
        current = tmp.next;
        current.prev = tmp;
    }
    /*
    Method berikut merupakan method yang digunakan untuk menampilkan pertandingan sebelum dilakukan pertukaran pemain pada 
    pertandingan yang ingin berganti pemain
    */
    void showMatchBefore (){
        /*
        posisikan head pada node selanjutnya dari head karena pemain dari head, sudah bermain maka tidak ditampilkan
        variabel counter digunakan untuk melakukan perhitungan urutan jumlah pertandingan yang ada  
        */
        current = head;
        int counter = 0;
        /*
        Syntax ini digunakan untuk menampilkan judul pada tampilan terminal yaitu Jadwal pertandingan
        */
        System.out.println("\n\t\tJadwal pertandingan Awal");
        /*
        jika node yang ditunjuk current tidak null maka current akan terus menunjuk ke node selanjutnya sampai
        berhenti jika sudah menunjuk node yang kosong sekaligus menampilkan data ari node yang sudah dilewati oleh current
        satu persatu
        */
        while(current != null){
            ++counter;
            System.out.println("Pertandingan " + counter + " : " + current.data);
            current = current.next;
        }
        System.out.println();
    }
    /*
    Method ini merupakan method yang digunakan untuk menampilkan pertandingan setelah dilakukan pertukaran urutan pertandingan        
    */
    void showMatchAfter (){
        /*
        posisikan head pada node selanjutnya dari head karena pemain dari head, sudah bermain maka tidak ditampilkan
        variabel counter digunakan untuk melakukan perhitungan urutan jumlah pertandingan yang ada  
        */
        current = head;
        int counter = 0;
        /*
        Syntax ini digunakan untuk menampilkan judul pada tampilan terminal yaitu Jadwal pertandingan saat ini / terbaru
        */
        System.out.println("\n\t\tJadwal pertandingan saat ini");
        /*
        jika node yang ditunjuk current tidak null maka current akan terus menunjuk ke node selanjutnya sampai
        berhenti jika sudah menunjuk node yang kosong sekaligus menampilkan data ari node yang sudah dilewati oleh current
        satu persatu
        */
        while(current != null){
            ++counter;
            System.out.println("Pertandingan " + counter + " : " + current.data);
            current = current.next;
        }
        System.out.println();
    }
}
/*
Class berikut merupakan class dari file yang ada yang bernama Jurnal2 yang berguna untuk mewadahi class main
*/
public class Jurnal2 {
    /*
    class berikut merupakan class main yang dimana class yang berisi segala sesuatu yang akan dieksekusi oleh
    program ketika program dijalankan        
    */
    public static void main(String[] args) {
        /*
        syntx berikut merupakan syntax yang digunakan untuk deklarasi secanner yang digunakan agar bisa menginput data
        berdasarkan kehendak user  
        */
        Scanner keyScanner = new Scanner(System.in);
        /*
        berikut merupakan deklarasi pembuatan objek class LinkedList dalam class main ini agar class LinkedList ini
        method-methodnya dapat digunakan dalam fungsi main ini
        */
        Linkedlist ll = new Linkedlist();
        /*
        Syntax berikut digunakan untuk menampilkan di console instruksi memasukkan jumlah pertandingan, sehingga user bisa lebih
        terarah dalam memasukkan data yang dibutuhkan
        */
        System.out.print("Masukkan Jumlah Pertandingan : ");
        int totalMatch = keyScanner.nextInt();
        /*
        Syntax berikut merupakan deklarasi data variabel player yang digunakan untuk menyimpan nama dari setiap pertandingan
        */
        String[] player = new String[totalMatch];
        /*
        Looping yang digunakan untuk memasukkan nama nama pemain dari setiap pertandingan dengan menggunakan looping for dari a = 0
        sampai dengan jumlah total pertandingan yang sudah dimasukkan user
        */
        for (int a = 0; a < totalMatch; a++){
            System.out.print("Masukkan Nama player Match " + (a+1) + " : ");
            player[a] = keyScanner.nextLine();
            player[a] += keyScanner.nextLine();
            ll.insert(player[a]);
        }
        /*
        Syntax berikut digunakan untuk menampilkan di console instruksi memasukkan pertandingan yang akan berganti pemain dan akan 
        digantikan oleh siapa  
        */
        System.out.print("\nMasukkan Pertandingan keberapa yang akan berganti Pemain : ");
        int changePlayermatch = keyScanner.nextInt();
        System.out.print("Akan digantikan oleh : ");
        String changeWithPlayer = keyScanner.nextLine();
        changeWithPlayer += keyScanner.nextLine();
        /*
        Syntax berikut digunakan untuk memanggil class LinkedList yang sudah dibuat objeknya sebelumnya dengan nama sll
        lalu menggunakan method-method yang ada pada class LinkedList itu sendiri seperti ShowMatchBefore, changeData
        dan showMatchAfter dll.
        */
        ll.showMatchBefore();
        ll.changeData(changePlayermatch, changeWithPlayer);
        ll.showMatchAfter();
        /*
        Syntax berikut digunakan untuk menutup scanner yang telah kita deklarasikan dan gunakan sebelumnya agar tidak
        source leak
        */
        keyScanner.close();
    }
}

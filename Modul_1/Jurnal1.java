package Modul_1;

/*
Syntax berikut merupakan syntax yang digunakan untuk mengimport atau memasukkan library scanner kedalam
program kita sehingga kita bisa memasukkan data secara dinamis
*/
import java.util.Scanner;
/*
Class untuk membuat node, yaitu elemen yang ada dalam sebuah linked list yang berisi data dengan tipe data string, 
pointer yang menunjuk/mengarahkan kepada node selanjutnya dan juga sebelumnya dan terdapat sebuah konstraktor yang berguna
sebagai pengisi dari data pada node, yang prinsip kerjanya setiap kali membuat objek node maka data akan dimasukkan ke dalam
konstraktor sehingga data baru bisa terisi kedalam node.
*/
class Node {
    /* 
    string data adalah data pada node yang bertipe string, yang berfungsi untuk menyimpan data yang berupa kata atau
    kalimat
    */
    String data;
    /*
    Node next adalah penunjuk yang berguna menunjuk kepada node selanjutnya dari posisi saat ini dan prev adalah penunjuk juga
    berguna menunjuk node sebelum posisi saat ini
    */
    Node next, prev;
    /*
    Method in merupakan konstraktor dari class Node ini, yang berguna mengisi data baru setelah membuat objek Node kedalam variabel
    data dari Node itu sendiri
    */
    Node(String Data){
        data = Data;
    }
}
/*
Class untuk membuat linked list, yang dimana class ini akan memanfaatkan class node tadi dengan membuat objeknya sebagai isi
dari linked list yang akan dibuat sehingga kita bisa membuat sebuah linked list dari kumpulan node node tadi.
Di dalam class SingleLinkedList ini terdapat sebuah penunjuk bantuan juga, yang berguna untuk membantu kita dalam
mengakses isi dari pada linked list kita yang sudah kita buat nantinya, serta terdapat beberapa method yang terdapat
dalam linked list ini sehingga kita bisa melakukan perubahan, hapus, tambah data dsb pada linked list yang kita miliki.
*/
class SingleLinkedList{
    /*
    Node head adalah penunjuk yang berguna menandai data pertama atau teratas dari linked list yang dibuat dan current adalah 
    penunjuk bantuan yang berguna untuk mengakses semua node yang ada pada linked list yang dibuat secara satu persatu
    */
    Node head, current;
    /*
    Method ini merupakan method yang digunakan untuk memasukkan data kedalam linked list yang dibuat
    */
    void push (String data){
        /*
        Akan dicek apakah head kosong atau tidak, jika kosong maka data baru yang masuk akan menjadi head itu sendiri
        */
        if (head == null){
            head = new Node(data);
        /*
        Jika tidak maka, akan dibuat objek baru yang diisi dengan data baru tadi lalu akan dihubungkan dengan node lain 
        yang sudah ada pada linked list yang dibuat sebelumnya dan memindahkan head dari linked list kepada node baru
        yang ada
        */
        }else {
            Node tmp = new Node(data);
            tmp.next = head;
            head = tmp;
        }
    }
    /*
    Method in merupakan method yang digunakan untuk mengambil nilai teratas dari linked list yang ada dengan menggunakan
    fungsi return
    */
    String peek (){
        return head.data;
    }
    /*
    Method ini merupakan method yang digunakan untuk menghapus data paling atas atau terbaru dari linked list yang
    sudah dibuat dengan memindahkan head ke node selanjutnya
    */
    void pop (){
        head = head.next;
    }
    /*
    Method ini merupakan method yang digunakan untuk mengecek apakah linked list yang ada kosong atau tidak dengan cukup
    hanya mengecek head nya, jika headnya kosong maka akan direturn true, jika tidak maka direturn false
    */
    boolean empty (){
        if (head == null){
            return true;
        }
        return false;
    }
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
            current.next = new Node(data);
        }
    }
    /*
    Method ini merupakan method yang digunakan untuk melakukan proses penggantian pemain yang diinginkan oleh user
    berdasarkan inputan dari user
    */
    void changePlayer (int P1, int P2){
        /*
        Syntax ini merupakan proses membuat objek baru dari class SingleLinkedList yang diberi nama tmp
        yang berguna untuk menyimpan linked list untuk sementara
        */
        SingleLinkedList tmp = new SingleLinkedList();
            /*
            posisikan current pada head sebelum memulai looping
            */
            current = head;
            for (int a = 1; a < P2-1; a++){
                current = current.next;
            }
            /*
            memasukkan data yang ditunjuk oleh current kedalam linked list sementara menggunakan method insert
            lalu menghubungkan node yang ditunjuk current dengan data 1 node setelahnya
            */
            tmp.insert(current.next.data);
            current.next = current.next.next;
            /*
            posisikan current pada head sebelum memulai looping
            */
            current = head;
            for (int b = 1; b < P1-1; b++){
                current = current.next;
            }
            /*
            memasukkan data yang ditunjuk oleh current kedalam linked list sementara menggunakan method insert
            lalu menghubungkan node yang ditunjuk current dengan data 1 node setelahnya
            */
            tmp.insert(current.next.data);
            current.next = current.next.next;
            /*
            posisikan current pada head sebelum memulai looping
            */
            current = head;
            for (int a = 1; a < P1-1; a++){
                current = current.next;
            }
            /*
            Buat objek baru dari node yang diisi dengan data head pada stack sementara, lalu hubungkan node baru dengan node
            selanjutnya dari current lalu hubungkan node yang ditunjuk current dengan node baru lalu pindahkan head pada stack
            sementara ke node selanjutnya
            */
            Node temp1 = new Node(tmp.head.data);
            temp1.next = current.next;
            current.next = temp1;
            tmp.head = tmp.head.next;
            /*
            posisikan current pada head sebelum memulai looping
            */
            current = head;
            for (int a = 1; a < P2-1; a++){
                current = current.next;
            }
            /*
            Buat objek baru yang diisi dengan head dari stack sementara lalu hubungkan node baru dengan node selanjutnya yang ditunjuk current
            lalu hubungkan node yang ditunjuk current dengan node baru
            */
            Node temp2 = new Node(tmp.head.data);
            temp2.next = current.next;
            current.next = temp2;
    }
    /*
    Method ini merupakan method yang digunakan untuk menampilkan pertandingan sebelum dilakukan pertukaran urutan pertandingan        
    */
    void showMatchBefore (){
        /*
        posisikan head pada node selanjutnya dari head karena pemain dari head, sudah bermain maka tidak ditampilkan
        variabel counter digunakan untuk melakukan perhitungan urutan jumlah pertandingan yang ada  
        */
        current = head.next;
        int counter = 0;
        /*
        Syntax ini digunakan untuk menampilkan judul pada tampilan terminal yaitu Jadwal pertandingan
        */
        System.out.println("\n\t\tJadwal pertandingan (Ginting sudah main)");
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
        current = head.next;
        int counter = 0;
        /*
        Syntax ini digunakan untuk menampilkan judul pada tampilan terminal yaitu Jadwal pertandingan saat ini / terbaru
        */
        System.out.println("\n\t\tJadwal pertandingan saat ini (Pergantian urutan pertandingan)");
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
Class berikut merupakan class dari file yang ada yang bernama Jurnal1 yang berguna untuk mewadahi class main
*/
public class Jurnal1 {
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
        berikut merupakan deklarasi pembuatan objek class SingleLinkedList dalam class main ini agar class SingleLinkedList ini
        method-methodnya dapat digunakan dalam fungsi main ini
        */
        SingleLinkedList sll = new SingleLinkedList();
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
            player[a] = keyScanner.next();
            player[a] += keyScanner.nextLine();
            sll.insert(player[a]);
        }
        /*
        Syntax berikut digunakan untuk menampilkan di console instruksi memasukkan pertandingan yang akan diganti dan akan digantikan
        dengan pertandingan keberapa  
        */
        System.out.print("Pertandingan yang akan diganti : ");
        int match = keyScanner.nextInt();
        System.out.print("Akan diganti dengan pertandigan ke-");
        int matchChange = keyScanner.nextInt();
        /*
        Syntax berikut digunakan untuk memanggil class SingleLinkedList yang sudah dibuat objeknya sebelumnya dengan nama sll
        lalu menggunakan method-method yang ada pada class SingleLinkedList itu sendiri seperti ShowMatchBefore, changePlayer
        dan showMatchAfter dll.
        */
        sll.showMatchBefore();
        sll.changePlayer(match, matchChange);
        sll.showMatchAfter();
        /*
        Syntax berikut digunakan untuk menutup scanner yang telah kita deklarasikan dan gunakan sebelumnya agar tidak
        source leak
        */
        keyScanner.close();
    }
}

package Modul_3;

import java.util.*;

//class dibawah merupakan class dimana main akan bertempat, yang dimana main merupakan method yang akan dieksekusi oleh program pada
//saat kita mnejalankan program kita
public class Main {
    //berikut merupakan method main yang akan dieksekusi oleh program, karena main method merupakan inti dari program yang kita buat
    public static void main(String[] args) {
        //berikut merupakan deklarasi pembuatan objek baru dari class Tree yang ada pada file lain, dengan nama variabel objek t pada method main
        //ini
        Tree t = new Tree();
        Scanner keyScanner = new Scanner(System.in);

        //berikut merupakan code untuk memasukkan nama nama anggota keluarga kedalam tree yang ada seperti pada soal jurnal
        //memasukkan secara 3 nama sekaligus agar memudahkan kita dalam membuat method untuk membuat silsilah keluarganya kedalam tree
        t.addNode("Uno", "Alita", "Dewi");
        t.addNode("Alita", "Putri", "Pangeran");
        t.addNode("Putri", "Rifki", "Alfiana");
        t.addNode("Pangeran", "Rozaki", "Wahyu");
        t.addNode("Dewi", "Kholilul", "Habib");
        t.addNode("Kholilul", "Rizki", "Adit");
        t.addNode("Habib", "Yogi", "Nadya");

        //berikut merupakan code untuk memasukkan percobaan pencarian hubungan keluarga antara dua nama yang dimasukkan
        //disini dimasukkan secara statis agar mempermudah kita dalam mencari hubungan antara 2 orang
        t.cariHubungan("Dewi", "Uno");
        t.cariHubungan("Uno", "Nadya");
        t.cariHubungan("Rizki", "Yogi");
        t.cariHubungan("Habib", "Uno");
        t.cariHubungan("Pangeran", "Dewi");
        t.cariHubungan("Wahyu", "Dewi");
        t.cariHubungan("Uno", "Habib");
        t.cariHubungan("Wahyu", "Kholilul");
        t.cariHubungan("Arsyad", "Ela");

        keyScanner.close();
    }
}

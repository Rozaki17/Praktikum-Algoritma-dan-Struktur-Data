package Modul_2;

public class Main1 {
    public static void main(String[] args) {    //ini merupakan class utama yang akan dieksekusi oleh program ketika dijalankan dan
                                                //hanya disini program yang akan dibaca ketika kita mulai manjalankan program
        Jurnal1 dll1 = new Jurnal1();   //ini merupakan pembuatan objek baru dari class Jurnal1 dengan nama dll1
        Pemain[] player = new Pemain[8];    //ini merupakan pembuatan objek baru dari class pemain dengan nama player
        
        //dibawah merupakan syntax untuk memasukkan judul novel pada objek objek novel 
        //yang telah dibuat dibawah sebanyak 18 data
        player[0] = new Pemain("Mukhlis", 180, 50);
        player[1] = new Pemain("Anto", 176, 40);
        player[2] = new Pemain("Kaka", 155, 33);
        player[3] = new Pemain("Joko", 162, 39);
        player[4] = new Pemain("Faris", 167, 41);
        player[5] = new Pemain("Kiki", 158, 35);
        player[6] = new Pemain("Dika", 179, 45);
        player[7] = new Pemain("Brian", 185, 20);

        for (int a = 0; a < 8; ++a){
            dll1.insert(player[a]);     // ini merupakan proses untuk memasukkan data data dari pemain yang sudah dimasukkan dahulu ke dalam
                                        //objek objek pemain diatas lalu dimasukkan kedalam linked list yang akan kita buat sebagai node
        }
        
        //ini merupakan fungsi untuk memanggil objek Jurnal1 lalu memanggil method yang ada pada 
        //objek jurnal1 yaitu printronde1, printronde2 dan printronde3
        dll1.printRonde1();
        dll1.printRonde2();
        dll1.printRonde3();
    }
}

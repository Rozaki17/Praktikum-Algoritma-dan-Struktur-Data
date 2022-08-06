package Modul_2;

public class Main2 {
    public static void main(String[] args) {    //ini merupakan class utama yang akan dieksekusi oleh program ketika dijalankan dan
                                                //hanya disini program yang akan dibaca ketika kita mulai manjalankan program
        Jurnal2 dll2 = new Jurnal2();   //ini merupakan pembuatan objek baru dari class Jurnal2 dengan nama dll2
        Novel[] judul = new Novel[18];  //ini merupakan pembuatan objek baru dari class Novel dengan nama judul

        //dibawah merupakan syntax untuk memasukkan judul novel pada objek objek novel 
        //yang telah dibuat dibawah sebanyak 18 data
        judul[0] = new Novel("Suratan si Tangan Kecil");
        judul[1] = new Novel("Dibalik Dua Hati");
        judul[2] = new Novel("Air Mata Bahagia");
        judul[3] = new Novel("Apakah Ia Mengerti?");
        judul[4] = new Novel("Senyuman Pujaan");
        judul[5] = new Novel("Seorang Bidadari");
        judul[6] = new Novel("Cakrawala Petualang");
        judul[7] = new Novel("Kodingan Cinta"); 
        judul[8] = new Novel("Lihatlah yang Dibawah");
        judul[9] = new Novel("Menyerah atau Kalah?");
        judul[10] = new Novel("Berjuang walau Tertebas Pedang");    
        judul[11] = new Novel("Teman tak Tergantikan");
        judul[12] = new Novel("Lawakan Pinggiran Kota");
        judul[13] = new Novel("Samudera Perjuangan");
        judul[14] = new Novel("Mahasiswa Kocak");
        judul[15] = new Novel("Jangan Tersandung Kerikil");
        judul[16] = new Novel("Butiran Semangat");
        judul[17] = new Novel("Embun Kemenangan");

        for (int a = 0; a < 18; ++a){
            dll2.insert(judul[a]);  // ini merupakan proses untuk memasukkan data data dari judul buku yang sudah dimasukkan dahulu ke dalam
                                    //objek objek novel diatas lalu dimasukkan kedalam linked list yang akan kiat buat sebagai node
        }

        dll2.sequenceSearch("Seorang Bidadari");    //ini merupakan fungsi untuk memanggil objek Jurnal2 lalu memanggil method yang ada pada 
                                                    //objek jurnal2 yaitu sequencesearch
        System.out.println("\n");
        dll2.binarySearchsort("Menyerah atau Kalah?");  //ini merupakan fungsi untuk memanggil objek Jurnal2 lalu memanggil method yang ada pada 
                                                        //objek jurnal2 yaitu binarySearchsort
    }
}

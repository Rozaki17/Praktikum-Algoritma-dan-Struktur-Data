package Modul_2;    //ini merupakan untuk memberikan akses kepada file ini agar bisa mengakses file-file yang ada pada folder
                    //modul_2

public class Jurnal1 {
    Node head, tail, current, start, sorted;    //ini merupakan deklarasi variabel head, tail dan current dengan tipa data node yang berguna menjadi
                                                //pointer untuk linked list yg kita punya
    boolean cekTukar;   //ini merupakan deklarasi variabel untuk mengecek ada atau tidak judul buku yang dicari
                        //pada sequential search

    void insert (Pemain data){  //ini merupakan class untuk memasukkan data judul buku drai novel novel yang ada
        if (head == null){  //ini merupakan kondisi jika head nya null maka node baru akan menjadi head sekaligus tail nya yang 
                            // dimana node nya diisi dengan data nama judul novel
            head = tail = new Node(data);
        }else{  // ini merupakan kondisi selain dari jika, jika kondisi diatas tidak terpenuhi maka akan masuk ke kondisi ini yaitu untuk
                //memasukkan node baru lagi menyambung dari node yang ada yaitu head dst.
            current = head;

            while (current.next != null){
                current = current.next;
            }
            Node tmp = new Node(data);
            current.next = tmp;
            tmp.prev = current;
            tail = tmp; 
        }
    }

    void printRonde1(){     //ini merupakan method untuk menampikan pemain pemain dari ronde 1 berdasarkan dari nama absen nya
        boolean cekTukar = true;
        current = head;

        while (cekTukar){   //ini merupakan untuk melakukan perulangan sorting pada linked list yang ada, akan melakukan perulangan
                            //selama nilai dari cekTukar == true
            current = head;
            cekTukar = false;
            while (current != tail){
                String tmp1 = current.dataPemain.nama;
                String tmp2 = current.next.dataPemain.nama;
                if (tmp1.compareTo(tmp2) > 0){      //ini merupakan kondisi jika nama judul pertama yang akan diurutkan lebih besar dari nama
                                                    //buku kedua yang akan diurutkan
                    Pemain tmp = current.dataPemain;
                    current.dataPemain = current.next.dataPemain;
                    current.next.dataPemain = tmp;
                    cekTukar = true;
                }
                current = current.next;
            }
        }

        current = head;
        //dibawah merupakan untuk menampilkan data pemain pada ronde 1 yang diurutkan berdasarkan urutan nama absennya
        System.out.println("---------------");
        System.out.println("    Ronde 1    ");
        System.out.println("---------------");
        System.out.println("Berdasarkan Absen");
        while (current != null){
            if (current != head){
                System.out.print(" <- ");
            }
            //ini merupakan format menampilkan data nama pemain yang akan ditampilkan pada terminal
            System.out.printf("%s (%dcm, %dp)", current.dataPemain.nama, current.dataPemain.tinggi, current.dataPemain.power);
            current = current.next;
        }
    }

    void printRonde2 (){    //ini merupakan method untuk menampikan pemain pemain dari ronde 1 berdasarkan dari tinggi badannya
        Node current, start, min;
        boolean cekTukar = true;
        current = head;
        start = current;
        min = start;

        while (cekTukar){   //ini merupakan untuk melakukan perulangan sorting pada linked list yang ada, akan melakukan perulangan
                            //selama nilai dari cekTukar == true
            current = start;
            cekTukar = false;
            min = current;
            while (current != null){
                if (current.dataPemain.tinggi < min.dataPemain.tinggi){     //ini merupakan kondisi untuk mengecek nilai dari tinggi badan
                                                                            //pemain yang ditunjuk pointer saat ini apakah lebih kecil dari
                                                                            //tinggi badan minimum saat ini
                    min = current;
                    cekTukar = true;
                }else if (min == start){
                    cekTukar = true;
                }
                current = current.next;
            }
            if (min == start){
                if (start.next == null){
                    break;
                }
                start = start.next;
            }else{      //ini merupakan kondisi jika if diatas tidak terpenuhi maka, data pemain yang memiliki tinggi badan terpendek akan
                        //ditukar dengan pemain pada urutan awal saat itu
                Pemain tmp = start.dataPemain;
                start.dataPemain = min.dataPemain;
                min.dataPemain = tmp;
                start = start.next;
            }
        }

        current = head;
        //dibawah merupakan untuk menampilkan data pemain pada ronde 1 yang diurutkan berdasarkan urutan nama tinggi badannya
        System.out.println("\n---------------");
        System.out.println("    Ronde 2    ");
        System.out.println("---------------");
        System.out.println("Berdasarkan Tinggi Badan");
        while (current != null){
            if (current != head){
                System.out.print(" <- ");
            }
            //ini merupakan format menampilkan data nama pemain yang akan ditampilkan pada terminal
            System.out.printf("%s (%dcm, %dp)", current.dataPemain.nama, current.dataPemain.tinggi, current.dataPemain.power);
            current = current.next;
        }
    }

    void printRonde3 (){    //ini merupakan method untuk menampikan pemain pemain dari ronde 1 berdasarkan dari power yang dimilikinya
        sorted = null;
        current = head;
        //mengubah linked list yang ada dan memasukkan setiap node ke yang sudah
        //disort
        while (current != null){
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sorted;

        current = head;
        //dibawah merupakan untuk menampilkan data pemain pada ronde 1 yang diurutkan berdasarkan power yang dimilikinya
        System.out.println("\n---------------");
        System.out.println("    Ronde 3    ");
        System.out.println("---------------");
        System.out.println("Berdasarkan Power");
        while (current != null){
            if (current != head){
                System.out.print(" <- ");
            }
            //ini merupakan format menampilkan data nama pemain yang akan ditampilkan pada terminal
            System.out.printf("%s (%dcm, %dp)", current.dataPemain.nama, current.dataPemain.tinggi, current.dataPemain.power);
            current = current.next;
        }
    }

    void sortedInsert (Node newnode){   //ini merupakan method untuk memasukkan node baru kedalam sebuah list baru
        if (sorted == null || sorted.dataPemain.power >= newnode.dataPemain.power){ // ini merupakan kondisi untuk mengecek jika sorted kosong atau
                                                                                    //power dari pemain yang sudah di sort lebih besar atau sama dengan 
                                                                                    //power node baru
            newnode.next = sorted;
            sorted = newnode;
        }else{
            current = sorted;

            while (current.next != null && current.next.dataPemain.power < newnode.dataPemain.power){   // ini merupakan kondisi untuk mengecek jika node yang ditunjuk
                                                                                                        //current kosong dan power dari pemain current lebih kecil dari
                                                                                                        //power node baru  
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }
}
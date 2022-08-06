package Modul_2;    //ini merupakan untuk memberikan akses kepada file ini agar bisa mengakses file-file yang ada pada folder
                    //modul_2

public class Jurnal2 {  //ini merupakan class jurnal2 sebagai class untuk membuat linked list nya disertai beberapa method yang ada
                        //di dalamnya
    Node head, tail, current;   //ini merupakan deklarasi variabel head, tail dan current dengan tipa data node yang berguna menjadi
                                //pointer untuk linked list yg kita punya
    boolean cekAda = false, cekTukar = true;    //ini merupakan deklarasi variabel untuk mengecek ada atau tidak judul buku yang dicari
                                                //pada sequential search
    int awal, akhir, mid, size = 0; //ini merupakan deklarasi variabel awal, akhir, mid dan size yang digunakan untuk proses sorting dan
                                    // searching yang ada pada class ini

    void insert (Novel data){   //ini merupakan class untuk memasukkan data judul buku drai novel novel yang ada
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
        ++size; // ini merupakan sebagai penghitung jumlah/ukuran dari linked list yang ada, jadi setiap memasukkan node baru
                //maka akan dihitung bertmbah satu dst
    }

    void sequenceSearch (String Find){  // ini merupakan method untuk mencari data secara sequence, yaitu mencari kepada setiap data yang
                                        //ada pada linked list data yang dicari
        current = head;

        while (current != null){
            if (current.dataBuku.judul == Find){    // ini merupakan kondisi untuk mengecek jika judul novel yang dicari ada pada
                                                    //linked list yang ada, maka akan ditampilkan ada dan dihentikan perulangannya 
                System.out.printf("Novel berjudul '%s' ada", current.dataBuku.judul);
                cekAda = true;
                break;
            }
            current = current.next;
        }
        if (!cekAda){ // ini merupakan kondisi untuk mengecek apakah data yang dicari apakah tidak ada pada linked list yang
                    // ada, maka akan ditampilkan novel yang dicari tidak ada
            System.out.printf("Novel berjudul '%s' tidak ada", Find);
        }
    }

    void binarySearchsort (String Find){    //ini merupakan method untuk men sorting judul judul nama novel yang ada berdasarkan
                                            //namanya, menggunakan built in function compareto.
        String tmp1, tmp2;
        current = head;
        while (cekTukar){
            current = head;
            cekTukar = false;
            while (current != tail){
                tmp1 = current.dataBuku.judul;
                tmp2 = current.next.dataBuku.judul;
                if (tmp1.compareTo(tmp2) > 0){  //ini merupakan kondisi jika nama judul pertama yang akan diurutkan lebih besar dari nama
                                                //buku kedua yang akan diurutkan
                    Novel tmp = current.dataBuku;
                    current.dataBuku = current.next.dataBuku;
                    current.next.dataBuku = tmp;
                    cekTukar = true;
                }
                current = current.next;
            }
        }
        awal = 0;
        akhir = size-1;
        mid = (akhir/2);    //ini merupakan untuk mencari data tengah dari linked list yang sudah ada dan sudah diurutkan tadi dengan menerapkan
                            // konsep binary search
        binarySearch(mid, Find);    //ini merupakan fungsi untuk memanggil method binarySearch
    }

    void binarySearch (int index, String Find){ // ini merupakan class yang digunakan untuk mencari judul novel yang akan dicari diantara kumpulan
                                                //novel novel yang ada
        current = head;

        for (int a = 0; a < index-1; ++a){
            current = current.next;
        }

        if (Find.compareTo(current.dataBuku.judul) > 0){    // ini merupakan kondisi untuk mengecek apakah judul dari buku yang dicari lebih besar
                                                            //buku yang ada pada posisi yang ditunjuk saat ini
            awal = mid+1;
            mid = (awal + akhir) / 2;
            binarySearch(mid, Find);    //ini merupakan untuk mencari lagi posisi buku yang akan dicari pada linked yang ada setelah
                                        // pencarian pada data tengah pertama tidak ada
        }else if (Find.compareTo(current.dataBuku.judul) < 0){
            akhir = mid-1;
            mid = (awal + akhir) / 2;
            binarySearch(mid, Find);    //ini merupakan untuk mencari lagi posisi buku yang akan dicari pada linked yang ada setelah
                                        // pencarian pada data tengah pertama tidak ada
        }else if (Find.compareTo(current.dataBuku.judul) == 0){
            System.out.printf("Novel berjudul '%s' ada", Find);
            return; //ini merupakan fungsi kembali atau keluar dari perulangan rekursif yang ada sehingga nilai yang sudah ditemukan bisa
                    //ditampilkan dan keluar dari method ini
        }else{
            System.out.printf("Novel berjudul '%s' tidak ada", Find);
        }
    }
}

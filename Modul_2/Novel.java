package Modul_2;    //syntax ini merupakan syntax agar kita bisa mengakses file file yang ada di folder modul_2

class Novel {   //class ini merupakan class untuk membuat data dari Novel yang akan menjadi isi dari Node pada linked list nantinya
    String judul;   //ini merupakan deklarasi variabel judul, yang digunakan untuk menyimpan data judul buku novel dengan tipe data string
    
    Novel (String judul){   //ini merupakan constructor dari variabel judul, yang dimana constructor akan mengisi data dari dataBuku dengan
                            //judul ini
        this.judul = judul; //ini merupakan proses dari constructor Novel dengan memasukkan judul ke dalam data pada
                            //Novel yang ada
    }
}

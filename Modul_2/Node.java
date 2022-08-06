package Modul_2;    //syntax ini merupakan syntax agar kita bisa mengakses file file yang ada di folder modul_2

class Node {    //class ini merupakan class untuk membuat node yang akan menjadi isi dari linked list nantinya
    Pemain dataPemain;  //ini merupakan deklarasi variabel dataPemain dengan tipe data pemain yang merupakan class
    Novel dataBuku; //ini merupakan deklarasi variabel dataBuku dengan tipe data Novel yang merupakan class
    Node next, prev; //ini merupakan deklarasi variabel next dan prev yang merupakan variabel untuk menyimpan data alamat dari node selanjutnya
                    //pada linked list yang ada

    Node(Pemain dataPemain){    //ini merupakan constructor dari variabel dataPemain, yang dimana constructor akan mengisi data dari node dengan
                                //dataPemain ini
        this.dataPemain = dataPemain;   //ini merupakan proses dari constructor dataPemain dengan memasukkan dataPemain ke dalam data pada
                                        //node yang ada
    }

    Node(Novel dataBuku){   //ini merupakan constructor dari variabel dataBuku, yang dimana constructor akan mengisi data dari node dengan
                            //dataBuku ini
        this.dataBuku = dataBuku;   //ini merupakan proses dari constructor dataBuku dengan memasukkan dataBuku ke dalam data pada
                                    //node yang ada
    }
}

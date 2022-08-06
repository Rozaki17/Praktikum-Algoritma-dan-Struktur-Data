package Modul_2;    //syntax ini merupakan syntax agar kita bisa mengakses file file yang ada di folder modul_2

class Pemain {  //class ini merupakan class untuk membuat class pemain yaitu class untuk membuat objek dataPemain yang
                //akan dimasukkan ke node nantinya
    String nama;    //ini merupakan deklarasi variabel nama dengan tipe data integer untuk menyimpan nama pemain dari variabel dataPemain
    int tinggi, power;  //ini merupakan deklarasi variabel tinggi dan power dengan tipe data integer yang dimana tinggi untuk
                        //menyimpan tinggi badan dari pemain, dan power untuk menyimpan kekuatan dari setiap pemain

    Pemain (String nama, int tinggi, int power){    //ini merupakan constructor dari variabel yang ada pada class pemain, yang dimana 
                                                    //constructor akan mengisi data dari dataBuku dengan judul ini
        this.nama = nama;   //ini merupakan proses dari constructor Pemain dengan memasukkan nama ke dalam data pada
                            //pemain yang ada
        this.tinggi = tinggi;   //ini merupakan proses dari constructor Pemain dengan memasukkan tinggi badan ke dalam data pada
                                //pemain yang ada
        this.power = power;     //ini merupakan proses dari constructor Pemain dengan memasukkan power badan ke dalam data pada
                                //pemain yang ada
    }
    
}
